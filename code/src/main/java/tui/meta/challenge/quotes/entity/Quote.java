package tui.meta.challenge.quotes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Document("quotes")
@Data
public class Quote {

    @Id
    private String id;

    private String quoteText;

    private String quoteAuthor;

    private String quoteGenre;
    
}
