package com.project.Pfe.Pfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.DemandePapierRepository;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.PlaningRepository;
import com.project.Pfe.Pfe.entities.DemandePapier;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Planing;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="DemandePapier")
@CrossOrigin("*")
public class DemandePapierRestController {
	
	@Autowired
	private DemandePapierRepository demandeRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;

	@RequestMapping(value="/getListDemande/{page}/{size}" ,method=RequestMethod.GET)
	public ResponseEntity<List<DemandePapier>>  getAllMatiere(@PathVariable("page")int page,@PathVariable("size") int size){
		
		String etat="PAS ENCORE TRAITE";
		Page <DemandePapier> pagee= demandeRepository.getDemandes(etat,new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "DemandePapie/getListDemande");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
		
		
			}
	
	@RequestMapping(value="/getTotalFields" ,method=RequestMethod.GET)
	public int getTotalFields(){
		
		String etat="PAS ENCORE TRAITE";
		return   demandeRepository.getTotalFields(etat);
		
	}
	
	@RequestMapping(value="/updatState" ,method=RequestMethod.PUT)
	public DemandePapier updateDemande(@RequestBody DemandePapier demande) {
		
		DemandePapier dmd=demandeRepository.getOne(demande.getIdDemandePapier());
		dmd.setEtat("traitée");
		
		
		return demandeRepository.save(dmd);
	}
	
	@RequestMapping(value="/getDemandsOfStudent/{username}/{page}/{size}" ,method=RequestMethod.GET)
	public  ResponseEntity<List<DemandePapier>> getDemandeOfStudent(@PathVariable("username") String username,@PathVariable("page") int page,@PathVariable("size") int size)
	{
		
		Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
		
		Page <DemandePapier> pagee=demandeRepository.getDemandeOfStudent(etudiant.getImmat(),new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "DemandePapie/getListDemande");
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/countDemandsOfStudent/{username}" ,method=RequestMethod.GET)
	public int countDemandStudent(@PathVariable("username") String username){
		Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
		return  demandeRepository.countDemandOfStudent(etudiant.getImmat());
	}
	
	
	@RequestMapping(value="/saveDemandePapier/{username}" ,method=RequestMethod.POST)
	public DemandePapier saveDemandPapier(@PathVariable("username") String username,@RequestBody  DemandePapier demandePapier) {
		
	Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
	
	demandePapier.setEtudiant(etudiant);
	
	return demandeRepository.save(demandePapier);
	
	
	}
	
}
