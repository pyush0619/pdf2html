package com.example.pdf2html.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ConversionDto {
    /*
    private String pdfUrl;
    private String convertedPath;
    */

    List<String> list=new ArrayList<>();
}
