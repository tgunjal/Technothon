import jsPDF from 'jspdf';
import ClinicalData from './ClinicalData';
import LaboratoryData from './LaboratoryData';
import GenomicData from './GenomicData';
import BiomarkerData from './BiomarkerData';
import HistopathologyData from './HistopathologyData';
function downloadReport() {
  const doc = new jsPDF();

  // Add the personal info
  doc.text(`Patient ID: ${patientId}`, 20, 20);

  // Add the clinical data
  doc.text('Clinical Data', 20, 40);
  const clinicalData = doc.autoTableHtmlToJson(document.getElementById('clinical-data'));
  doc.autoTable(clinicalData.columns, clinicalData.rows, { startY: 45 });

  // Add the laboratory data
  doc.text('Laboratory Data', 20, doc.autoTableEndPosY() + 10);
  const labData = doc.autoTableHtmlToJson(document.getElementById('lab-data'));
  doc.autoTable(labData.columns, labData.rows, { startY: doc.autoTableEndPosY() + 15 });

  // Add the genomic data
  doc.text('Genomic Data', 20, doc.autoTableEndPosY() + 10);
  const genomicData = doc.autoTableHtmlToJson(document.getElementById('genomic-data'));
  doc.autoTable(genomicData.columns, genomicData.rows, { startY: doc.autoTableEndPosY() + 15 });

  // Add the biomarker data
  doc.text('Biomarker Data', 20, doc.autoTableEndPosY() + 10);
  const biomarkerData = doc.autoTableHtmlToJson(document.getElementById('biomarker-data'));
  doc.autoTable(biomarkerData.columns, biomarkerData.rows, { startY: doc.autoTableEndPosY() + 15 });

  // Add the pathology data
  doc.text('Pathology Data', 20, doc.autoTableEndPosY() + 10);
  const pathologyData = doc.autoTableHtmlToJson(document.getElementById('pathology-data'));
  doc.autoTable(pathologyData.columns, pathologyData.rows, { startY: doc.autoTableEndPosY() + 15 });

  // Save the PDF
  doc.save(`patient-${patientId}-report.pdf`);
}
