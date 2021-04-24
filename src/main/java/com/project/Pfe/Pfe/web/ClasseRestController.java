package com.project.Pfe.Pfe.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.project.Pfe.Pfe.dao.ClasseRepository;
import com.project.Pfe.Pfe.entities.AnneeScolaire;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Niveau;
import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.service.ClasseService;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Classe")
@CrossOrigin("*")
public class ClasseRestController {
	
	
	
	
    
	
	
	@Autowired
	private ClasseService classeService;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<Classe> getAllClasse(){
		return classeService.getAllClasse();
	}
	
	/*@RequestMapping(value="/getClasseById/{idClasse}" ,method=RequestMethod.GET)
	public Classe getAnneeScolaireByAnnee(@PathVariable int idClasse){
		Classe classe=classeRepository.getClasseById(idClasse);
				return classe;
			}*/
	/*
	@RequestMapping(value="/getClassesByAnneeScolaire/{annee}" ,method=RequestMethod.GET)
	public List<Classe> getClassesByAnnee(@PathVariable("annee") int annee){
		return classeRepository.getClassesByAnneeScolaire(annee);
			}*/
	
	
	@RequestMapping(value="/getClassesByAnneeScolaire/{annee}/{page}/{size}"  ,method=RequestMethod.GET)
	public ResponseEntity<List<Classe>>  getClassesByAnneeScolaire(@PathVariable("annee") int annee,@PathVariable("page")int page,@PathVariable("size") int size){
		Page <Classe> pagee= classeRepository.getClassesByAnneeScolaire(annee,new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "/Classe/getClassesByAnneeScolaire");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
		
		
			}
	
	//get All years grou by classId
	
	
	
	
	
	@RequestMapping(value="/getDistinctClasses" ,method=RequestMethod.GET)
	public List<Classe> getDistinctClasses(){
		return classeRepository.getDistinctClasses();
		}
	
	@RequestMapping(value="/getCurentClasses" ,method=RequestMethod.GET)
	public List<Classe> getDate(){
		SimpleDateFormat formatter =  new  SimpleDateFormat ( "yyyy" );  
	    Date mydate =  new  Date ();  
	    
	    
	    
	    String dateP=formatter.format (mydate);
	    
	    int integerDateA=Integer.parseInt(formatter.format (mydate))+1;
	    
	    String dateA=String.valueOf(integerDateA);
	    
	    String anneeScolaire=dateP+"-"+dateA;
	    List<Classe> listeClasse=classeRepository.getAllClassesByAnneeScolaire(anneeScolaire);
	    
		return  listeClasse;
		}
	
	@RequestMapping(value="/getTotalFields/{idYear}" ,method=RequestMethod.GET)
	public int getTotalFiels(@PathVariable("idYear") int idYear){
		return classeRepository.getTotalFields(idYear);
		}
	
	@RequestMapping(value="create" ,method=RequestMethod.POST)
	public Classe saveClasse(@RequestBody Classe classe){
		return classeService.createClasse(classe);
		
	}
	/*
	@RequestMapping(value="/etudiants/{immat}" ,method=RequestMethod.DELETE)
	public void deleteClasse(@PathVariable int idClasse ){
		classeService.
	}
	*/
	@RequestMapping(value="/modifieClasse/{idClasse}" ,method=RequestMethod.PUT)
	public Classe updateClasse(@PathVariable int idClasse,@RequestBody Classe classe){
		classe.setIdClasse(idClasse);
		return classeService.createClasse(classe);
		
	}
	
	
	@RequestMapping(value="/getClasseByIdClasse/{id}" ,method=RequestMethod.GET)
	public Classe getClasseByIdClasse(@PathVariable("id") int idClasse){
		return classeRepository.getClasseByIdClasse(idClasse);
		}
	
	// DELETE
		@RequestMapping(value="/deleteById/{idClasse}" ,method=RequestMethod.DELETE)
		public boolean deleteClasseById(@PathVariable int idClasse ){
			classeRepository.deleteById(idClasse);
		    return true;
		}
		
		
		
		// get all classes by annee  scolaire
		@RequestMapping(value="/getClassesByAnneeScolaire/{annee}" ,method=RequestMethod.GET)
		public List<Classe> getClassesByAnneeScolaire(@PathVariable("annee") String annee){
			
			return classeRepository.getAllClassesByAnneeScolaire(annee);
		}
	
	
	

	
}
