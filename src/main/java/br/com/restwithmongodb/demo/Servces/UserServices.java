package br.com.restwithmongodb.demo.Servces;

import br.com.restwithmongodb.demo.DTO.UserDTO;
import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Models.Exceptions.ObjectNotFoundException;
import br.com.restwithmongodb.demo.Models.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void delete (String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update (String id, User user){
        User newUser = findById(id);
        updateData(user, newUser);
        userRepository.save(user);
        return user;
    }

    public void updateData (User user, User newUser){
       user.setEmail(newUser.getEmail());
       user.setName(newUser.getName());
    }

    public User fromDto (UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
