package br.com.restwithmongodb.demo.Resources;

import br.com.restwithmongodb.demo.Models.Entities.Post;
import br.com.restwithmongodb.demo.Resources.Utils.URI;
import br.com.restwithmongodb.demo.Servces.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping(value = "posts")
public class PostResource {

    @Autowired
    private PostServices postServices;

    @RequestMapping (value = "{id}")
    public ResponseEntity<Post> postById (@PathVariable String id){
        return ResponseEntity.ok().body(postServices.findById(id));
    }
    @GetMapping(value = "titleSearch")
    public ResponseEntity<List<Post>> findByTitle
            (@RequestParam(name = "title", defaultValue = "")
                    String title)
    {
    String uri = URI.decoding(title);
    List<Post> posts = postServices.findByTitle(uri);
    return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "searchByTextAndDate")
    public ResponseEntity<List<Post>> searchByTextAndDate (
            @RequestParam(value="text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate)
    {
        Date min = URI.convertDate(minDate);
        Date max = URI.convertDate(maxDate);
        String txt = URI.decoding(text);

        return ResponseEntity.ok().body(postServices.searchByTextAndDate(txt,min,max));
    }
}
