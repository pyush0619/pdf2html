package com.example.pdf2html.utility;

//import lombok.var;
import org.apache.commons.io.FileUtils;
import org.jpedal.examples.html.PDFtoHTML5Converter;
import org.jpedal.exception.PdfException;
import org.jpedal.render.output.IDRViewerOptions;
import org.jpedal.render.output.html.HTMLConversionOptions;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class Pdf {
//    public static void main(final String[] args) throws PdfException, IOException {
//       HTMLConversionOptions conversionOptions = new HTMLConversionOptions();
//       IDRViewerOptions viewerOptions = new IDRViewerOptions();
//       var pdfFile = new File("C:/Users/pyush.gupta/Desktop/MLP certi/0342991137TS.pdf");
//       FileUtils.copyURLToFile(new URL("https://arxiv.org/pdf/1911.11423.pdf"),new File("C:/Users/pyush.gupta/Desktop/MLP certi/2html.pdf"));
//       var outputFile = new File("C:/Users/tanvi.sharma/Desktop/Magic certificates/hey");
//       var converter = new PDFtoHTML5Converter(pdfFile,outputFile,conversionOptions,viewerOptions);
//       converter.convert();
//    }
    public String conversion(String url, String id) throws IOException, PdfException{
        String pdfPath = "C:/Users/pyush.gupta/Desktop/MLP certi/"+id+".pdf";
        String htmlPath = "C:/Users/pyush.gupta/Desktop/MLP certi/2html/";
        HTMLConversionOptions conversionOptions = new HTMLConversionOptions();
        IDRViewerOptions viewerOptions = new IDRViewerOptions();
        FileUtils.copyURLToFile(new URL(url), new File(pdfPath));
        var converter = new PDFtoHTML5Converter(new File(pdfPath), new File(htmlPath), conversionOptions,viewerOptions);
        converter.convert();
        return htmlPath+id;
    }
}
