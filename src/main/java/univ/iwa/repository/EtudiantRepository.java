package univ.iwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.iwa.model.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
public List<Etudiant> findByNomIgnoreCase(String nom);
public List<Etudiant> findByAgeLessThan(int ageMax);
}
