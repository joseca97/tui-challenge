package tui.meta.challenge.quotes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tui.meta.challenge.quotes.dto.QuoteDto;
import tui.meta.challenge.quotes.entity.Quote;
import tui.meta.challenge.quotes.repository.QuoteRepository;

@ExtendWith(MockitoExtension.class)
public class QuotesServiceTest {

    @Mock
    private QuoteRepository repository;

    @InjectMocks
    private QuotesService service;

    private List<Quote> testQuotes;

    @BeforeEach
    void setup() {
        Quote q1 = new Quote("quote1", "testText1", "testAuthor1", "testGenre1");
        Quote q2 = new Quote("quote2", "testText2", "testAuthor1", "testGenre2");
        Quote q3 = new Quote("quote3", "testText3", "testAuthor2", "testGenre3");
        testQuotes = Arrays.asList(q1, q2, q3);
    }

    @Test
    void testFindQuouteById() {
        Mockito.when(repository.findById(Mockito.eq("quote1"))).thenReturn(Optional.of(testQuotes.get(0)));
        QuoteDto result = service.findQuoteById("quote1");
        assertEquals("quote1", result.getId());
        assertEquals("testText1", result.getQuoteText());
    }

    @Test
    void testFindQuouteById_NotFound() {
        Mockito.when(repository.findById(Mockito.eq("quote1"))).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.findQuoteById("quote1"));
    }

    @Test
    void testFindQuotesByAuthor() {
        Mockito.when(repository.findByQuoteAuthor(Mockito.eq("testAuthor1"))).thenReturn(testQuotes.subList(0, 2));
        List<QuoteDto> results = service.findQuotesByAuthor("testAuthor1");
        assertEquals("quote1", results.get(0).getId());
        assertEquals("quote2", results.get(1).getId());
    }

    @Test
    void testFindAllQuotes() {
        Mockito.when(repository.findAll()).thenReturn(testQuotes);
        List<QuoteDto> results = service.findAllQuotes();
        assertEquals(3, results.size());
    }
}
