package br.com.restwithmongodb.demo.Resources;

import br.com.restwithmongodb.demo.Models.Entities.User;
import br.com.restwithmongodb.demo.Servces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> findAll (){
        return userServices.findAll();
    }

}
