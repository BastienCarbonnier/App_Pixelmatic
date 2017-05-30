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
	public static void applyFlouIncrementalEffect(String imagePath,int strength) throws IOException{
		if (strength==0) return;	
		float matrice_size=(2+strength)*(2+strength);
		
		float[] matrice_flou=new float[(int) matrice_size];
		
		for (int i=0;i<matrice_size;i++)
			matrice_flou[i]=(float)(1/matrice_size);
		
	    BufferedImage img = ImageIO.read(new File(imagePath));
		BufferedImageOp op = new ConvolveOp(new Kernel(2+strength,2+strength,matrice_flou)); 
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
