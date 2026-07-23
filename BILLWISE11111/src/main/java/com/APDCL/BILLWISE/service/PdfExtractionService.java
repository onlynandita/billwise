package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.dto.BillData;
import com.APDCL.BILLWISE.entity.ElectricityBill;
import com.APDCL.BILLWISE.repository.ElectricityBillRepository;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.APDCL.BILLWISE.dto.HistoryData;
import java.util.ArrayList;
import java.util.List;
@Service
public class PdfExtractionService {

    @Autowired
    private ElectricityBillRepository electricityBillRepository;

    public BillData extract(MultipartFile file) throws IOException {

        PDDocument document = Loader.loadPDF(file.getBytes());

        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        System.out.println(text);


        document.close();

        BillData bill = new BillData();
        List<HistoryData> historyList = new ArrayList<>();

        // -------- Extract data from PDF --------

        bill.setConsumerName(
                find(text, "Consumer Name\\s*:?\\s*(.*?)\\s*Consumer Number"));

        bill.setConsumerNumber(
                find(text, "Consumer Number\\s*:?\\s*(\\d+)"));

        bill.setMeterNumber(
                find(text, "Meter Number\\s*:?\\s*(\\S+)"));

        bill.setBillingMonth(
                find(text, "Statement Month\\s*:?\\s*(.*?)\\n"));

        bill.setBillAmount(
                find(text, "Bill Amount\\s*:?\\s*([0-9.]+)"));

        bill.setTotalUnits(
                find(text, "Billable Units in KWh\\s*:?\\s*([0-9.]+)"));

        bill.setDueDate(
                find(text, "Due Date\\s*:?\\s*(.*?)\\n"));
        // -------- Extract Last 6 Statement History --------

        // -------- Extract Last 6 Statement History --------



        String[] lines = text.split("\\r?\\n");

        String[] unitsArr = null;
        String[] billsArr = null;
        String[] rechargeArr = null;

        for (String line : lines) {

            line = line.trim();

            if (line.startsWith("Unit Consumed")) {

                unitsArr = line.replace("Unit Consumed", "")
                        .trim()
                        .split("\\s+");

            }

            if (line.startsWith("Bill Amount (in Rs.)")) {

                billsArr = line.replace("Bill Amount (in Rs.)", "")
                        .trim()
                        .split("\\s+");

            }

            if (line.startsWith("Recharge (in Rs.)")) {

                rechargeArr = line.replace("Recharge (in Rs.)", "")
                        .trim()
                        .split("\\s+");

            }

        }

        if (unitsArr != null && billsArr != null && rechargeArr != null) {

            for (int i = 0; i < 6; i++) {

                HistoryData history = new HistoryData();

                history.setStatement("Stmnt#" + (i + 1));
                history.setUnits(unitsArr[i]);
                history.setBillAmount(billsArr[i]);
                history.setRecharge(rechargeArr[i]);

                historyList.add(history);
            }
        }

        bill.setHistory(historyList);

// Print for checking

        System.out.println("===== HISTORY =====");

        for (HistoryData h : historyList) {

            System.out.println(
                    h.getStatement() + " | " +
                            h.getUnits() + " | " +
                            h.getBillAmount() + " | " +
                            h.getRecharge()
            );
        }



        // -------- Save to Database --------

        ElectricityBill electricityBill = new ElectricityBill();

        electricityBill.setProviderName("APDCL");

        electricityBill.setConsumerName(bill.getConsumerName());

        if (!bill.getConsumerNumber().isEmpty()) {
            electricityBill.setConsumerNumber(
                    Long.parseLong(bill.getConsumerNumber()));
        }

        electricityBill.setStatementMonth(
                bill.getBillingMonth());

        if (!bill.getBillAmount().isEmpty()) {
            electricityBill.setBillAmount(
                    Double.parseDouble(bill.getBillAmount()));
        } else {
            electricityBill.setBillAmount(0.0);
        }

        double units = 0.0;

        if (!bill.getTotalUnits().isEmpty()) {
            units = Double.parseDouble(bill.getTotalUnits());
        }

        electricityBill.setTotalUnits(units);

        electricityBill.setAddress("");

        electricityBill.setBillPeriodStart("");

        electricityBill.setBillPeriodEnd("");

        electricityBill.setConnectedLoadKW(0.0);

        electricityBill.setSanctionedLoadKW(0.0);

        electricityBill.setTotalMonthlyCharge(0.0);

        electricityBill.setOpeningBalance(0.0);

        electricityBill.setRechargeAmount(0.0);

        electricityBill.setFinalBalance(0.0);

        electricityBill.setNumberOfDays(30);

        // -------- AI Calculations --------

        if (units > 0) {

            electricityBill.setAverageDailyUsage(units / 30);

            electricityBill.setEffectiveCostPerUnit(
                    electricityBill.getBillAmount() / units);

        } else {

            electricityBill.setAverageDailyUsage(0.0);

            electricityBill.setEffectiveCostPerUnit(0.0);
        }

        if (electricityBill.getBillAmount() > 5000) {

            electricityBill.setUsageTrend("High");

            electricityBill.setAiSuggestion(
                    "High electricity consumption detected. Consider reducing AC usage and switching off unused appliances.");

        } else if (electricityBill.getBillAmount() > 3000) {

            electricityBill.setUsageTrend("Moderate");

            electricityBill.setAiSuggestion(
                    "Moderate electricity usage. Monitor consumption regularly.");

        } else {

            electricityBill.setUsageTrend("Normal");

            electricityBill.setAiSuggestion(
                    "Electricity usage is normal. Keep maintaining efficient usage.");
        }
        if (!electricityBillRepository
                .findByConsumerNumberAndStatementMonth(
                        electricityBill.getConsumerNumber(),
                        electricityBill.getStatementMonth())
                .isEmpty()) {

            throw new RuntimeException(
                    "Bill for this consumer and statement month already exists."
            );
        }

// -------- Save Bill --------

        electricityBillRepository.save(electricityBill);

        return bill;


    }

    private String find(String text, String regex) {

        Pattern pattern = Pattern.compile(regex,
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1).trim();
        }

        return "";
    }
}
