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
import com.project.Pfe.Pfe.dao.PapierRepository;
import com.project.Pfe.Pfe.entities.DemandePapier;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Niveau;
import com.project.Pfe.Pfe.entities.Papier;
import com.project.Pfe.Pfe.web.util.PaginationUtil;


@RestController
@RequestMapping(value="Papier")
@CrossOrigin("*")
public class PapierRestController {
	
	@Autowired
	private PapierRepository papierRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
    
	@Autowired
	private DemandePapierRepository  demandePapierRepository; 
	
	@RequestMapping(value="/getListPapier" ,method=RequestMethod.GET)
	public List<Papier> getPlaningOfClass(){
		
		return papierRepository.findAll();
	}
	
	@RequestMapping(value="/saveDemandePapier/{username}" ,method=RequestMethod.POST)
	public DemandePapier saveDemandPapier(@PathVariable("username") String username,@RequestBody  DemandePapier demandePapier) {
		
	Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
	
	demandePapier.setEtudiant(etudiant);
	
	return demandePapierRepository.save(demandePapier);
	
	
	}
	
	@RequestMapping(value="/getAllPapier/{page}/{size}" ,method=RequestMethod.GET)
	public ResponseEntity<List<Papier>>  getAllFilieres(@PathVariable("page")int page,@PathVariable("size") int size){
		Page <Papier> pagee= papierRepository.getAllPapier(new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "/Papier/getAllPapier/");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
		
		
			}
	
	

	@RequestMapping(value="/getTotalFields" ,method=RequestMethod.GET)
	public int getTotalFields(){
	        return   papierRepository.totalFields();
		
	}
	
	
	@RequestMapping(value="/savePapier" ,method=RequestMethod.POST)
	public Papier saveDemandPapier(@RequestBody  Papier papier) {
	
		return papierRepository.save(papier);
	
	
	}
	

	@RequestMapping(value="/getPapierById/{idPapier}" ,method=RequestMethod.GET)
	public Papier getPapierById(@PathVariable("idPapier")int idPapier){
	        return   papierRepository.getOne(idPapier);
		
	}
	
	
	@RequestMapping(value="/update/{idPapier}" ,method=RequestMethod.PUT)
	public Papier updateNiveau(@PathVariable("idPapier") int idPapier, @RequestBody Papier papier){
		papier.setIdPapier(idPapier);
		return papierRepository.save(papier);
		
	}
	
	@RequestMapping(value="/deleteById/{idPapier}" ,method=RequestMethod.DELETE)
	public boolean deletePapier(@PathVariable int idPapier ){
		papierRepository.deleteById(idPapier);
	    return true;
	}
	
	
	
	
}
