


  

    // import React, { useEffect, useState } from "react";
    // import {Chart} from "chart.js";
    
    // export default function LaboratoryData() { 
    //   const [chart, setChart] = useState(null);
    
    //   useEffect(() => {
    //     const canvas = document.getElementById("bloodValuesChart");
    //     const ctx = canvas.getContext("2d");
    
    //     const data = {
    //       labels: ["January", "February", "March", "April", "May"],
    //       datasets: [
    //         {
    //           label: "WBC Count",
    //           data: [5.8, 6.7, 4.9, 7.1, 5.2],
    //           borderColor: "red",
    //           fill: false,
    //         },
    //         {
    //           label: "RBC Count",
    //           data: [4, 4.2, 4.7, 4.6, 4.8],
    //           borderColor: "blue",
    //           fill: false,
    //         },
    //         {
    //           label: "Hemoglobin",
    //           data: [33.5, 38.6, 44.2, 36.8, 48.3],
    //           borderColor: "green",
    //           fill: false,
    //         },
    //         {
    //           label: "Hematocrit",
    //           data: [333.5, 38.6, 44.2, 36.8, 48.3],
    //           borderColor: "purple",
    //           fill: false,
    //         },
    //         {
    //           label: "Platelet count",
    //           data: [180, 200, 230, 210, 260],
    //           borderColor: "orange",
    //           fill: false,
    //         },
    //         {
    //           label: "Sodium",
    //           data: [137, 140, 139, 142, 141],
    //           borderColor: "gray",
    //           fill: false,
    //         },
    //         {
    //           label: "Potassium",
    //           data: [3.7, 4.6, 5.1, 4.7, 3.9],
    //           borderColor: "black",
    //           fill: false,
    //         },
    //         {
    //           label: "Chloride",
    //           data: [97, 100, 104, 98, 101],
    //           borderColor: "brown",
    //           fill: false,
    //         },
    //       ],
    //     };
    
    //     const options = {
    //       responsive: true,
    //       title: {
    //         display: true,
    //         text: "Blood Values Chart",
    //       },
    //       tooltips: {
    //         mode: "index",
    //         intersect: false,
    //       },
    //       hover: {
    //         mode: "nearest",
    //         intersect: true,
    //       },
   
    
    //     const newChart = new Chart(ctx, {
    //       type: "line",
    //       data: data,
    //       options: options,
    //     });
    
    //     setChart(newChart);
    //   }, []);
    
    //   return (
    //     <div>
    //       <canvas id="bloodValuesChart" />
    //     </div>
    //   );
    // };
    import React, { useState, useEffect } from 'react';
import { Line } from 'react-chartjs-2';
import "./LaboratoryData.css"
export default function LaboratoryData() { 
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/patient/getLaboratoryData')
      .then(response => response.json())
      .then(data => setData(data))
      .catch(error => console.error(error));
  }, []);

  const chartData = {
    labels: data.map(item => item.date),
    
    datasets: [
      {
        label: 'Hemoglobin',
        data: data.map(item => item.hemoglobin),
        borderColor: 'red',
        fill: false
      },
      {
        label: 'Hematocrit',
        data: data.map(item => item.hematocrit),
        borderColor: 'green',
        fill: false
      },
      {
        label: 'Platelet Count',
        data: data.map(item => item.plateletCount),
        borderColor: 'blue',
        fill: false
      },
      {
        label: 'Sodium',
        data: data.map(item => item.sodium),
        borderColor: 'orange',
        fill: false
      },
      {
        label: 'Potassium',
        data: data.map(item => item.potassium),
        borderColor: 'purple',
        fill: false
      },
      {
        label: 'Chloride',
        data: data.map(item => item.chloride),
        borderColor: 'brown',
        fill: false
      },
      {
        label: 'RBC Count',
        data: data.map(item => item.rbccount),
        borderColor: 'gray',
        fill: false
      },
      {
        label: 'WBC Count',
        data: data.map(item => item.wbccount),
        borderColor: 'black',
        fill: false
      }
    ]
    
  };
  const options = {
    scales: {
      x: {
        title: {
          display: true,
          text: "Month",
        },
      },
      y: {
        title: {
          display: true,
          text: "Count/Level",
        },
      },
    },
  };
  const tableData = data.map(item => {
    return (
      <tr key={item.id}>
        <td>{item.date}</td>
        <td>{item.hemoglobin}</td>
        <td>{item.hematocrit}</td>
        <td>{item.plateletCount}</td>
        <td>{item.sodium}</td>
        <td>{item.potassium}</td>
        <td>{item.chloride}</td>
        <td>{item.rbccount}</td>
        <td>{item.wbccount}</td>
      </tr>
    );
  });

  return (
    <div>
      <h1>Blood Data</h1>
      <Line data={chartData} options={options}/>
      <br />
      <br/>

      <table>
  <thead>
    <tr>
      <th>Date</th>
      <th>WBC Count (cells/microliter)</th>
      <th>RBC Count (cells/microliter)</th>
      <th>Hemoglobin (grams/dL)</th>
      <th>Hematocrit (%)</th>
      <th>Platelet count (cells/microliter)</th>
      <th>Sodium (mEq/L)</th>
      <th>Potassium (mEq/L)</th>
      <th>Chloride (mEq/L)</th>
    </tr>
  </thead>
  <tbody>
    {data.map((row) => (
      <tr key={row.id}>
        <td>{row.date}</td>
        <td>{row.wbccount}</td>
        <td>{row.rbccount}</td>
        <td>{row.hemoglobin}</td>
        <td>{row.hematocrit}</td>
        <td>{row.plateletCount}</td>
        <td>{row.sodium}</td>
        <td>{row.potassium}</td>
        <td>{row.chloride}</td>
      </tr>
    ))}
  </tbody>
</table>

    </div>
  );
};

