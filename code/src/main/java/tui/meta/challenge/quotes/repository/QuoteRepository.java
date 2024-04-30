package tui.meta.challenge.quotes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import tui.meta.challenge.quotes.entity.Quote;

public interface QuoteRepository extends MongoRepository<Quote, String> {
    
    
}
