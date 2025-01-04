package univ.iwa.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import univ.iwa.model.Etudiant;
import univ.iwa.model.Filiere;
import univ.iwa.repository.FiliereRepository;
import univ.iwa.service.EtudiantService;

@RestController
@RequestMapping("iwa")
public class EtudiantController {
	
	@Autowired	EtudiantService etudiantService;
	@Autowired  FiliereRepository filiereRepository;
	
@PostMapping("etudiants/{nomfil}")
	public Etudiant addEtudiant(
			@RequestParam Long id,
			@RequestParam String nom,
			@RequestParam int age,
			@RequestParam MultipartFile photo,
			@PathVariable String nomfil
			) throws IllegalStateException, IOException {
	String path="src/main/resources/static/photos/"+id+".png";
	photo.transferTo(Path.of(path));
	String url="http://localhost:8080/iwa/photos/"+id;
	Filiere filiere=filiereRepository.findByNom(nomfil);
	Etudiant etudiant=new Etudiant(id, nom, age, url,filiere);
	return etudiantService.addEtudiant(etudiant);
}
@GetMapping("photos/{id}")
public ResponseEntity<Resource> getImage(@PathVariable Long id){
	String path="src/main/resources/static/photos/"+id+".png";
	FileSystemResource file=new FileSystemResource(path);
	if (!file.exists()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file);
}

@GetMapping("etudiants")
	public List<Etudiant> getAllEtudiants(){
	return etudiantService.getAllEtudiants();
}
@GetMapping("{nomfil}/etudiants")
public List<Etudiant> getAllEtudiantsByFiliere(@PathVariable String nomfil){
	Filiere filiere=filiereRepository.findByNom(nomfil);
return etudiantService.getAllEtudiantsByFiliere(filiere);
}
@GetMapping("etudiants/{page}/{size}/{field}")
	public List<Etudiant> getEtudiantPagination(@PathVariable int page,@PathVariable int size,@PathVariable String field){
		return etudiantService.getEtudiantPagination(page,size,field);
}
@DeleteMapping("etudiants/{id}")
	public boolean deleteEtudiantById(@PathVariable Long id) {
	return etudiantService.deleteEtudiantById(id);
}
@PutMapping("etudiants")
public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
return etudiantService.updateEtudiant(etudiant);
}
@GetMapping("etudiants/{id}")
public Optional<Etudiant> getEtudiantById(@PathVariable Long id) {
	return etudiantService.getEtudiantById(id);
}
@GetMapping("etudiants/nom/{nom}")
public List<Etudiant> getEtudiantByNom(@PathVariable String nom) {
	return etudiantService.getEtudiantByNom(nom);
}
@GetMapping("etudiants/age/{ageMax}")
public List<Etudiant> getAllEtudiantsAgeLessThan(@PathVariable int ageMax){
	return etudiantService.getAllEtudiantsAgeLessThan(ageMax);
}
}
