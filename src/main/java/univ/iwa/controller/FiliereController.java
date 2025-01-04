package univ.iwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import univ.iwa.model.Filiere;
import univ.iwa.service.FiliereService;

@RestController
@RequestMapping("iwa")
public class FiliereController {
	@Autowired FiliereService filiereService;
	@PostMapping("filieres")
	public Filiere addFiliere(@RequestBody Filiere filiere) {
		return filiereService.addFiliere(filiere);
	}
	@GetMapping
	public List<Filiere> getAllFilieres(){
		return filiereService.getAllFilieres();
	}
}
