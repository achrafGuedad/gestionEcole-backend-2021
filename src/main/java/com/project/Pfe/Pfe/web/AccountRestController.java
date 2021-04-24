package com.project.Pfe.Pfe.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Pfe.Pfe.dao.ClasseRepository;
import com.project.Pfe.Pfe.dao.EtudiantRepository;
import com.project.Pfe.Pfe.dao.InscriptionRepository;
import com.project.Pfe.Pfe.dao.PaiementRepository;
import com.project.Pfe.Pfe.dao.RoleRepository;
import com.project.Pfe.Pfe.dao.UserRepostory;
import com.project.Pfe.Pfe.entities.AnneeScolaire;
import com.project.Pfe.Pfe.entities.Classe;
import com.project.Pfe.Pfe.entities.Etudiant;
import com.project.Pfe.Pfe.entities.Inscription;
import com.project.Pfe.Pfe.entities.Matiere;
import com.project.Pfe.Pfe.entities.User;
import com.project.Pfe.Pfe.entities.appRole;
import com.project.Pfe.Pfe.service.AccountService;
import com.project.Pfe.Pfe.service.EtudiantService;
import com.project.Pfe.Pfe.web.util.PaginationUtil;

@RestController
@RequestMapping(value="Account")
@CrossOrigin("*")
public class AccountRestController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ClasseRepository classeRepository;
	
	@Autowired
	InscriptionRepository inscriptionRepository;
	
	@Autowired
	UserRepostory userRepository;
	
	@Autowired
	private RoleRepository roleRepository; 
	
	@Autowired
	private EtudiantService etudiantService;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private PaiementRepository paiementRepository;
	 
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	@RequestMapping(value="/getUserById/{username}" ,method=RequestMethod.GET)
	public User getUserById(@PathVariable("username") String username){
		return userRepository.getUserByUsername(username);		
			}
	
	@RequestMapping(value="/create/{role}" ,method=RequestMethod.POST)
	public User saveUser(@PathVariable("role") String role,@RequestBody User user){
		appRole roleToFind=roleRepository.getRoleByRolename(role);
		if(roleToFind==null) {
			appRole nouveauRole=new appRole();
			nouveauRole.setRoleName(role);
			roleRepository.save(nouveauRole);
			//user.setPassword(bCryptPasswordEncoder.encode("0000"));
			user.getUserRoles().add(nouveauRole);
		}else {
			
		user.getUserRoles().add(roleToFind);
		//user.setPassword(bCryptPasswordEncoder.encode("0000"));

		}
		return accountService.SaveUser(user);
		}
	
	@RequestMapping(value="/addRoleToUser/{username}/{role}" ,method=RequestMethod.POST)
	public void addRoleToUser(@PathVariable("username") String username,@PathVariable("role") String role) {
		
	 accountService.addRoleToUser(username,role);
	}
	
	
	@RequestMapping(value="/updateUser/{idUser}" ,method=RequestMethod.PUT)
	public User addRoleToUser(@PathVariable("idUser") int idUser,@RequestBody User user) {
	//accountService.addRoleToUser(user.getUsername(),user.getUserRoles().iterator().next().roleName);
	 user.setIdUser(idUser);
	 return accountService.SaveUser(user);
	}

	
	@RequestMapping(value="/getTotalFields" ,method=RequestMethod.GET)
	public int getTotalFields(){
	        return userRepository.getTotalFields();
		
	}
	
	@RequestMapping(value="/deleteUserById/{idUser}" ,method=RequestMethod.DELETE)
	public boolean  deleteUser(@PathVariable("idUser") int idUser ) {
		     accountService.deleteUser(idUser);
		     return true;
	}
	
	
	// inscription Etudiant
	

	
	@RequestMapping(value="/createEtudiant/{role}/{idClasse}" ,method=RequestMethod.POST)
	public Inscription saveUserEtudiant(@PathVariable("role") String role,@PathVariable("idClasse") int idClasse,@RequestBody Inscription inscription) /*throws Exception*/{
		
		String  psw="0000";
		//Inscription inscription;
		appRole roleToFind=roleRepository.getRoleByRolename(role);
		  Classe myClasse=classeRepository.getClasseById(idClasse);
		//User userInscri=userRepository.getUserByUsername(inscription.getEtudiant().getUser().getUsername());
		

		
		if(roleToFind==null) {
			appRole nouveauRole=new appRole();
			nouveauRole.setRoleName(role);
			
			roleRepository.save(nouveauRole);
			
		    
		    String passwordEncoded=bCryptPasswordEncoder.encode(psw);
		    User user;
		    user=new User();
		    user.setPassword(passwordEncoded);
		    user.setUsername(inscription.getEtudiant().getNom() + inscription.getEtudiant().getPrenom());
		    user.getUserRoles().add(nouveauRole);
		    inscription.getEtudiant().setUser(user);
		    
			userRepository.save(user);  
			etudiantRepository.save(inscription.getEtudiant());
			
		}
		else{
			

		    String passwordEncoded=bCryptPasswordEncoder.encode(psw);
		    User user;
		    user=new User();
		    user.setPassword(passwordEncoded);
		    user.setUsername(inscription.getEtudiant().getNom() + inscription.getEtudiant().getPrenom());
		    user.getUserRoles().add(roleToFind);
		    inscription.getEtudiant().setUser(user);
			
			userRepository.save(user);
			etudiantRepository.save(inscription.getEtudiant());
		}
		
		//inscription =new Inscription();
		//inscription.setEtudiant(etudiant);
		//inscription.setClasse(myClasse);
		
		
		paiementRepository.save(inscription.getPaiement());
		//classeRepository.save(inscription.getClasse());
		inscription.setClasse(myClasse);
		return inscriptionRepository.save(inscription);
		

		}
	   
	
	 
	
	//Get User  Prof
	@RequestMapping(value="/getAllTeachers" ,method=RequestMethod.GET)
	public List<User> getTeacher() {
		List<User> listUser=new ArrayList<User>();
		listUser=userRepository.findAll();
	    List<User> listProf=new ArrayList<User>();
		 
	    User user;
		
		 int i=0;
	while (i <listUser.size()) {
			 
			
			if(listUser.get(i).getUserRoles().iterator().next().getRoleName().equalsIgnoreCase("PROFESSEUR")==true) {
				
				
				listProf.add(listUser.get(i));
			}
			
			else { System.out.println("walo");}
			i++;
			
		}
		
		return listProf;
	}
	
	

	@RequestMapping(value="/getAllUsers" ,method=RequestMethod.GET)
	public  List<User> getEmployes() {
		List<User> listUser=new ArrayList<User>();
		listUser=userRepository.findAll();
	    List<User> listProf=new ArrayList<User>();
		 
	    User user;
		
		 int i=0;
	while (i <listUser.size()) {
			 
			
			if(!listUser.get(i).getUserRoles().iterator().next().getRoleName().equalsIgnoreCase("ETUDIANT")==true) {
				
				
				listProf.add(listUser.get(i));
			}
			
			else { System.out.println("walo");}
			i++;
			
		}
		
		return listProf;
		
		
			}
	
	
	
	
	
	
	 
  
}
