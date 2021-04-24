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

import com.project.Pfe.Pfe.dao.NiveauRepository;
import com.project.Pfe.Pfe.entities.Filiere;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Niveau;
import com.project.Pfe.Pfe.service.NiveauService;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Niveau")
@CrossOrigin(value="*")
public class NiveauRestController {

@Autowired
private NiveauService niveauService; 	
@Autowired
private NiveauRepository niveauRepository;
	
	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	public Niveau saveNiveau(@RequestBody Niveau niveau){
		return niveauService.createNiveau(niveau);
		
	}
	
	@RequestMapping(value="/deleteById/{immat}" ,method=RequestMethod.DELETE)
	public boolean deleteNiveau(@PathVariable int immat ){
		niveauService.deleteNiveau(immat);
	    return true;
	}
	
	
	
	
	@RequestMapping(value="/getMatiereByNiveau/{idNiveau}" ,method=RequestMethod.GET)
	public List<Matiere> getAllMatiereByNiveau(@PathVariable("idNiveau") int idNiveau){
		   Niveau niveau=niveauRepository.getNiveauById(idNiveau);
		   return niveau.getListMatieres();
		 //  return niveau.get
		   
		 
	}
	
	@RequestMapping(value="/getAllNiveauOnList" ,method=RequestMethod.GET)
	public List<Niveau> getAllNveauOnList(){
		   return niveauService.getAllNiveau();
		 //  return niveau.get
		   
		 
	}
	@RequestMapping(value="/getNiveauById/{idNiveau}" ,method=RequestMethod.GET)
	public Niveau getNiveau(@PathVariable("idNiveau") int idNiveau){
		   Niveau niveau=new Niveau();
		   niveau=niveauRepository.getNiveauById(idNiveau);
		   return niveau;
		 //  return niveau.get
		   	 
	}
	
	@RequestMapping(value="/update/{idNiveau}" ,method=RequestMethod.PUT)
	public Niveau updateNiveau(@PathVariable("idNiveau") int idNiveau, @RequestBody Niveau niveau){
		niveau.setIdNiveau(idNiveau);
		return niveauService.createNiveau(niveau);
		
	}
	
	@RequestMapping(value="/getAll/{page}/{size}" ,method=RequestMethod.GET)
	public ResponseEntity<List<Niveau>>  getAllFilieres(@PathVariable("page")int page,@PathVariable("size") int size){
		Page <Niveau> pagee= niveauRepository.getAllLevels(new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "/Niveau/getAll/");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
		
		
			}
	
	@RequestMapping(value="/getTotalFields" ,method=RequestMethod.GET)
	public int getTotalFields(){
	        return   niveauRepository.totalFields();
		
	}
	
	
	
	
	
}
