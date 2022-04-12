package emsi.android.spring.numberbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emsi.android.spring.numberbook.model.Pays;
import emsi.android.spring.numberbook.repository.PaysRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/Pays")
@Api(tags = "Pays")
public class PaysController {
	@Autowired
	PaysRepository paysRepository;

	@GetMapping
	public List<Pays> GetAll(){
		return paysRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pays GetById(@PathVariable int id){
		return paysRepository.findById(id).get();
	}
	
	@PostMapping
	public void ajouter(@RequestBody Pays p) {
		paysRepository.save(p);
	}
	
	@DeleteMapping("/{id}")
	public void suppr (@PathVariable int id) {
		paysRepository.deleteById(id);
	}
	
	@PutMapping
	public void mod(@RequestBody Pays npays) {
		Pays p = paysRepository
				.findById((int) npays.getIdP())
				.get();
		if(p!=null) {
			p.setPrefix(npays.getPrefix());
			p.setFlag(npays.getFlag());
		}
	}
	
}
