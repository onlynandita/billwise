import { Link } from "react-router-dom";

function CTA() {
  return (
    <section className="py-24 bg-gray-900 text-center text-white">

      <h2 className="text-5xl font-bold mb-6">
        Ready to Analyze Your Bill?
      </h2>

      <p className="text-xl text-gray-300 mb-10">
        Upload your electricity bill and receive smart insights in seconds.
      </p>

      <Link to="/upload">
        <button className="bg-blue-600 hover:bg-blue-700 px-10 py-5 rounded-xl text-lg font-semibold transition">
          Get Started
        </button>
      </Link>

    </section>
  );
}

export default CTA;