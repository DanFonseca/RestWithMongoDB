package br.com.restwithmongodb.demo.config;

import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Models.Repositories.UserRepository;
import br.com.restwithmongodb.demo.Servces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class configs implements CommandLineRunner  {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

    }
}
