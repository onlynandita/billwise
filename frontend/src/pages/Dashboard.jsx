import { useEffect, useState } from "react";

import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import DashboardCards from "../components/DashboardCards";
import BillTable from "../components/BillTable";
import UsageChart from "../components/UsageChart";
import ChargePieChart from "../components/ChargePieChart";
import Insights from "../components/Insights";

import jsPDF from "jspdf";
import autoTable from "jspdf-autotable";

function Dashboard() {
  const [billData, setBillData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const getLatestBill = async () => {
      try {
        const response = await fetch(
          "http://localhost:8080/api/bills/latest"
        );

        if (!response.ok) {
          throw new Error("Could not fetch the latest bill.");
        }

        const databaseBill = await response.json();

        if (!databaseBill) {
          throw new Error("No bill was found in the database.");
        }

        /*
          The GET API returns ElectricityBill fields such as:
          statementMonth, totalUnits and billAmount.

          Existing frontend components expect:
          billingMonth, totalUnits and billAmount.
        */
        const uploadedBill = JSON.parse(
          localStorage.getItem("billData") || "{}"
        );

        const formattedBill = {
          ...databaseBill,

          billingMonth:
            databaseBill.statementMonth ||
            uploadedBill.billingMonth ||
            "N/A",

          totalUnits:
            databaseBill.totalUnits ??
            uploadedBill.totalUnits ??
            0,

          billAmount:
            databaseBill.billAmount ??
            databaseBill.totalMonthlyCharge ??
            uploadedBill.billAmount ??
            0,

          consumerName:
            databaseBill.consumerName ||
            uploadedBill.consumerName ||
            "N/A",

          consumerNumber:
            databaseBill.consumerNumber ||
            uploadedBill.consumerNumber ||
            "N/A",

          /*
            meterNumber and dueDate are currently not stored
            inside the ElectricityBill table, so keep them from
            the upload response until those fields are added
            to the backend entity.
          */
          meterNumber:
            databaseBill.meterNumber ||
            uploadedBill.meterNumber ||
            "N/A",

          dueDate:
            databaseBill.dueDate ||
            uploadedBill.dueDate ||
            "N/A",
        };

        setBillData(formattedBill);
      } catch (err) {
        console.error("GET API error:", err);
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    getLatestBill();
  }, []);

  const downloadReport = () => {
    if (!billData) {
      alert("Bill data is not available.");
      return;
    }

    const doc = new jsPDF();

    doc.setFontSize(20);
    doc.text("BillWise Electricity Analysis Report", 20, 20);

    autoTable(doc, {
      startY: 35,
      head: [["Field", "Value"]],
      body: [
        ["Consumer Name", billData.consumerName || "N/A"],
        ["Consumer Number", String(billData.consumerNumber || "N/A")],
        ["Meter Number", billData.meterNumber || "N/A"],
        ["Billing Month", billData.billingMonth || "N/A"],
        [
          "Total Units",
          billData.totalUnits !== null &&
          billData.totalUnits !== undefined
            ? `${billData.totalUnits} kWh`
            : "N/A",
        ],
        [
          "Bill Amount",
          billData.billAmount !== null &&
          billData.billAmount !== undefined
            ? `Rs. ${billData.billAmount}`
            : "N/A",
        ],
        ["Due Date", billData.dueDate || "N/A"],
      ],
    });

    doc.save("BillWise_Report.pdf");
  };

  if (loading) {
    return (
      <>
        <Navbar />

        <section className="bg-gray-100 min-h-screen flex items-center justify-center">
          <p className="text-xl font-semibold text-gray-700">
            Loading bill data...
          </p>
        </section>

        <Footer />
      </>
    );
  }

  if (error) {
    return (
      <>
        <Navbar />

        <section className="bg-gray-100 min-h-screen flex items-center justify-center px-6">
          <div className="bg-white shadow-lg rounded-2xl p-8 text-center">
            <h2 className="text-2xl font-bold text-red-600 mb-3">
              Unable to load dashboard
            </h2>

            <p className="text-gray-700">{error}</p>

            <p className="text-gray-500 mt-3">
              Make sure the Spring Boot backend is running on port 8080.
            </p>
          </div>
        </section>

        <Footer />
      </>
    );
  }

  return (
    <>
      <Navbar />

      <section className="bg-gray-100 min-h-screen py-16 px-6">
        <div className="max-w-7xl mx-auto">
          <h1 className="text-4xl font-bold mb-10">
            Dashboard
          </h1>

          <DashboardCards billData={billData} />

          <BillTable billData={billData} />

          <UsageChart billData={billData} />

          <div className="grid lg:grid-cols-2 gap-8 mt-8">
            <ChargePieChart billData={billData} />

            <Insights billData={billData} />
          </div>

          <div className="mt-10 text-center">
            <button
              onClick={downloadReport}
              className="bg-blue-600 hover:bg-blue-700 text-white px-8 py-4 rounded-xl font-semibold transition"
            >
              📄 Download Analysis Report
            </button>
          </div>
        </div>
      </section>

      <Footer />
    </>
  );
}

export default Dashboard;