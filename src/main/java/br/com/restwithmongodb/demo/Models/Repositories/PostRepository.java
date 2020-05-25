package br.com.restwithmongodb.demo.Models.Repositories;

import br.com.restwithmongodb.demo.Models.Entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
