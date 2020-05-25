package br.com.restwithmongodb.demo.Models.Repositories;

import br.com.restwithmongodb.demo.Models.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
