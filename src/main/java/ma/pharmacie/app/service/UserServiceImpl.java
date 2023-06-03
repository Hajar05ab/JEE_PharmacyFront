package ma.pharmacie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.Utilisateur;
import ma.pharmacie.app.imetier.IMetier;
import ma.pharmacie.app.repository.UserRepository;

@Service
public class UserServiceImpl implements IMetier<Utilisateur>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Utilisateur save(Utilisateur object) {
		return this.userRepository.save(object);
		
	}

	@Override
	public Utilisateur update(Utilisateur object) {
		
		return this.userRepository.save(object);
	}

	@Override
	public void delete(Utilisateur object) {
		this.userRepository.delete(object);
		
	}

	@Override
	public Utilisateur findById(int id) {
		return this.userRepository.findById(id);
	}

	@Override
	public List<Utilisateur> findAll() {
		return this.userRepository.findAll();
	}



}
