package univ.iwa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
	@Id
	Long id;
	String nom;
	int age;
	String photo;
	@ManyToOne
	Filiere filiere;
}
