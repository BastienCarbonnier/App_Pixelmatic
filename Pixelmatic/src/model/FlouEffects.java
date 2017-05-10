package model;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;

public class FlouEffects {
	public static void applyGaussianEffect(String imagePath) throws IOException{
		//ImageView image=new ImageView(new File(imagePath).toURI().toString());
		//image.setEffect(new GaussianBlur());
		float[ ] matrice_gaussian = { 
			    0.1f, 0.1f, 0.1f, 
			    0.1f, 0.2f, 0.1f, 
			    0.1f, 0.1f, 0.1f 
			}; 
		
	    BufferedImage img = ImageIO.read(new File(imagePath));
		BufferedImageOp op = new ConvolveOp(new Kernel(3,3,matrice_gaussian)); 
		BufferedImage nouvelleImage = op.filter(img, null);
		ImageIO.write(nouvelleImage, "PNG",new File(imagePath));
	}
	
	public static void applyBlurEffect(String imagePath){
		
		// cette méthode ne modifie pas l'image 
		ImageView image=new ImageView(new File(imagePath).toURI().toString());
		
		BoxBlur boxBlur = new BoxBlur();
		 boxBlur.setWidth(10);
		 boxBlur.setHeight(3);
		 boxBlur.setIterations(3);
		 
		 image.setEffect(boxBlur);
	}
}
