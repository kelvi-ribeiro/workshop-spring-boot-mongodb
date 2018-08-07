package com.kelviribeiro.workshopmongo.resources;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kelviribeiro.workshopmongo.domain.User;
import com.kelviribeiro.workshopmongo.dto.UserDTO;
import com.kelviribeiro.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = UserDTO.returnListPojo(service.findAll());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
}
