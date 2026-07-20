function BillTable({ billData }) {
  const rows = [
    ["Consumer Name", billData?.consumerName || "N/A"],
    ["Consumer Number", billData?.consumerNumber || "N/A"],
    ["Meter Number", billData?.meterNumber || "N/A"],
    ["Billing Month", billData?.billingMonth || "N/A"],
    ["Total Units", billData?.totalUnits ? `${billData.totalUnits} kWh` : "N/A"],
    ["Bill Amount", billData?.billAmount ? `₹${billData.billAmount}` : "N/A"],
    ["Due Date", billData?.dueDate || "N/A"],
  ];

  return (
    <div className="bg-white rounded-2xl shadow-md p-8">
      <h2 className="text-2xl font-bold mb-6">
        Bill Details
      </h2>

      <table className="w-full">
        <tbody>
          {rows.map((row, index) => (
            <tr
              key={index}
              className="border-b"
            >
              <td className="py-4 font-semibold">
                {row[0]}
              </td>

              <td className="py-4 text-right">
                {row[1]}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default BillTable;