// import { Helmet } from 'react-helmet-async';
// import { useState, useEffect } from 'react';

// import { Container, Stack, Typography, Grid, Continer, Table, TableHead, TableBody, TableCell, TableRow, Card } from '@mui/material';


// export default function ClinicalData() {
//     return (

//     <Container maxWidth="xl">
//       <Typography variant="h4" sx={{ mb: 5 }}>
//         Patient Report
//       </Typography>

//       <Grid container spacing={3}>
//         <Grid item xs={12} md={6} lg={4}>
//           <Typography variant="h6">Full Name</Typography>
//           <Typography variant="body">Vedant Khandokar</Typography>
//           {/* <AppNewsUpdate
//             title="News Update"
//             list={[...Array(5)].map((_, index) => ({
//               id: faker.datatype.uuid(),
//               title: faker.name.jobTitle(),
//               description: faker.name.jobTitle(),
//               image: `/assets/images/covers/cover_${index + 1}.jpg`,
//               postedAt: faker.date.recent(),
//             }))}
//           /> */}
//         </Grid>

//         <Grid item xs={12} md={6} lg={4}>
//           <Typography variant="h6">Contact Number</Typography>
//           <Typography variant="body">9146645638</Typography>
//         </Grid>

//         <Grid item xs={12} md={6} lg={4}>
//           <Typography variant="h6">Email</Typography>
//           <Typography variant="body">vedant@gmail.com</Typography>
//         </Grid>

//         <Grid item xs={12} md={6} lg={4}>
//           <Typography variant="h6">Gender</Typography>
//           <Typography variant="body">Male</Typography>
//         </Grid>

//         <Grid item xs={12} md={6} lg={4}>
//           <Typography variant="h6">Blood Group</Typography>
//           <Typography variant="body">A+</Typography>
//         </Grid>

//         <Grid item xs={12} md={6} lg={4}>
//           <Typography variant="h6">Age</Typography>
//           <Typography variant="body">58</Typography>
//         </Grid>

//         <Grid item xs={12} md={6} lg={6}>
//           <Typography variant="h6">Address</Typography>
//           <Typography variant="body">400 Milford Street, New Hampshire, Manchester - 03103</Typography>
//         </Grid>

        // <Grid item xs={12} md={6} lg={6}>
        //   <Typography variant="h6">Diagnosed with</Typography>
        //   <Typography variant="body">Diabetes, Hypertension, Bronchogenic carcinoma</Typography>
        // </Grid>
//           </Grid>
//          </Container>
//         )
// }
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    padding: theme.spacing(2),
  },
  paper: {
    padding: theme.spacing(2),
    margin: "auto",
    maxWidth: 800,
  },
  sectionTitle: {
    marginTop: theme.spacing(3),
    marginBottom: theme.spacing(2),
  },
  label: {
    fontWeight: "bold",
  },
}));

export default function ClinicalData() {
  const { patientId } = useParams();
  const [patientData, setPatientData] = useState(null);
  const classes = useStyles();

  useEffect(() => {
    fetch(`http://localhost:8080/patient/getClinicalData/${patientId}`)
      .then((response) => response.json())
      .then((data) => setPatientData(data));
  }, [patientId]);

  if (!patientData) {
    return <div>Loading...</div>;
  }

  return (
    <div id="clinical-data" className={classes.root}>
      <Paper className={classes.paper}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <Typography variant="h5" align="center">
              Patient Report
            </Typography>
          </Grid>
          <Grid item xs={12}>
            <Typography variant="h6">Patient Information</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Case ID:</Typography>
            <Typography>{patientData.caseId}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Patient Name:</Typography>
            <Typography>{patientData.patientName}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Patient Affiliation:</Typography>
            <Typography>{patientData.patientAffiliation}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Age:</Typography>
            <Typography>{patientData.age}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Weight (lbs):</Typography>
            <Typography>{patientData.weightLbs}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Gender:</Typography>
            <Typography>{patientData.gender}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Ethnicity:</Typography>
            <Typography>{patientData.ethnicity}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Smoking Status:</Typography>
            <Typography>{patientData.smokingStatus}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Pack Years:</Typography>
            <Typography>{patientData.packYears}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Quit Smoking Year:</Typography>
            <Typography>{patientData.quitSmokingYear}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>KRAS Mutation Status:</Typography>
            <Typography>{patientData.krasMutationStatus}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>ALK Translocation Status:</Typography>
            <Typography>{patientData.alkTranslocationStatus}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Adjuvant Treatment:</Typography>
            <Typography>{patientData.adjuvantTreatment}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Chemotherapy:</Typography>
            <Typography>{patientData.chemotherapy}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Radiation:</Typography>
            <Typography>{patientData.radiation}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Recurrence:</Typography>
            <Typography>{patientData.recurrence}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Date of Recurrence:</Typography>
            <Typography>{patientData.dateOfRecurrence}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Date of Last Known Alive:</Typography>
            <Typography>{patientData.dateOfLastKnownAlive}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Survival Status:</Typography>
            <Typography>{patientData.survivalStatus}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Date of Death:</Typography>
            <Typography>{patientData.dateOfDeath}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Time to Death (Days):</Typography>
            <Typography>{patientData.timeToDeathDays}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>CT Date:</Typography>
            <Typography>{patientData.ctDate}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Days between CT and Surgery:</Typography>
            <Typography>{patientData.daysBetweenCtAndSurgery}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Contact Number:</Typography>
            <Typography>{patientData.contactNumber}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Email:</Typography>
            <Typography>{patientData.email}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Address:</Typography>
            <Typography>{patientData.address}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
            <Typography className={classes.label}>Blood Group:</Typography>
            <Typography>{patientData.bloodGroup}</Typography>
          </Grid>
          <Grid item xs={12} sm={6}>
          <Typography className={classes.label}>Diagnosed with</Typography>
     
          <Typography>Diabetes, Hypertension, Bronchogenic carcinoma</Typography>
        </Grid>
        </Grid>
  
      </Paper>
    </div>
);
};
