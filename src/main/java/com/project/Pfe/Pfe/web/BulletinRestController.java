package com.project.Pfe.Pfe.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.AnneeScolaireRepository;
import com.project.Pfe.Pfe.dao.BulletinRepository;
import com.project.Pfe.Pfe.dao.ControleRepository;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.InscriptionRepository;
import com.project.Pfe.Pfe.dao.MatiereRepository;
import com.project.Pfe.Pfe.dao.NiveauRepository;
import com.project.Pfe.Pfe.entities.AnneeScolaire;
import com.project.Pfe.Pfe.entities.Bulletin;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Controle;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Niveau;

@RestController
@RequestMapping(value="Bulletin")
@CrossOrigin("*")
public class BulletinRestController {

	@Autowired
	private ControleRepository controleRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private AnneeScolaireRepository yearRepository;
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	
	@Autowired
	private BulletinRepository bulletinRepository;
	
	@RequestMapping(value="/generateBulletin/{username}" ,method=RequestMethod.POST)
	public boolean generateBulletin(@PathVariable("username") String username) {
		
		 
		 List<Bulletin> listeBulletin =new ArrayList <Bulletin>();
		 ArrayList <Double>ListmoyenneMatiere;
		  
		 double MoyenneMatiere = 0;
		 double moyFinale=0;
		 
		 double coef=0;
		 double moyenneMatiereBulettin=0;
		 
		  Bulletin bulletin;
		
		SimpleDateFormat formatter =  new  SimpleDateFormat ( "yyyy" );  
	    Date mydate =  new  Date ();  
	    
	    String dateP=formatter.format (mydate);
	    int integerDateA=Integer.parseInt(formatter.format (mydate))+1;
	    String dateA=String.valueOf(integerDateA);
	    
	    String anneeScolaire=dateP+"-"+dateA;
	    
		Etudiant etudiant=etudiantRepository.getEtudiantByIdUsername(username);
		
	    AnneeScolaire annee=yearRepository.getAnneeScolaireByYear(anneeScolaire);
	    
	    Classe classe=inscriptionRepository.getClassOfStudent(etudiant.getImmat(),annee.getIdAnneeScolaire());
	    
	    List <Matiere> listMatiere=matiereRepository.getMatiereGroupByLibeelle(classe.getNiveau().getIdNiveau());
	    
	    for  (int i=0;i<listMatiere.size();i++) {
	    	
	    	
	    	
	    	 List<Controle> controleEtudiantMatiere=controleRepository.generateBulletin(etudiant.getImmat(),classe.getIdClasse(),listMatiere.get(i).getIdMatiere());
	    	
	    	 	    	
	    	for(int j=0;j<controleEtudiantMatiere.size();j++) {
	    		  
	    		
	     		MoyenneMatiere=(controleEtudiantMatiere.get(j).getNote() ) *(controleEtudiantMatiere.get(j).getMatiere().getCoeffitien()) ;
	     		moyFinale=moyFinale+MoyenneMatiere;
	    		
	    	}
	    	
	    	
	    	
	    	//moyenneMatiereBulettin=(moyFinale/(controleEtudiantMatiere.size() * listMatiere.get(i).getCoeffitien()));
	       	
	       	
	    	  	
	   /* bulletin=new Bulletin();
	    bulletin.setEtudiant(etudiant);
	    bulletin.setClasse(classe);
	    bulletin.setMatiere(listMatiere.get(i));
	    bulletin.setNotefinaleMatiere(moyenneMatiereBulettin);
	    */
	    	
	    //bulletinRepository.save(new Bulletin(etudiant,classe,moyenneMatiereBulettin));
	     
	    	        
	    	 
	    }
	    
	    
	    
	    //moyenneMatiereBulettin=(moyFinale/(controleEtudiantMatiere.size() * listMatiere.get(i).getCoeffitien()));
	    //bulletinRepository.save(new Bulletin(etudiant,classe,moyenneMatiereBulettin));
	    return true;
	    //for(int n=0;n<listeBulletin.size();n++) {}
	    
	    

	    
	      
	    	  
	}
}
