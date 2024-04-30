package tui.meta.challenge.quotes.dto;

import lombok.Data;
import tui.meta.challenge.quotes.entity.Quote;

@Data
public class QuoteDto {

    private String id;
    private String quoteText;
    private String quoteAuthor;
    private String quoteGenre;

    public QuoteDto(Quote entity) {
        this.id = entity.getId();
        this.quoteText = entity.getQuoteText();
        this.quoteAuthor = entity.getQuoteAuthor();
        this.quoteGenre = entity.getQuoteGenre();
    }

}
