package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {	
	
	@Autowired
	private PersonRepository personRepository;
	
	public PersonVO findById(Long id) {
		PersonVO personVO = DozerConverter.parseObject( personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this ID.") ), PersonVO.class);
		
		return personVO;
	}

	public List<PersonVO> findAll() {
		List<PersonVO> list = DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
		return list;
	}
	

	public PersonVO create(PersonVO personVO) {
		Person person = DozerConverter.parseObject(personVO, Person.class);
		Person entity = personRepository.save(person);
		
		return  DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO personVO) {
		Person person = DozerConverter.parseObject(personVO, Person.class);
		Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found for this ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);		
	}
	
	public void delete(Long id) {		
		personRepository.deleteById(id);
	}
}
