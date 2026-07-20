import { Link } from "react-router-dom";
import { ArrowRight, Zap } from "lucide-react";

function Hero() {
  return (
    <section className="bg-gradient-to-br from-blue-50 via-white to-yellow-50 py-24">
      <div className="max-w-7xl mx-auto px-6 grid lg:grid-cols-2 gap-16 items-center">

        <div>

          <div className="inline-flex items-center gap-2 bg-blue-100 text-blue-700 px-4 py-2 rounded-full mb-6">
            <Zap size={18} />
            Smart Electricity Bill Analysis
          </div>

          <h1 className="text-6xl font-extrabold leading-tight text-gray-900">
            Understand Your
            <span className="text-blue-600"> Electricity Bill </span>
            Smarter.
          </h1>

          <p className="mt-6 text-lg text-gray-600 leading-8">
            Upload your APDCL electricity bill and instantly receive
            detailed analysis, consumption trends, charge breakdown,
            and personalized energy-saving insights.
          </p>

          <div className="flex gap-5 mt-10">

            <Link to="/upload">
              <button className="bg-blue-600 hover:bg-blue-700 text-white px-8 py-4 rounded-xl font-semibold flex items-center gap-2 transition">
                Upload Bill
                <ArrowRight size={20} />
              </button>
            </Link>

            <Link to="/dashboard">
              <button className="border-2 border-blue-600 text-blue-600 hover:bg-blue-600 hover:text-white px-8 py-4 rounded-xl font-semibold transition">
                View Dashboard
              </button>
            </Link>

          </div>

        </div>

        <div className="bg-white rounded-3xl shadow-2xl p-8">

          <h2 className="text-2xl font-bold mb-6">
            Bill Summary
          </h2>

          <div className="space-y-5">

            <div className="flex justify-between">
              <span>Consumer</span>
              <span className="font-semibold">HARMUJ ALI</span>
            </div>

            <div className="flex justify-between">
              <span>Units</span>
              <span className="font-semibold">475.74 kWh</span>
            </div>

            <div className="flex justify-between">
              <span>Total Bill</span>
              <span className="font-bold text-green-600">
                ₹3477.92
              </span>
            </div>

            <div className="flex justify-between">
              <span>Status</span>
              <span className="text-green-600 font-bold">
                Ready
              </span>
            </div>

          </div>

        </div>

      </div>
    </section>
  );
}

export default Hero;