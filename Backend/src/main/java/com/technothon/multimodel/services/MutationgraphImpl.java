package com.technothon.multimodel.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technothon.multimodel.dao.MutationgraphRepository;
import com.technothon.multimodel.entity.MutationCount;
import com.technothon.multimodel.entity.Mutationgraph;


@Service
public class MutationgraphImpl implements MutationgraphService {


	  @Autowired
	  MutationgraphRepository mutationgraphRepository;
		@Override
		public List<Mutationgraph> findAll() {
			// TODO Auto-generated method stub
			return mutationgraphRepository.findAll();
		}

		@Override
		public Optional<com.technothon.multimodel.entity.Mutationgraph> findById(int id) {
			// TODO Auto-generated method stub
			return mutationgraphRepository.findById(id);
		}

		@Override
		public void save(Mutationgraph mutationgraph) {
			// TODO Auto-generated method stub
			mutationgraphRepository.save(mutationgraph);

		}

		@Override
		public void deleteById(int caseId) {
			// TODO Auto-generated method stub
			mutationgraphRepository.deleteById(caseId);

		}

		@Override
		public void saveAll(List<Mutationgraph> mutationgraph) {
			// TODO Auto-generated method stub
			mutationgraphRepository.saveAll(mutationgraph);

		}

		@Override
		public List<MutationCount> findAllByColumn() {
			// TODO Auto-generated method stub
			 List<MutationCount>mutationCounts =  new ArrayList<MutationCount>();
			List<Mutationgraph> mutation= mutationgraphRepository.findAll();
			
//			 List<Integer> id = new ArrayList<>();
//		     List<Date> date = new ArrayList<>();;
//		     List<Integer> age = new ArrayList<>();;
//		     List<String> smokingStatus = new ArrayList<>();;
//	 	    List<String> cancerStage = new ArrayList<>();;
		     List<Integer> mutationCount = new ArrayList<>();;
		     List<Integer> krasMutationCount = new ArrayList<>();;
		     List<Integer> egfrMutationCount = new ArrayList<>();;
		     List<Integer> tp53MutationCount = new ArrayList<>();;
//		     List<String> alkFusionStatus = new ArrayList<>();;
//		     List<String> ros1FusionStatus = new ArrayList<>();;
//		     List<String> treatment = new ArrayList<>();;
//		     List<String> response = new ArrayList<>();;
		    
//				for(Mutationgraph m :mutation) {
//					
//					id.add(m.getId());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					date.add(m.getDate());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					age.add(m.getAge());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					smokingStatus.add(m.getSmokingStatus());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					cancerStage.add(m.getCancerStage());
//				}
		     MutationCount mutationCountclass = new MutationCount();
				for(Mutationgraph m :mutation) {
					
					mutationCount.add(m.getMutationCount());
				}
				mutationCountclass.setName("Mutation Count");
				mutationCountclass.setType("column");
				mutationCountclass.setData(mutationCount);
				mutationCountclass.setFill("solid");
				mutationCounts.add(mutationCountclass);
			 MutationCount mutationCountclass2 = new MutationCount();
				for(Mutationgraph m :mutation) {
					
					krasMutationCount.add(m.getKrasMutationCount());
				}
				mutationCountclass2.setName("KRAS Mutation Count");
				mutationCountclass2.setType("column");
				mutationCountclass2.setData(krasMutationCount);
				mutationCountclass2.setFill("solid");
				mutationCounts.add(mutationCountclass2);
				
				 MutationCount mutationCountclass3 = new MutationCount();
				for(Mutationgraph m :mutation) {
					
					egfrMutationCount.add(m.getEgfrMutationCount());
				}
				mutationCountclass3.setName("EGFR Mutation Count");
				mutationCountclass3.setType("column");
				mutationCountclass3.setData(egfrMutationCount);
				mutationCountclass3.setFill("solid");
				mutationCounts.add(mutationCountclass3);
				
				 MutationCount mutationCountclass4 = new MutationCount();

				for(Mutationgraph m :mutation) {
					
					tp53MutationCount.add(m.getTp53MutationCount());
				}
				mutationCountclass4.setName("TP53 Mutation Count");
				mutationCountclass4.setType("column");
				mutationCountclass4.setData(tp53MutationCount);
				mutationCountclass4.setFill("solid");
				mutationCounts.add(mutationCountclass4);
//				for(Mutationgraph m :mutation) {
//					
//					alkFusionStatus.add(m.getAlkFusionStatus());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					ros1FusionStatus.add(m.getRos1FusionStatus());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					treatment.add(m.getTreatment());
//				}
//				for(Mutationgraph m :mutation) {
//					
//					response.add(m.getResponse());
//				}
//				
//				multiBarGraph.setAge(age);
//
//				multiBarGraph.setId(id);
//
//				multiBarGraph.setDate(date);
//
//				multiBarGraph.setSmokingStatus(smokingStatus);
//
//				multiBarGraph.setCancerStage(cancerStage);
////
//				multiBarGraph.setAlkFusionStatus(alkFusionStatus);
//
//				multiBarGraph.setRos1FusionStatus(ros1FusionStatus);
//
//				multiBarGraph.setTreatment(treatment);
//			
//				multiBarGraph.setResponse(response);


			return mutationCounts;
		}
		
		
		@Override
		public List<String> findByAllDates() {
			List<String> dates = new ArrayList<>();
			List<Mutationgraph> mutation= mutationgraphRepository.findAll();
			
			for(Mutationgraph m :mutation) {
				System.out.println(m.getDate());
				 SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
				
			  
			    dates.add(outputDateFormat.format(m.getDate()));
			}
			return dates;
			
		}

}
