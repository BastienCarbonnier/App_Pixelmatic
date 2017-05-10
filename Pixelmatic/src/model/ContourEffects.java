package model;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ContourEffects {
	public static void applyAccentuationEffect(String imagePath) throws IOException{
		
		float[ ] matrice_accentuation = { 
			    -1f, -1f, -1f, 
			    -1f, 9f, -1f, 
			    -1f, -1f, -1f 
			}; 
	    BufferedImage img = ImageIO.read(new File(imagePath));
		BufferedImageOp op = new ConvolveOp(new Kernel(3,3,matrice_accentuation)); 
		BufferedImage nouvelleImage = op.filter(img, null);
		ImageIO.write(nouvelleImage, "PNG",new File(imagePath));
	}
	
	public static void applyEstampageEffect(String imagePath) throws IOException{
		
		float[ ] matrice_estampage = { 
			    -2f, 0f, 0f, 
			    0f, 1f, 0f, 
			    0f, 0f, 2f 
			}; 
	    BufferedImage img = ImageIO.read(new File(imagePath));
		BufferedImageOp op = new ConvolveOp(new Kernel(3,3,matrice_estampage)); 
		BufferedImage nouvelleImage = op.filter(img, null);
		ImageIO.write(nouvelleImage, "PNG",new File(imagePath));
	}
}
