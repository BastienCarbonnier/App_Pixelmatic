package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StructureEffects {
	public static void applyMirrorEffect(String imagePath) throws IOException{
		BufferedImage img = null;
	    File f = null;
	    //read image
	   //* 
	    f=new File(imagePath);
	    img = ImageIO.read(f);
	    BufferedImage imageReversed=ImageIO.read(f);
	    //get image width and height
	    int width = img.getWidth();
	    int height = img.getHeight();																			
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y); 
	        imageReversed.setRGB(width-x-1, y, p);
	      }	
	    }   
	    ImageIO.write(imageReversed, "PNG",new File(imagePath));
	}
	
	public static void apply180Effect(String imagePath) throws IOException{
		BufferedImage img = null;
	    File f = null;
	    //read image
	   //* 
	    f=new File(imagePath);
	    img = ImageIO.read(f);
	    BufferedImage imageReversed=ImageIO.read(f);
	    //get image width and height
	    int width = img.getWidth();
	    int height = img.getHeight();																			
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y); 
	        imageReversed.setRGB(x, height-y-1, p);
	      }	
	    }   
	    ImageIO.write(imageReversed, "PNG",new File(imagePath));
	}
		
	
	public static void test(String imagePath) throws IOException{
		BufferedImage img = null;
	    File f = null;
	    //read image
	   //* 
	    f=new File(imagePath);
	    img = ImageIO.read(f);
	    BufferedImage imageReversed=ImageIO.read(f);
	    //get image width and height
	    int width = img.getWidth();
	    int height = img.getHeight();																			
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y); 
	        imageReversed.setRGB(x, height-y-1, p);
	      }	
	    }
	   
	    ImageIO.write(imageReversed, "PNG",new File(imagePath));
	}
	
}
