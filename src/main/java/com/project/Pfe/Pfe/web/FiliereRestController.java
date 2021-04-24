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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.FiliereRepository;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Filiere;
import com.project.Pfe.Pfe.service.FiliereService;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Filiere")
@CrossOrigin("*")



public class FiliereRestController {
	
	@Autowired
	private FiliereService filiereService;
	
	@Autowired
	private FiliereRepository filiereRepository; 
	
	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	public Filiere saveFiliere(@RequestBody Filiere filiere){
		return filiereService.createFiliere(filiere);
		
	}
	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<Filiere> getAllFiliere(){
		return filiereService.getAllFiliere();
		
	}
	@RequestMapping(value="/getById/{idFiliere}" ,method=RequestMethod.GET)
	public Filiere getFilliereById(@PathVariable("idFiliere") int idFiliere){
	   Filiere filiere=filiereRepository.getFiliereByiid(idFiliere);
		return filiere;
		
	}
	

@RequestMapping(value="/getTotalFields" ,method=RequestMethod.GET)
public int getTotalFields(){
        return   filiereRepository.totalFields();
	
}   
	@RequestMapping(value="/delete/{codeFiliere}" ,method=RequestMethod.DELETE)
	public boolean deleteFiliere(@PathVariable("codeFiliere") int codeFilere ){
		filiereService.deleteFiliere(codeFilere);
		return true;
	}
	
	@RequestMapping(value="/updateFiliere/{immat}" ,method=RequestMethod.PUT)
	public Filiere updateStudent(@PathVariable int immat,@RequestBody Filiere filiere){
		filiere.setCodeFiliere(immat);
		return  filiereService.createFiliere(filiere);
		
	}
	

	@RequestMapping(value="/getAllFiliere/{page}/{size}" ,method=RequestMethod.GET)
	public ResponseEntity<List<Filiere>>  getAllFilieres(@PathVariable("page")int page,@PathVariable("size") int size){
		Page <Filiere> pagee= filiereRepository.getAllFiliere(new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "/Filiere/getAllFiliere/{page}/{size}");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
		
		
			}
}
