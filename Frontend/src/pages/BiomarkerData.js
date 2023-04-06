// import React, { useEffect, useState } from 'react';
// import Chart from 'chart.js/auto';

// export default function BiomarkerData() {
//   const [chart, setChart] = useState(null);
  
//   // Hardcoded data
//   const data = {
//     labels: ['0', '3', '6', '9', '12', '15', '18', '21', '24', '27', '30', '33', '36', '39', '42', '45', '48'],
//     ctcData: [54, 42, 16, 12, 8, 6, 7, 4, 3, 4, 4, 5, 19, 69, 29, 8, 3],
//     milestoneData: ['Diagnosis of cancer', 'Post Onco-surgery, Start of ChemoRx Cycles', 'After ChemoRx Cycle 1', 'After ChemoRx Cycle 2', 'After ChemoRx Cycle 3', 'After ChemoRx Cycle 4', 'After ChemoRx Cycle 5', 'After ChemoRx Cycle 6, End of ChemoRx Cycles', 'Post ChemoRx, Start of Radiation Therapy', 'Post Radiation Rehabilitation', 'Post Radiation Rehabilitation', 'Post Radiation Rehabilitation', 'Suspected Cancer Relapse', 'Confirmed Metastatic Spread with PET scan, Start of ImmunoTherapy', 'After Immunotherapy Dose 1', 'After Immunotherapy Dose 2', 'After Immunotherapy Dose 3'],
//   };
  
//   useEffect(() => {
//     // Create the chart
//     const ctx = document.getElementById('myChart');
//     const newChart = new Chart(ctx, {
//       type: 'line',
//       data: {
//         labels: data.labels,
//         datasets: [
//           {
//             label: 'CTC count (Cells/7.5 ml)',
//             data: data.ctcData,
//             borderColor: 'blue',
//             fill: false,
           
//           }
//         ]
//       },
    //   options: {
    //     scales: {
    //       x: {
    //         title: {
    //           display: true,
    //           text: 'Time (in months)'
    //         },
    //         // ...
    //       },
    //       y: {
    //         title: {
    //           display: true,
    //           text: 'CTC count (Cells/7.5 ml)'
    //         },
    //         // ...
    //       }
    //     },
//         tooltips: {
//           callbacks: {
//             title: function(tooltipItem, data) {
//               const index = tooltipItem[0].index;
//               return `Time: ${data.labels[index]}`;
//             },
//             label: function(tooltipItem, data) {
//               const index = tooltipItem.index;
//               return `Oncology Milestone: ${data.milestoneData[index]}`;
//             }
//           }
//         },

//         plugins: {
//           tooltip: {
//             callbacks: {
//               label: function(context) {

//                 var index = context.dataIndex;
//                 var ctcCount = data.ctcData[index];
//                 var time = data.labels[index];
//                 var milestone = data.milestoneData[index];
//                 return "Time: " + time + ", CTC Count: " + ctcCount + ", Milestone: " + milestone;
//               }
//             }
//           }
//         }
//       }
//     });
//     setChart(newChart);
//   }, []);

//   return (
//     <div>
//       <canvas id="myChart" width="600" height="300"></canvas>
//     </div>
//   );
// };

import { useState, useEffect } from "react";
import Chart from "chart.js/auto";

import './BiomarkerData.css'
function BiomarkerData() {
  const [chart, setChart] = useState(null);
  const [oncologyData, setOncologyData] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/patient/getBiomarkerData")
      .then((response) => response.json())
      .then((data) => {
        const ctx = document.getElementById("oncologyChart").getContext("2d");
        const chart = new Chart(ctx, {
          type: "line",
          data: {
            labels: data.timeData,
            datasets: [
              {
                label: 'CTC count (Cells/7.5 ml)',
                data: data.ctcCountData,
                borderColor: "rgb(255, 99, 132)",
                tension: 0.1,
                fill: false,
              },
            ],
          },
            options: {
              
            scales: {
              x: {
                title: {
                  display: true,
                  text: 'Time (in weeks)'
                },
                // ...
              },
              y: {
                title: {
                  display: true,
                  text: 'CTC count (Cells/7.5 ml)'
                },
                // ...
              }
            },
            plugins: {
              tooltip: {
                callbacks: {
                  label: function (context) {
                    var index = context.dataIndex;
                    var ctcCount = data.ctcCountData[index];
                    var time = data.timeData[index];
                    var milestone = data.milestoneData[index];
                    return (
                      "Time: " +
                      time +
                      ", CTC Count: " +
                      ctcCount +
                      ", Milestone: " +
                      milestone
                    );
                  },
                },
              },
            },
            },
          
        });
          setChart(chart);
          setOncologyData(data);

      });
  }, []);

  return (
    <>
    <h1>     Biomarker Data</h1>
      <div>
        
        <canvas id="oncologyChart" width="600" height="300" />
        {oncologyData && (
        <table className="data-table">
          <thead>
            <tr>
              <th>Time</th>
              <th>CTC Count</th>
              <th>Oncology Milestone</th>
            </tr>
          </thead>
          <tbody>
            {oncologyData.timeData.map((time, index) => (
              <tr key={time}>
                <td>{time}</td>
                <td>{oncologyData.ctcCountData[index]}</td>
                <td>{oncologyData.milestoneData[index]}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
      </div>
      </>
    );
}

export default BiomarkerData;

