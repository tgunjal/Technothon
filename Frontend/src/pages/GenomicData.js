
import { useState, useEffect } from 'react';


import {

  AppWebsiteVisits,

} from '../sections/@dashboard/app';
// @mui
import { Container, Stack, Typography, Grid, Continer, Table, TableHead, TableBody, TableCell, TableRow, Card } from '@mui/material';


export default function GenomicData() { 
    const [rows_generic, setGenericData] = useState([]);
    const [chart_data, setChartData] = useState([]);
    const [chart_labels, setChartLables] = useState([]);
    
  const columns_generic = [
    { id: "date", label: "Date", minWidth: 100},
    { id: "smokingStatus", label: "Smoking Status", minWidth: 100},
    { id: "cancerStage", label: "Cancer Stage", minWidth: 100},
    { id: "mutationCount", label: "Mutation Count", minWidth: 100},
    { id: "krasMutationCount", label: "KRAS Mutation Count", minWidth: 100},
    { id: "egfrMutationCount", label: "EGFR Mutation Count", minWidth: 100},
    { id: "tp53MutationCount", label: "TP53 Mutation Count", minWidth: 100},
    { id: "alkFusionStatus", label: "ALK Fusion Status", minWidth: 100},
    { id: "ros1FusionStatus", label: "ROS1 Fusion Status", minWidth: 100},
    { id: "treatment", label: "Treatment", minWidth: 100},
    { id: "response", label: "Response", minWidth: 100},
  ];

  useEffect(() => {
    fetch("http://localhost:8080/patient/getPatientMutation")
      .then(response => response.json())
      .then(json => {
        console.log(json, "Generic Data")
        setGenericData(json)
      })

    fetch("http://localhost:8080/patient/getMutationCount")
    .then(response => response.json())
    .then(json => {
      console.log(json, "Chart Data")
      setChartData(json)
    })

    fetch("http://localhost:8080/patient/getMutationCountDates")
    .then(response => response.json())
    .then(json => {
      console.log(json, "Chart Labels")
      setChartLables(json)
    })
  
  }, []);

    return (

    <Container maxWidth="xl">
    
        <h1>     Genomic Data</h1>


          <Grid container spacing={3}>
      
       
          <Typography variant="h6">
     
        </Typography>

        {/* Generic Alteration */}
        <Grid item xs={12} md={6} lg={12}>
          <AppWebsiteVisits
            title="Genetic Alteration"

            subheader="Non Small cell lung cancer(NSCLC), which is the most common type of lung cancer"

            chartLabels={chart_labels}
            chartData={chart_data}
          />
          <br></br>
          <Table>
            <TableHead sx={{
              "& th": {
                color: "rgba(30, 30, 30)",
                backgroundColor: "rgb(255 192 132)"
              }
            }}>
            <TableRow>
                {columns_generic.map((column) => (
                  <TableCell key={column.id} align="left" style={{ minWidth: column.minWidth }}>
                    {column.label}
                  </TableCell>
                ))}
              </TableRow>
            </TableHead>

            <TableBody>
              {rows_generic.map((row) => (
                <TableRow key={row.id}>
                  <TableCell align="left">{row.date}</TableCell>
                  <TableCell align="left">{row.smokingStatus}</TableCell>
                  <TableCell align="left">{row.cancerStage}</TableCell>
                  <TableCell align="left">{row.mutationCount}</TableCell>
                  <TableCell align="left">{row.krasMutationCount}</TableCell>
                  <TableCell align="left">{row.egfrMutationCount}</TableCell>
                  <TableCell align="left">{row.tp53MutationCount}</TableCell>
                  <TableCell align="left">{row.alkFusionStatus}</TableCell>
                  <TableCell align="left">{row.ros1FusionStatus}</TableCell>
                  <TableCell align="left">{row.treatment}</TableCell>
                  <TableCell align="left">{row.response}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
      
        </Grid>

          </Grid>
         </Container>
        )
}