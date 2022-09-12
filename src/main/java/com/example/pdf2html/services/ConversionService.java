package com.example.pdf2html.services;

import com.example.pdf2html.dto.ConversionDto;
import com.example.pdf2html.entities.Conversion;
import com.example.pdf2html.repositories.ConversionRepo;
import com.example.pdf2html.utility.Pdf;
import org.jpedal.exception.PdfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ConversionService implements IConversionService {

    public ConversionService(ConversionRepo conversionRepo) {
        this.conversionRepo = conversionRepo;
    }

    @Autowired
    private ConversionRepo conversionRepo;

    @Autowired
    Pdf pdf;
    @Override
    public Flux<Conversion> getConversion() {
        return conversionRepo.findAll();
    }

    @Override
    public Flux<Conversion> PostConversion(@RequestBody ConversionDto conversionDto) throws PdfException, IOException {
        List<String> list=new ArrayList<>();
        Conversion conversion = new Conversion();
        List<Conversion> conversionList=new ArrayList<>();
        list=conversionDto.getList();
        for (int i=0;i<list.size();i++) {
            String conversionId = UUID.randomUUID().toString();
            conversion.setCreatedTime(Instant.now());
            conversion.setStatus("not started");
            String path = pdf.conversion(list.get(i), conversionId);
            conversion.setConversionId(conversionId);
            conversion.setPdfUrl(list.get(i));
            conversion.setConvertedPath(path);
            conversion.setStatus("completed");
            conversion.setModifiedTime(Instant.now());
            conversionList.add(conversion);
        }
            return conversionRepo.saveAll(conversionList);
    }
}
