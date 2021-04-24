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

import com.project.Pfe.Pfe.dao.ClasseRepository;
import com.project.Pfe.Pfe.dao.MatiereRepository;
import com.project.Pfe.Pfe.dao.NiveauRepository;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Filiere;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.Niveau;
import com.project.Pfe.Pfe.service.MatiereService;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Matiere")
@CrossOrigin("*")
public class MatiereRestController {
	
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private MatiereRepository matiereRepository; 
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private ClasseRepository classeRepository;

	@RequestMapping(value="/getAll" ,method=RequestMethod.GET)
	public List<Matiere> getAllMatiere(){
		return matiereService.getAllMatiere();
	}
	
	
	@RequestMapping(value="/getMatiereByLibelle/{idNiveau}/{page}/{size}" ,method=RequestMethod.GET)
	public ResponseEntity<List<Matiere>>  getAllMatiere(@PathVariable("idNiveau")int idNiveau ,@PathVariable("page")int page,@PathVariable("size") int size){
		Page <Matiere> pagee= matiereRepository.getAllMatiere(idNiveau,new PageRequest(page,size));
		HttpHeaders headers=PaginationUtil.generatePaginationHttpHeaders(pagee, "/Matiere/getMatiereByLibelle");
	
		
		return new ResponseEntity<>(pagee.getContent(),headers,HttpStatus.OK); 
		
		
			}
	@RequestMapping(value="/getTotalFields/{idNiveau}" ,method=RequestMethod.GET)
	public int getTotalFields(@PathVariable("idNiveau") int idNiveau){
	        return matiereRepository.totalFields(idNiveau);
		
	}
	
	//getMatiereGroupByLibeelle
//		@RequestMapping(value="/getMatiereByNiveau" ,method=RequestMethod.GET)
//		public List<Matiere> getMatiereGroupByNiveau(){
//			return matiereRepository.getMatiereGroupByNiveau();
//		}
	
	@RequestMapping(value="create" ,method=RequestMethod.POST)
	public Matiere saveClasse(@RequestBody Matiere matiere){
		return matiereService.createMatiere(matiere);
		
	}
	
	@RequestMapping(value="/update/{idMatiere}" ,method=RequestMethod.PUT)
	public Matiere updateClasse(@PathVariable int idMatiere,@RequestBody Matiere matiere){
		matiere.setIdMatiere(idMatiere);
		return matiereService.createMatiere(matiere);
		
	}
	
	@RequestMapping(value="/deleteById/{idMatiere}" ,method=RequestMethod.DELETE)
	public boolean deleteNiveau(@PathVariable int idMatiere ){
		matiereService.deleteMatiere(idMatiere);
	    return true;
	}
	
	
	@RequestMapping(value="/getListMatiereByLevel/{idClasse}" ,method=RequestMethod.GET)
	public List<Matiere> getListMatiereByLevel(@PathVariable("idClasse") int idClasse){
	        
		Classe classeToFind=classeRepository.getClasseByIdClasse(idClasse);
		Niveau niveauToFind=niveauRepository.getNiveauById(classeToFind.getNiveau().getIdNiveau());
		
		
		return matiereRepository.getMatiereGroupByLibeelle(niveauToFind.getIdNiveau());
		
	}
	
	@RequestMapping(value="/getMatiereById/{idMatiere}" ,method=RequestMethod.GET)
	public Matiere getMatiereById(@PathVariable("idMatiere") int id){
		return matiereRepository.getOne(id);
	}
	
	
	
	
	
	
	
}
