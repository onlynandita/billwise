import {
  Upload,
  BarChart3,
  TrendingUp,
  Lightbulb,
  ReceiptIndianRupee,
  Download,
} from "lucide-react";

function Features() {
  const features = [
    {
      icon: <Upload size={34} />,
      title: "Upload Bills",
      description:
        "Upload your APDCL electricity bill PDF securely with a single click.",
    },
    {
      icon: <BarChart3 size={34} />,
      title: "Smart Analysis",
      description:
        "Instantly understand bill charges, units consumed and complete bill details.",
    },
    {
      icon: <TrendingUp size={34} />,
      title: "Usage Trends",
      description:
        "Track and compare your electricity consumption month by month.",
    },
    {
      icon: <Lightbulb size={34} />,
      title: "AI Insights",
      description:
        "Receive personalized energy-saving suggestions to reduce your electricity bill.",
    },
    {
      icon: <ReceiptIndianRupee size={34} />,
      title: "Charge Breakdown",
      description:
        "View energy charges, fixed charges, taxes and total payable amount clearly.",
    },
    {
      icon: <Download size={34} />,
      title: "Download Report",
      description:
        "Generate and download a complete electricity bill analysis report.",
    },
  ];

  return (
    <section className="py-20 bg-white">
      <div className="max-w-7xl mx-auto px-6">

        <div className="text-center mb-16">
          <h2 className="text-4xl font-extrabold text-gray-900 mb-4">
            Why Choose BillWise?
          </h2>

          <p className="text-lg text-gray-600 max-w-3xl mx-auto">
            BillWise converts complicated electricity bills into simple,
            meaningful insights that help you understand your spending
            and save energy.
          </p>
        </div>

        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">

          {features.map((feature, index) => (
            <div
              key={index}
              className="bg-white border-2 border-transparent rounded-3xl p-8 shadow-md hover:shadow-2xl hover:-translate-y-2 hover:border-blue-500 transition-all duration-300"
            >
              <div className="w-16 h-16 rounded-2xl bg-blue-100 text-blue-600 flex items-center justify-center mb-6">
                {feature.icon}
              </div>

              <h3 className="text-2xl font-bold text-gray-900 mb-4">
                {feature.title}
              </h3>

              <p className="text-gray-600 leading-7">
                {feature.description}
              </p>
            </div>
          ))}

        </div>
      </div>
    </section>
  );
}

export default Features;