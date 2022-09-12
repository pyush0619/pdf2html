package com.example.pdf2html.handlers;
import com.example.pdf2html.dtos.ConversionDto;
import com.example.pdf2html.entities.Conversion;
import com.example.pdf2html.services.ConversionService;
import com.example.pdf2html.services.IConversionService;
import org.jpedal.exception.PdfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.springframework.http.HttpStatus.OK;

@Component
public class ConversionHandler {

    @Autowired
    private IConversionService conversionService;

    public ConversionHandler(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public Mono<ServerResponse> getConversion(ServerRequest serverRequest) {
        Flux<Conversion> AllConversion =conversionService.getConversion();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(AllConversion, Conversion.class);
    }

    public Mono<ServerResponse> PostConversion(ServerRequest serverRequest){
        Mono<ConversionDto> newConversion=serverRequest.bodyToMono(ConversionDto.class);
        return newConversion.flatMap(c ->
        {
            try {
                return ServerResponse.status(OK).contentType(MediaType.APPLICATION_JSON)
                        .body(conversionService.PostConversion(c),Conversion.class);
            } catch (PdfException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
