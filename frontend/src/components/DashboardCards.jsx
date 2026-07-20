import {
  IndianRupee,
  Zap,
  CalendarDays,
  CircleAlert,
} from "lucide-react";

function DashboardCards({ billData }) {

  const cards = [
    {
      title: "Total Bill",
      value: billData?.billAmount
        ? `₹${billData.billAmount}`
        : "N/A",
      icon: <IndianRupee size={30} />,
      color: "bg-blue-600",
    },
    {
      title: "Units Consumed",
      value: billData?.totalUnits
        ? `${billData.totalUnits} kWh`
        : "N/A",
      icon: <Zap size={30} />,
      color: "bg-green-600",
    },
    {
      title: "Due Date",
      value: billData?.dueDate || "N/A",
      icon: <CalendarDays size={30} />,
      color: "bg-yellow-500",
    },
    {
      title: "Bill Status",
      value: "Pending",
      icon: <CircleAlert size={30} />,
      color: "bg-red-500",
    },
  ];

  return (
    <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
      {cards.map((card, index) => (
        <div
          key={index}
          className="bg-white rounded-2xl shadow-lg hover:shadow-2xl hover:-translate-y-1 transition-all duration-300 p-6"
        >
          <div
            className={`${card.color} w-14 h-14 rounded-xl flex items-center justify-center text-white mb-5`}
          >
            {card.icon}
          </div>

          <p className="text-gray-500 text-sm">{card.title}</p>

          <h2 className="text-2xl font-bold mt-2">
            {card.value}
          </h2>
        </div>
      ))}
    </div>
  );
}

export default DashboardCards;