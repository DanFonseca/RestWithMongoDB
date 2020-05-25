package br.com.restwithmongodb.demo.config;

import br.com.restwithmongodb.demo.DTO.AuthorDTO;
import br.com.restwithmongodb.demo.Models.Entities.Post;
import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Models.Repositories.PostRepository;
import br.com.restwithmongodb.demo.Models.Repositories.UserRepository;
import br.com.restwithmongodb.demo.Servces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class configs implements CommandLineRunner  {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User daniel = new User(null, "Daniel Freiras", "daniel@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob, daniel));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Post post1 = new Post(null,sdf.parse("2018-03-21") ,"Partiu Viagem", "Vou viajar para SP. Abraços!", new AuthorDTO(daniel));
        Post post2 = new Post(null, sdf.parse("2018-08-23"),"Bom dia!", "Acordei Feliz hoje!", new AuthorDTO(daniel));
        postRepository.saveAll(Arrays.asList(post1,post2));

    }
}
