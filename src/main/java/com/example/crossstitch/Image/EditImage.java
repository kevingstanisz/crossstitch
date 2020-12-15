package com.example.crossstitch.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EditImage {

    private static String inputFile = "C:\\Users\\Kevin\\Desktop\\example1.pdf-5.png";

    public static void main(String args[])throws IOException
    {
        BufferedImage img = null;
        File f = null;

        //read image
        try
        {
            f = new File(inputFile);
            img = ImageIO.read(f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        Set<Integer> colorList = new HashSet<Integer>();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                colorList.add(img.getRGB(i,j));
            }
        }

        for(Integer color : colorList) {
            System.out.println(color);
        }

        int p = img.getRGB(0,0);

        // get alpha
        int a = (p>>24) & 0xff;

        // get red
        int r = (p>>16) & 0xff;

        // get green
        int g = (p>>8) & 0xff;

        // get blue
        int b = p & 0xff;

        /*
        for simplicity we will set the ARGB
        value to 255, 100, 150 and 200 respectively.
        */
        a = 255;
        r = 100;
        g = 150;
        b = 200;

        //set the pixel value
        p = (a<<24) | (r<<16) | (g<<8) | b;
        img.setRGB(0, 0, p);

        //write image
        try
        {
            f = new File("C:\\Users\\Kevin\\Desktop\\test1.pdf-2-new.png");
            ImageIO.write(img, "png", f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
