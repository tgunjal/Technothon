

import { useParams } from 'react-router-dom';
import React, { useState } from 'react';
import './ProductsPage.css';
import ClinicalData from './ClinicalData';
import LaboratoryData from './LaboratoryData';
import GenomicData from './GenomicData';
import BiomarkerData from './BiomarkerData';
import HistopathologyData from './HistopathologyData';
export default function ProductsPage() {
  const [selectedTab, setSelectedTab] = useState('clinical');
  const { patientId } = useParams();
  return (
    <div className="user-info">
       <button onClick={() => downloadReport()}>Download Report</button>
      <div className="tabs">
        <div
          className={`tab ${selectedTab === 'clinical' ? 'active' : ''}`}
          onClick={() => setSelectedTab('clinical')}
        >
          Personal Info {patientId}
        </div>
        <div
          className={`tab ${selectedTab === 'medical' ? 'active' : ''}`}
          onClick={() => setSelectedTab('medical')}
        >
          Medical Info
        </div>
        <div
          className={`tab ${selectedTab === 'genomic' ? 'active' : ''}`}
          onClick={() => setSelectedTab('genomic')}
        >
          Genomic data
        </div>

         
        <div
          className={`tab ${selectedTab === 'biomarker' ? 'active' : ''}`}
          onClick={() => setSelectedTab('biomarker')}
        >
          Biomarker data
        </div>
        <div
          className={`tab ${selectedTab === 'histopathology' ? 'active' : ''}`}
          onClick={() => setSelectedTab('histopathology')}
        >
          Pathology data
        </div>
      </div>

      <div className="tab-content">
        {selectedTab === 'clinical' && (
          <div>
          <ClinicalData/>
          </div>
        )}
        {selectedTab === 'medical' && (
          <div>
           <LaboratoryData/>
            {/* ... */}
          </div>
        )}
        {selectedTab === 'genomic' && (
          <div>
           <GenomicData/>
          </div>
        )}
                {selectedTab === 'biomarker' && (
          <div>
            <BiomarkerData />
          </div>
        )}

      {selectedTab === 'histopathology' && (
          <div>
            <HistopathologyData patientId={ patientId} />
          </div>
        )}
      </div>
    </div>
  );
}

