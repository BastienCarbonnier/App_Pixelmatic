package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import view.InterfaceView;

public class ImageEffects {
	
	public static String blackAndWhite(String imagePath) throws IOException{
		
		
		BufferedImage imagesrc = ImageIO.read(new File(imagePath));
        BufferedImage imagedst = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = imagedst.getGraphics();
        g.drawImage(imagesrc, 0, 0, null);
        g.dispose();
        
        String newPath=ModifyPath.addToPath(imagePath,"_bw");
        //Enregistrer l'image au format PNG
        ImageIO.write(imagedst, "PNG", new File(newPath));
		return newPath; // retourne le nouveau chemin
		// essai commit bastien
		//Image image = SwingFXUtils.toFXImage(capture, null);
	}
}
