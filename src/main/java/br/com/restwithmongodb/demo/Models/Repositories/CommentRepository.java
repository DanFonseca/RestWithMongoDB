package br.com.restwithmongodb.demo.Models.Repositories;

import br.com.restwithmongodb.demo.Models.Entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
