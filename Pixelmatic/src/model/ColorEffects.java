package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import view.InterfaceView;


public class ColorEffects{

	public static void applyBlackAndWhiteEffect(String imagePath) throws IOException{
		//System.out.println(InterfaceView.class.getResource(imagePath).getPath());
		//BufferedImage imagesrc = ImageIO.read(new File(InterfaceView.class.getResource(imagePath).getPath()));
		BufferedImage imagesrc = ImageIO.read(new File(imagePath));
        BufferedImage imagedst = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = imagedst.getGraphics();
        g.drawImage(imagesrc, 0, 0, null);
        g.dispose();
        ImageIO.write(imagedst, "PNG", new File(imagePath));
	}
	
	public static void applySepiaEffect(String imagePath) throws IOException{
		BufferedImage img = null;
	    File f = null;

	    //read image
	    f = new File(imagePath);
	    img = ImageIO.read(f);
	    

	    //get width and height of the image
	    int width = img.getWidth();
	    int height = img.getHeight();

	    //convert to sepia
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y);

	        int a = (p>>24)&0xff;
	        int r = (p>>16)&0xff;
	        int g = (p>>8)&0xff;
	        int b = p&0xff;

	        //calculate tr, tg, tb
	        int tr = (int)(0.393*r + 0.769*g + 0.189*b);
	        int tg = (int)(0.349*r + 0.686*g + 0.168*b);
	        int tb = (int)(0.272*r + 0.534*g + 0.131*b);

	        //check condition
	        if(tr > 255) r = 255;
	        else r = tr;
	        if(tg > 255) g = 255;
	        else g = tg;
	        
	        if(tb > 255) b = 255;
	        else b = tb;
	        //set new RGB value
	        p = (a<<24) | (r<<16) | (g<<8) | b;
	        img.setRGB(x, y, p);
	      }
	    }
	    //write image
	    f = new File(imagePath);
	    ImageIO.write(img, "PNG", f); 
	}
	public static void applyNegativeEffect(String imagePath) throws IOException{
		BufferedImage img = null;
	    File f = null;
	    //read image
	    
	    f = new File(imagePath);
	    img = ImageIO.read(f);
	    
	    //get image width and height
	    int width = img.getWidth();
	    int height = img.getHeight();
	    //convert to negative
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y);
	        int a = (p>>24)&0xff;
	        int r = (p>>16)&0xff;
	        int g = (p>>8)&0xff;
	        int b = p&0xff;
	        //subtract RGB from 255
	        r = 255 - r;
	        g = 255 - g;
	        b = 255 - b;
	        //set new RGB value
	        p = (a<<24) | (r<<16) | (g<<8) | b;
	        img.setRGB(x, y, p);
	      }
	    }
	    //write image
	    f = new File(imagePath);
	    ImageIO.write(img, "PNG", f);
	   
	}
	public static void applyPosterizeEffect(String imagePath) throws IOException{
		BufferedImage img = null;
	    File f = null;
	    //read image
	    
	    f = new File(imagePath);
	    img = ImageIO.read(f);
	    
	    //get image width and height
	    int width = img.getWidth();
	    int height = img.getHeight();
	    //convert to negative
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y);
	        int a = (p>>24)&0XFF; 
	        int r = (p>>16)&0xFF;
	        int g = (p>>8)&0xFF;
	        int b = (p&0xff);
	       
	        //subtract RGB from 255
	        r=roundingpx(r);
	        g=roundingpx(g);
	        b=roundingpx(b);
	        //set new RGB value
	        p = (a<<24) | (r<<16) | (g<<8) | b;
	        img.setRGB(x, y, p);
	      }
	    }
	    //write image
	    f = new File(imagePath);
	    ImageIO.write(img, "PNG", f);
		
	}
	
	public static void test(String imagePath) throws IOException{
	}
	
	public static int roundingpx (int px) {
		if (px<62) {
			px=31;}
		else if (px<124) {
			px=93;}
		else if (px<186) {
			px=155;}
		else {
			px=221;
		}
		return px;
	}
		
	
}
