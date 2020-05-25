package br.com.restwithmongodb.demo.Servces;

import br.com.restwithmongodb.demo.DTO.UserDTO;
import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Models.Exceptions.ObjectNotFoundException;
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
    public void saveAll (List<User> users){
        userRepository.saveAll(users);
    }

    public User findById (String id){
      return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void insert (User user){
        userRepository.insert(user);
    }

    public User fromDto (UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
