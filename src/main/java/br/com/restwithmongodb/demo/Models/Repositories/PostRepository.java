package br.com.restwithmongodb.demo.Models.Repositories;

import br.com.restwithmongodb.demo.Models.Entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String title);
}
