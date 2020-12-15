import com.example.crossstitch.PDF.ExtractPDF;

import java.io.IOException;

public class Main {

    private static String pdfFilename = "C:\\Users\\Kevin\\Desktop\\example1.pdf";

    public static void main(String[] args) {
        try {
            ExtractPDF extractPDF = new ExtractPDF(pdfFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
