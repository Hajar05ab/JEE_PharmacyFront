package ma.pharmacie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pharmacie.app.entities.Utilisateur;
import ma.pharmacie.app.service.UserServiceImpl;

@CrossOrigin
@Tag(name = "Users")
@RestController
@RequestMapping(value = "api/users")

public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping(value = "/save")
	public Utilisateur save(@RequestBody Utilisateur object) {
		return userServiceImpl.save(object);
	}
	
	@PutMapping(value = "/update")
	public Utilisateur update(@RequestBody Utilisateur object) {
		return userServiceImpl.update(object);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id) {
		Utilisateur u = userServiceImpl.findById(Integer.parseInt(id));
		userServiceImpl.delete(u);
	}
	
	@GetMapping(value = "/{id}")
	public Utilisateur findById(@PathVariable String id) {
		return userServiceImpl.findById(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/all")
	public List<Utilisateur> findAll() {
		return userServiceImpl.findAll();
	}
	
	
	
	
}
