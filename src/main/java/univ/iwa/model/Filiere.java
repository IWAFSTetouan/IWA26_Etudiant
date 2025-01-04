package univ.iwa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Filiere {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Long id;
 String nom;
 @OneToMany(mappedBy = "filiere")
 @JsonIgnore
 List<Etudiant> etudiants;
}
