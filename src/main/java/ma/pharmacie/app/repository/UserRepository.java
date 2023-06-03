package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Utilisateur;


	public interface UserRepository extends JpaRepository<Utilisateur, Integer> {
		public Utilisateur findById(int id);

	}

