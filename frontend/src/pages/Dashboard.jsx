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

  const billData = JSON.parse(localStorage.getItem("billData"));

  const downloadReport = () => {

    const doc = new jsPDF();

    doc.setFontSize(20);
    doc.text("BillWise Electricity Analysis Report", 20, 20);

    autoTable(doc, {
      startY: 35,
      head: [["Field", "Value"]],
      body: [
        ["Consumer Name", billData?.consumerName || "N/A"],
        ["Consumer Number", billData?.consumerNumber || "N/A"],
        ["Meter Number", billData?.meterNumber || "N/A"],
        ["Billing Month", billData?.billingMonth || "N/A"],
        ["Total Units", billData?.totalUnits + " kWh" || "N/A"],
        ["Bill Amount", "₹" + billData?.billAmount || "N/A"],
        ["Due Date", billData?.dueDate || "N/A"],
      ],
    });

    doc.save("BillWise_Report.pdf");
  };

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