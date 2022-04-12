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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import emsi.android.spring.numberbook.model.Contact;
import emsi.android.spring.numberbook.repository.ContactRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/Contacts")
@Api(tags = "Contacts")
public class ContactController {

	@Autowired
	ContactRepository contactRepository;

	@GetMapping
	public List<Contact> GetAll(){
		return contactRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Contact GetById(@PathVariable int id){
		return contactRepository.findById(id).get();
	}
	
	@PostMapping
	public void Ajouter(Contact p) {
		contactRepository.save(p);
	}
	
	@DeleteMapping("/{id}")
	public void suppr (@PathVariable int id) {
		contactRepository.deleteById(id);
	}
	
	@PutMapping
	public void mod(@RequestBody Contact nContact) {
		Contact p = contactRepository
				.findById((int) nContact.getIdC())
				.get();
		if(p!=null) {
			p.setNom(nContact.getNom());
			p.setTelephone(nContact.getTelephone());
		}
	}
	
	@PostMapping("/search")
	public BestMatch search(@RequestBody Contact c) {
		return contactRepository.findContactByPrefixN(c.getPrefix(), c.getTelephone());
	}
	
}
