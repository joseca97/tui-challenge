package tui.meta.challenge.quotes.controller;

import org.springframework.web.bind.annotation.RestController;

import tui.meta.challenge.quotes.repository.QuoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/quotes")
public class QuoteController {
    
    @GetMapping("/{id}")
    public String findQuoteById(@PathVariable String id) {
        return new String(id + " is working");
    }
    
}
