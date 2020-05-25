package br.com.restwithmongodb.demo.Servces;

import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Models.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }
}
