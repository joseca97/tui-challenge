package tui.meta.challenge.quotes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document("quotes")
@Data
@AllArgsConstructor
public class Quote {

    @Id
    private String id;
    private String quoteText;
    private String quoteAuthor;
    private String quoteGenre;
}
