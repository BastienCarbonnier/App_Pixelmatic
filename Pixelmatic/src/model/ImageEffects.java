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
	
	public static void blackAndWhite(InterfaceView inter) throws IOException{
		
		 BufferedImage imagesrc = ImageIO.read(inter.getCurrentImage());
		
        //Convertion en grisé
		//.toURI().toString()
        BufferedImage imagedst = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = imagedst.getGraphics();
        g.drawImage(imagesrc, 0, 0, null);
        g.dispose();
                    //Enregistrer l'image au format PNG
        ImageIO.write(imagedst, "PNG", inter.getWorkingImage());
		 
		//Image image = SwingFXUtils.toFXImage(capture, null);
	}
}
