package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.WorkArea;
import javafx.scene.image.ImageView;
import view.InterfaceView;

public class BlackAndWhiteEffect{

	public static void applyEffect(String imagePath) throws IOException{
		
		BufferedImage imagesrc = ImageIO.read(new File(imagePath));
        BufferedImage imagedst = new BufferedImage(imagesrc.getWidth(),imagesrc.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = imagedst.getGraphics();
        g.drawImage(imagesrc, 0, 0, null);
        g.dispose();
        
        ImageIO.write(imagedst, "PNG", new File(imagePath));
		
	}
}
