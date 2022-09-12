package com.example.pdf2html.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "conversionDB")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Conversion {

    @Id
    private String conversionId;
    private String status;
    private String pdfUrl;
    private String convertedPath;
    private Instant createdTime;
    private Instant modifiedTime;

}
