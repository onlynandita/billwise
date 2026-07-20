import Navbar from "../components/Navbar";
import UploadBox from "../components/UploadBox";
import Footer from "../components/Footer";

function Upload() {
  return (
    <>
      <Navbar />
         
        <section className="bg-gradient-to-br from-slate-50 to-blue-50 min-h-screen py-20 px-6">


        <div className="text-center mb-12">
          <h1 className="text-5xl font-extrabold text-gray-900 mb-4">

            Upload Your Electricity Bill
          </h1>

          <p className="text-gray-600 text-lg">
            Upload your APDCL electricity bill to receive
            detailed analysis and insights.
          </p>

        </div>

        <UploadBox />

      </section>

      <Footer />
    </>
  );
}

export default Upload;