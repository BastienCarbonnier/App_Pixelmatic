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
		
		float[ ] matrice_gaussian = { 
			    1/10f, 1/10f, 1/10f, 
			    1/10f, 1/10f, 1/10f, 
			    1/10f, 1/10f, 1/10f,  
			}; 
		
	    BufferedImage img = ImageIO.read(new File(imagePath));
		BufferedImageOp op = new ConvolveOp(new Kernel(3,3,matrice_gaussian)); 
		BufferedImage nouvelleImage = op.filter(img, null);
		ImageIO.write(nouvelleImage, "PNG",new File(imagePath));
	}
	
	public static void applyBlurEffect(String imagePath) throws IOException{
		
		float[ ] matrice_blur = { 
			    -1f, -1f, -1f, 
			    -1f, 8f, -1f, 
			    -1f, -1f, -1f 
			}; 
		BufferedImage img = ImageIO.read(new File(imagePath));
		BufferedImageOp op = new ConvolveOp(new Kernel(3,3,matrice_blur)); 
		BufferedImage nouvelleImage = op.filter(img, null);
		ImageIO.write(nouvelleImage, "PNG",new File(imagePath));
		
	}
}
