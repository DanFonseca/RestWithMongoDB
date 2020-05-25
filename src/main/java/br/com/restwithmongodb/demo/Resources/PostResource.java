package br.com.restwithmongodb.demo.Resources;

import br.com.restwithmongodb.demo.Models.Entities.Post;
import br.com.restwithmongodb.demo.Servces.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "posts")
public class PostResource {

    @Autowired
    private PostServices postServices;

    @RequestMapping (value = "{id}")
    public ResponseEntity<Post> postById (@PathVariable String id){
        return ResponseEntity.ok().body(postServices.findById(id));
    }
}
