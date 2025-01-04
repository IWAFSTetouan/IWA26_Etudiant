package univ.iwa.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import univ.iwa.model.Etudiant;
import univ.iwa.model.Filiere;
import univ.iwa.repository.EtudiantRepository;

@Service
public class EtudiantService {
	@Autowired
	EtudiantRepository etudiantRepository;
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	public boolean deleteEtudiantById(Long id) {
		String path="src/main/resources/static/photos/"+id+".png";
		File file=new File(path);
		if (file.exists())file.delete();
		etudiantRepository.deleteById(id);
		return !etudiantRepository.existsById(id);
	}

	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	public Optional<Etudiant> getEtudiantById(Long id) {
		return etudiantRepository.findById(id);
	}

	public List<Etudiant> getEtudiantByNom(String nom) {
		return etudiantRepository.findByNomIgnoreCase(nom);
	}

	public List<Etudiant> getAllEtudiantsAgeLessThan(int ageMax) {
		return etudiantRepository.findByAgeLessThan(ageMax);
	}

	public List<Etudiant> getEtudiantPagination(int p, int s, String f) {
		Pageable pg=PageRequest.of(p,s,Sort.by(f));
		Page<Etudiant> pageEtudiants=etudiantRepository.findAll(pg);
		return pageEtudiants.getContent();
	}

	public List<Etudiant> getAllEtudiantsByFiliere(Filiere filiere) {
		return etudiantRepository.findByFiliere(filiere);
	}

}
