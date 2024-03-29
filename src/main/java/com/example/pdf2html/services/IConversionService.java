package com.example.pdf2html.services;

import com.example.pdf2html.dtos.ConversionDto;
import com.example.pdf2html.entities.Conversion;
import org.jpedal.exception.PdfException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Service
public interface IConversionService {

    Flux<Conversion> getConversion();

    Flux<Conversion> PostConversion(ConversionDto conversionDto) throws PdfException, IOException;
}
