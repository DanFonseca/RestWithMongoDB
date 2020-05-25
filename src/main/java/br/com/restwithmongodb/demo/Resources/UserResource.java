package br.com.restwithmongodb.demo.Resources;

import br.com.restwithmongodb.demo.DTO.UserDTO;
import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Servces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<UserDTO> findAll (){
        List<UserDTO> userDTOS = userServices.findAll()
                .stream()
                .map(x -> new UserDTO(x))
                .collect(Collectors.toList());

        return  userDTOS;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById (@PathVariable String id){
        UserDTO userDTO = new UserDTO(userServices.findById(id));
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userServices.fromDto(userDTO);
        userServices.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value= "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable String id){
        userServices.delete(id);
        return ResponseEntity.ok().build();
    }

}
