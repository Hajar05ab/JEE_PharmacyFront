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
import ma.pharmacie.app.entities.Ville;
import ma.pharmacie.app.entities.Zone;
import ma.pharmacie.app.service.ZoneServiceImpl;

@Tag(name = "Zones")
@RestController
@CrossOrigin
@RequestMapping(value = "/api/zones")
public class ZoneController {
	@Autowired
	private ZoneServiceImpl zoneServiceImpl;

	@PostMapping(value = "/save")
	public Zone save(@RequestBody Zone object) {
		return zoneServiceImpl.save(object);
	}

	@PutMapping(value = "/update")
	public Zone update(@RequestBody Zone object) {
		return zoneServiceImpl.update(object);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Zone z = zoneServiceImpl.findById(Integer.parseInt(id));
		zoneServiceImpl.delete(z);
	}

	@GetMapping(value = "/{id}")
	public Zone findById(@PathVariable String id) {
		return zoneServiceImpl.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/all")
	public List<Zone> findAll() {
		return zoneServiceImpl.findAll();
	}

}
