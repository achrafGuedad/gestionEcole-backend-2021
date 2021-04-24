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

import com.project.Pfe.Pfe.dao.SalleRepository;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Salle;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Salle")
@CrossOrigin("*")
public class SalleRestController {
	
	@Autowired
	private SalleRepository salleRepository;
	
	@RequestMapping(value="/getAllSalle" ,method=RequestMethod.GET)
	public List<Salle> getAllSalle(){
		return salleRepository.findAll();
	
	}
	
	
	// POST METHODE
	@RequestMapping(value="create" ,method=RequestMethod.POST)
	public Salle saveSalle(@RequestBody Salle salle){
		return salleRepository.save(salle);
	
	}
	
	
	// GET ALL SALLE
	
	@RequestMapping(value="/getAllSalle/{page}/{size}" ,method=RequestMethod.GET)
	public ResponseEntity<List<Salle>>  getAllSalle(@PathVariable("page")int page,@PathVariable("size") int size){
		Page <Salle> pagee= salleRepository.getAllSalle(new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "/Salle/getAllSalle");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
	}
	
	
	// TOTAL FIELDS
	@RequestMapping(value="/getTotalFields" ,method=RequestMethod.GET)
	public int getTotalFields(){
	        return salleRepository.totalFields();
		
	}
	
	//PUT
	@RequestMapping(value="/update/{idSalle}" ,method=RequestMethod.PUT)
	public Salle updateSalle(@PathVariable int idSalle,@RequestBody Salle salle){
		salle.setIdSalle(idSalle);
		return salleRepository.save(salle);
		
	}
	
	// GET BY ID
	@RequestMapping(value="/getSalleById/{idSalle}" ,method=RequestMethod.GET)
	public Salle getSalleById(@PathVariable("idSalle") int idSalle){
	        return salleRepository.getOne(idSalle);
		
	}
	
	// DELETE
	@RequestMapping(value="/deleteById/{idSalle}" ,method=RequestMethod.DELETE)
	public boolean deleteNiveau(@PathVariable int idSalle ){
		salleRepository.deleteById(idSalle);
	    return true;
	}

}
