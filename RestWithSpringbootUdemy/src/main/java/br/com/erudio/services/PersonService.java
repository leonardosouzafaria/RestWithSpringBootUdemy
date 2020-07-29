package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setAdress("Rua dos bobos");
		person.setFirstName("Leo");
		person.setGender("Masculino");
		person.setLastName("Souza");	
		
		return person;
	}

	public List<Person> findAll() {
		List<Person> list = new ArrayList<Person>();
		
		for(int i = 0; i < 8; i++) {
			list.add(mockPerson(i));			
		}
		
		return list;
	}

	private Person mockPerson(int i) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setAdress("some Address");
		person.setFirstName("Person name " + i);
		person.setGender("male");
		person.setLastName("some Last name");	
		
		return person;
	}

	public Person create(Person person) {
		person.setId(counter.incrementAndGet());
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
}
