package com.project.Pfe.Pfe.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.entities.Etudiant;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.project.Pfe.Pfe.service.EtudiantService;

@RestController
@RequestMapping(value="Etudiant")
@CrossOrigin("*")
public class EtudiantRestController {

	@Autowired
	EtudiantService etudiantS;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<Etudiant> getAllStudents(){
		return etudiantS.getAll();
	}
	
	@RequestMapping(value="/getEtudiantByNom/{nomEtudiant}/{prenomEtudiant}" ,method=RequestMethod.GET)
	public Etudiant getEtudiantByNom(@PathVariable("nomEtudiant") String nomEtudiant,@PathVariable("prenomEtudiant") String prenomEtudiant) {
		Etudiant etudiant=etudiantRepository.getEtudiantByNomandPrenom(nomEtudiant, prenomEtudiant);
		return etudiant;  
	}
	
	@RequestMapping(value="/getEtudiantById/{immatEtudiant}" ,method=RequestMethod.GET)
	public Etudiant getEtudiantById(@PathVariable("immatEtudiant") int immatEtudiant) {
		Etudiant etudiant=etudiantRepository.getEtudiantById(immatEtudiant);
		return etudiant;  
	}
	
	
	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	public Etudiant saveStudent(@RequestBody Etudiant etudiant){
		return etudiantS.ajouterEtudiant(etudiant);
		
	}
	
	@RequestMapping(value="/etudiants/{immat}" ,method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int immat ){
		etudiantS.deleteEtudiant(immat);
	}
	
	@RequestMapping(value="/etudiants/modifierEtudiant/{immat}" ,method=RequestMethod.PUT)
	public Etudiant updateStudent(@PathVariable int immat,@RequestBody Etudiant etudiant){
		etudiant.setImmat(immat);
		return etudiantS.ajouterEtudiant(etudiant);
		
	}
	
	
	
	
	
}
