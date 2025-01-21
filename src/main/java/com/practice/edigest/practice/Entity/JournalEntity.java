package com.practice.edigest.practice.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "Journal_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntity {
    @Id
    private String id;
    private String title;
    private String content;
    private Date data;
}
