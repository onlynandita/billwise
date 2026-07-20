import { useState } from "react";
import { Upload, FileText } from "lucide-react";

function UploadBox() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleFileChange = (e) => {
    setSelectedFile(e.target.files[0]);
  };

  const handleUpload = async () => {
    if (!selectedFile) {
      alert("Please select a PDF file first.");
      return;
    }

    const formData = new FormData();
    formData.append("file", selectedFile);

    try {
      setLoading(true);

      const response = await fetch("http://localhost:8080/api/bill/upload", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        throw new Error("Upload failed");
      }

      const data = await response.json();

      console.log("Bill Data:", data);

      alert("Bill uploaded successfully! Check the browser console (F12).");

    } catch (error) {
      console.error(error);
      alert("Failed to upload bill.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="max-w-3xl mx-auto">
      <div className="bg-white rounded-3xl shadow-xl p-10">

        <div className="border-2 border-dashed border-blue-400 rounded-3xl p-16 text-center hover:border-blue-600 hover:bg-blue-50 transition-all duration-300">

          <div className="flex justify-center mb-6">
            <div className="bg-blue-100 p-5 rounded-full">
              <Upload size={50} className="text-blue-600" />
            </div>
          </div>

          <h2 className="text-3xl font-bold text-gray-800 mb-4">
            Upload Electricity Bill
          </h2>

          <p className="text-gray-600 mb-8">
            Drag & Drop your APDCL Electricity Bill PDF
            <br />
            or click below to browse.
          </p>

          <label className="cursor-pointer inline-block bg-blue-600 hover:bg-blue-700 text-white px-8 py-4 rounded-xl font-semibold transition">
            <FileText className="inline mr-2" size={20} />
            {selectedFile ? selectedFile.name : "Choose PDF"}

            <input
              type="file"
              accept=".pdf"
              className="hidden"
              onChange={handleFileChange}
            />
          </label>

          <br /><br />

          <button
            onClick={handleUpload}
            disabled={loading}
            className="bg-green-600 hover:bg-green-700 text-white px-10 py-4 rounded-xl font-semibold transition disabled:opacity-50"
          >
            {loading ? "Uploading..." : "Analyze Bill →"}
          </button>

          <p className="mt-8 text-gray-500 text-sm">
            Supported Format: PDF
          </p>

        </div>

      </div>
    </div>
  );
}

export default UploadBox;