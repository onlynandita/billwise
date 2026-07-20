function Insights({ billData }) {

  const units = Number(billData?.totalUnits) || 0;
  const amount = Number(billData?.billAmount) || 0;

  const insights = [];

  if (units > 400) {
    insights.push("⚡ High electricity consumption detected.");
  } else if (units > 250) {
    insights.push("⚡ Moderate electricity consumption.");
  } else {
    insights.push("⚡ Low electricity consumption.");
  }

  if (amount > 5000) {
    insights.push("💰 Your electricity bill is quite high this month.");
  } else if (amount > 3000) {
    insights.push("💰 Your bill is moderate.");
  } else {
    insights.push("💰 Your electricity bill is within a normal range.");
  }

  // Use backend AI suggestion if available
  if (billData?.aiSuggestion) {
    insights.push(`🤖 ${billData.aiSuggestion}`);
  } else {
    insights.push(
      "🌿 Switching off unused appliances and reducing AC usage can help lower future bills."
    );
  }

  return (
    <div className="bg-white rounded-2xl shadow-md p-8 mt-8">
      <h2 className="text-2xl font-bold mb-6">
        AI Insights
      </h2>

      <div className="space-y-4">
        {insights.map((item, index) => (
          <div
            key={index}
            className="bg-blue-50 border-l-4 border-blue-600 p-4 rounded-lg"
          >
            {item}
          </div>
        ))}
      </div>
    </div>
  );
}

export default Insights;