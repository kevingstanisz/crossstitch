package com.example.crossstitch.PDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExtractPDF {

    public ExtractPDF(String pdfFilename) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilename));
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        for (int page = 0; page < document.getNumberOfPages(); ++page)
        {
            BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 1200, ImageType.RGB);

            // suffix in filename will be used as the file format
            File file = new File(pdfFilename + "img_" + page + ".tiff");
            ImageIO.write(bim, "tiff", file);

            // ImageIOUtil.writeImage(bim, pdfFilename + "-" + (page+1) + ".tif", 300);
        }
        document.close();
    }

    public static void main(String[] args) {

    }
}
