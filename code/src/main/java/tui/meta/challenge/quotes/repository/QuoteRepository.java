package tui.meta.challenge.quotes.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import tui.meta.challenge.quotes.entity.Quote;

@Repository
public interface QuoteRepository extends MongoRepository<Quote, String> {

    @Query("{ '_id' : ?0 }")
    Optional<Quote> findBy_id(String _id);

    List<Quote> findByQuoteAuthor(String quoteAuthor);

}
