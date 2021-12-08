package com.mkriiger.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkriiger.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User user = new User("1", "Usuário Teste", "user@email.com");
		User other = new User("2", "Usuário 2", "user2@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user, other));
		return ResponseEntity.ok().body(list);
	}
}
