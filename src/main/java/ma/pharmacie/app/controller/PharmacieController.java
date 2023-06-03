package ma.pharmacie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pharmacie.app.entities.Pharmacie;
import ma.pharmacie.app.service.PharmacieServiceImpl;

@Tag(name = "Pharmacies")
@RestController
@RequestMapping(value = "/api/pharmacies")
@CrossOrigin
public class PharmacieController {
	@Autowired
	private PharmacieServiceImpl pharmacieServiceImpl;

	@PostMapping(value = "/save")
	public Pharmacie save(Pharmacie object) {
		return pharmacieServiceImpl.save(object);
	}

	@PutMapping(value = "/update")
	public Pharmacie update(Pharmacie object) {
		return pharmacieServiceImpl.update(object);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Pharmacie p = pharmacieServiceImpl.findById(Integer.parseInt(id));
		pharmacieServiceImpl.delete(p);
	}

	@GetMapping(value = "/{id}")
	public Pharmacie findById(@PathVariable String id) {
		return pharmacieServiceImpl.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/all")
	public List<Pharmacie> findAll() {
		return pharmacieServiceImpl.findAll();
	}

}
