import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  CartesianGrid,
  ResponsiveContainer,
} from "recharts";

function UsageChart({ billData }) {

  const data = [
    {
      month: billData?.billingMonth || "Current",
      units: Number(billData?.totalUnits) || 0,
    },
  ];

  return (
    <div className="bg-white rounded-2xl shadow-md p-6 mt-8">
      <h2 className="text-2xl font-bold mb-6">
       Monthly Electricity Consumption 
      </h2>

      <ResponsiveContainer width="100%" height={300}>
        <LineChart data={data}>
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="month" />
          <YAxis />
          <Tooltip />
          <Line
            type="monotone"
            dataKey="units"
            stroke="#2563eb"
            strokeWidth={3}
          />
        </LineChart>
      </ResponsiveContainer>
    </div>
  );
}

export default UsageChart;