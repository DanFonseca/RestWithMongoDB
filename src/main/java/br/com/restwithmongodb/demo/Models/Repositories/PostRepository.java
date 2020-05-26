package br.com.restwithmongodb.demo.Models.Repositories;

import br.com.restwithmongodb.demo.Models.Entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle (String title);

    @Query("{ $and: " +
            "[ { date: {$gte: ?1} }," +
            " { date: { $lte: ?2} } , " +
            "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'body': { $regex: ?0, $options: 'i' } }," +
            " { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> searchByTextAndDate (String tex, Date minDate, Date maxDate);

    List<Post> findByTitleContainingIgnoreCase(String title);
}
