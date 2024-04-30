package tui.meta.challenge.quotes.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tui.meta.challenge.quotes.dto.QuoteDto;
import tui.meta.challenge.quotes.repository.QuoteRepository;

@Service
public class QuotesService {
    
    private final QuoteRepository repository;

    public QuoteDto findQuoteById(String id) {
        return new QuoteDto(repository
            .findById(id)
            .orElseThrow(
                () -> new NoSuchElementException("There where no elements found with id: " + id)));
    }

    public List<QuoteDto> findQuotesByAuthor(String author) {
        return repository.findByQuoteAuthor(author)
                    .stream()
                    .map(q -> new QuoteDto(q))
                    .collect(Collectors.toList());
    }

    public List<QuoteDto> findAllQuotes() {
        return repository.findAll()
                    .stream()
                    .map(q -> new QuoteDto(q))
                    .collect(Collectors.toList());
    }

    public QuotesService(QuoteRepository repository) {
        this.repository = repository;
    }
}
