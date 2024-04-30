package tui.meta.challenge.quotes.controller;

import org.springframework.web.bind.annotation.RestController;

import tui.meta.challenge.quotes.dto.QuoteDto;
import tui.meta.challenge.quotes.service.QuotesService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/quotes")
public class QuotesController {

    private final QuotesService service;
    
    @GetMapping
    public QuoteDto findQuoteById(@RequestParam String id) {
        return service.findQuoteById(id);
    }

    @GetMapping("/author")
    public List<QuoteDto> findQuotesByAuthorName(@RequestParam String author) {
        return service.findQuotesByAuthor(author);
    }

    @GetMapping("/all")
    public List<QuoteDto> findAllQuotes() {
        return service.findAllQuotes();
    }

    public QuotesController(QuotesService service) {
        this.service = service;
    }
    
}
