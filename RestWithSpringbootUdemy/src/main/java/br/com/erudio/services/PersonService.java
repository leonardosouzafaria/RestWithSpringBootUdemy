package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {	
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person findById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found for this ID."));
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}
	

	public Person create(Person person) {
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found for this ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return personRepository.save(entity);		
	}
	
	public void delete(Long id) {		
		personRepository.deleteById(id);
	}
}
