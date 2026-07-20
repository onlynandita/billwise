import { FileText, Users, Zap, TrendingUp } from "lucide-react";

function Stats() {
  const stats = [
    {
      icon: <FileText size={34} />,
      value: "10K+",
      title: "Bills Analyzed",
    },
    {
      icon: <Users size={34} />,
      value: "5K+",
      title: "Happy Users",
    },
    {
      icon: <Zap size={34} />,
      value: "99%",
      title: "Accuracy",
    },
    {
      icon: <TrendingUp size={34} />,
      value: "24/7",
      title: "Availability",
    },
  ];

  return (
    <section className="bg-blue-600 py-20">
      <div className="max-w-7xl mx-auto px-6 grid md:grid-cols-2 lg:grid-cols-4 gap-8">

        {stats.map((item, index) => (
          <div
            key={index}
            className="text-center text-white"
          >
            <div className="flex justify-center mb-5">
              {item.icon}
            </div>

            <h2 className="text-5xl font-bold mb-3">
              {item.value}
            </h2>

            <p className="text-blue-100">
              {item.title}
            </p>

          </div>
        ))}

      </div>
    </section>
  );
}

export default Stats;