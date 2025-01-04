package univ.iwa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.iwa.model.Filiere;
import univ.iwa.repository.FiliereRepository;

@Service
public class FiliereService {
	@Autowired FiliereRepository filiereRepository;
	public Filiere addFiliere(Filiere filiere) {
		return filiereRepository.save(filiere);
	}
	public List<Filiere> getAllFilieres() {
		return filiereRepository.findAll();
	}

}
