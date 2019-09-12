package br.com.oiansiedade.oiansiedade;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.oiansiedade.oiansiedade.model.User;
import br.com.oiansiedade.oiansiedade.repository.UserRepository;

@SpringBootApplication
public class OiansiedadeApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void init() {
		User lodgedUser = userRepository.findByUsername("Anderson");
		User chatBotUser = userRepository.findByUsername("DialogFlow Chat");
		if(lodgedUser == null) userRepository.save(new User("Anderson"));
		if(chatBotUser == null) userRepository.save(new User("DialogFlow Chat"));
	}

	public static void main(String[] args) {
		SpringApplication.run(OiansiedadeApplication.class, args);
	}


}
