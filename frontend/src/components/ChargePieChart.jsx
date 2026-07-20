import {
  PieChart,
  Pie,
  Cell,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

const COLORS = ["#2563eb", "#22c55e", "#f59e0b"];

function ChargePieChart({ billData }) {

  const billAmount = Number(billData?.billAmount) || 0;

  const data = [
    {
      name: "Energy Charge",
      value: billAmount * 0.80,
    },
    {
      name: "Fixed Charge",
      value: billAmount * 0.10,
    },
    {
      name: "Taxes",
      value: billAmount * 0.10,
    },
  ];

  return (
    <div className="bg-white rounded-2xl shadow-md p-6 mt-8">
      <h2 className="text-2xl font-bold mb-6">
        Charge Breakdown
      </h2>

      <ResponsiveContainer width="100%" height={300}>
        <PieChart>
          <Pie
            data={data}
            dataKey="value"
            outerRadius={110}
            label
          >
            {data.map((entry, index) => (
              <Cell
                key={index}
                fill={COLORS[index]}
              />
            ))}
          </Pie>

          <Tooltip />
        </PieChart>
      </ResponsiveContainer>
    </div>
  );
}

export default ChargePieChart;