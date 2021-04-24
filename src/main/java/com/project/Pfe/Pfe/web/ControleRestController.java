package com.project.Pfe.Pfe.web;

import java.text.SimpleDateFormat;
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

import com.project.Pfe.Pfe.dao.AnneeScolaireRepository;
import com.project.Pfe.Pfe.dao.ControleRepository;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.InscriptionRepository;
import com.project.Pfe.Pfe.dao.PlaningRepository;
import com.project.Pfe.Pfe.dao.UserRepostory;
import com.project.Pfe.Pfe.entities.AnneeScolaire;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Controle;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Planing;
import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Controle")
@CrossOrigin("*")
public class ControleRestController {

	@Autowired
	private UserRepostory userRepository;
	
	@Autowired
	private ControleRepository controleRepository;
	
	@Autowired
	private AnneeScolaireRepository yearRepository;
	
	@Autowired
	private PlaningRepository planingRepository;
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	
	
	@RequestMapping(value="/getClassesByCurrentYear/{username}" ,method=RequestMethod.GET)
	public List<Classe> getClassesByCurrentYear(@PathVariable("username") String username){
		
		
		SimpleDateFormat formatter =  new  SimpleDateFormat ( "yyyy" );  
	    Date mydate =  new  Date ();  
	    
	    User prof=new User();
	    prof=userRepository.getUserByUsername(username);
	    
	   
	    
	    String dateP=formatter.format (mydate);
	    int integerDateA=Integer.parseInt(formatter.format (mydate))+1;
	    String dateA=String.valueOf(integerDateA);
	    String anneeScolaire=dateP+"-"+dateA;
	    
	    AnneeScolaire annee=yearRepository.getAnneeScolaireByYear(anneeScolaire);
	    
	    return planingRepository.getClassesByCurrentYear(prof.getIdUser(),annee.getIdAnneeScolaire());
	}
	
	@RequestMapping(value="/getMatiereOfProf/{idClasse}/{username}" ,method=RequestMethod.GET)
	public List<Planing> getMatiereOfProf(@PathVariable("idClasse") int idClasse,@PathVariable("username") String username){
	
		
		User prof=new User();
	    prof=userRepository.getUserByUsername(username);
		
		
		
		return planingRepository.getMatiereOfProf(idClasse, prof.getIdUser());
	
	}
	
	
	
	//GET STUDENTS OF CLASS X
		@RequestMapping(value="/getStudentsOfClass/{idClasse}/{page}/{size}" ,method=RequestMethod.GET)
		public ResponseEntity<List<Etudiant>>  getStudentsOfClass(@PathVariable("idClasse") int idClasse,@PathVariable("page") int page,@PathVariable("size") int size){
		
		Page myPage=inscriptionRepository.getStudentsOfClass(idClasse,new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(myPage, "/Controle/getStudentsOfClass");
		return new ResponseEntity<>(myPage.getContent(),headers,HttpStatus.OK);  
		
		}
		
		@RequestMapping(value="/saveNoteControle" ,method=RequestMethod.POST)
		public Controle saveNoteControle(@RequestBody Controle controle) {
			return  controleRepository.save(controle);
		}
		
		
		// GET NOTES OF CONTROL
		@RequestMapping(value="/getNotesOfStudent/{username}/{page}/{size}" ,method=RequestMethod.GET)
		public  ResponseEntity<List<Controle>> getNotesOfStudents (@PathVariable("username") String username,@PathVariable("page") int page,@PathVariable("size") int size) {
			
		
			
			SimpleDateFormat formatter =  new  SimpleDateFormat ( "yyyy" );  
		    Date mydate =  new  Date ();  
		    
		    String dateP=formatter.format (mydate);
		    int integerDateA=Integer.parseInt(formatter.format (mydate))+1;
		    String dateA=String.valueOf(integerDateA);
		    
		    String anneeScolaire=dateP+"-"+dateA;
		    
			Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
			
		    AnneeScolaire annee=yearRepository.getAnneeScolaireByYear(anneeScolaire);
		    
		    Classe classe=inscriptionRepository.getClassOfStudent(etudiant.getImmat(),annee.getIdAnneeScolaire());
		    
		    Page myPage=controleRepository.getNotesOfStudent(etudiant.getImmat(),classe.getIdClasse(),new PageRequest(page,size));
			
		    HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(myPage, "/Controle/getNotesOfStudent");
			
		    return new ResponseEntity<>(myPage.getContent(),headers,HttpStatus.OK); 
			
	
		}
		@RequestMapping(value="/getTotalFields/{username}" ,method=RequestMethod.GET)
		public int getTotalFields(@PathVariable("username") String username) {
			
			SimpleDateFormat formatter =  new  SimpleDateFormat ( "yyyy" );  
		    Date mydate =  new  Date ();  
		    
		    String dateP=formatter.format (mydate);
		    int integerDateA=Integer.parseInt(formatter.format (mydate))+1;
		    String dateA=String.valueOf(integerDateA);
		    
		    String anneeScolaire=dateP+"-"+dateA;
		    
			Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
			
		    AnneeScolaire annee=yearRepository.getAnneeScolaireByYear(anneeScolaire);
		    
		    Classe classe=inscriptionRepository.getClassOfStudent(etudiant.getImmat(),annee.getIdAnneeScolaire());
		    
		    return  controleRepository.getTotalFields(etudiant.getImmat(),classe.getIdClasse());
		}
		
}
