package com.kelviribeiro.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kelviribeiro.workshopmongo.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;

	public UserDTO() {

	}

	public UserDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}
	
	public User returnEntity() {
		User user= new User();
		user.setId(id);		
		user.setName(name);
		user.setEmail(email);
		return user;
	}
	
	public static List<UserDTO> returnListPojo(List<User> list) {
		List<UserDTO> listDto = new ArrayList<UserDTO>();
		list.stream().forEach(x -> {
			listDto.add(new UserDTO(x));
		});
		
		return listDto;
	}
	
	public static List<UserDTO> returnListPojoWithMap(List<User> list) {
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());		
		return listDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
