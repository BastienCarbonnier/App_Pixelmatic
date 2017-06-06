package view;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;

import controller.IOController;
import model.WorkingImage;
import javafx.application.Platform;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.IOFile;

public class MenuBarView {
	
	public static MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
	    
	    
	    Menu pixelmaticMenu = new Menu("Pixelmatic");
	    Menu fileMenu = new Menu("Fichier");
	    Menu editMenu = new Menu("Edition");
	    Menu helpMenu = new Menu("Aide");
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    MenuItem printMenuItem = new MenuItem("Print");
	    MenuItem openMenuItem = new MenuItem("Open");
	    MenuItem saveMenuItem = new MenuItem("Save");
	    MenuItem saveAsMenuItem = new MenuItem("SaveAs..");
	    MenuItem getHelpItem= new MenuItem("get help");
	    
	    
	        
	    pixelmaticMenu.getItems().addAll(exitMenuItem);
	    fileMenu.getItems().addAll(openMenuItem, saveMenuItem, saveAsMenuItem, printMenuItem);
	    helpMenu.getItems().addAll(getHelpItem);
	    
	    exitMenuItem.setOnAction(actionEvent -> IOController.exit());
	    
	    printMenuItem.setOnAction(actionEvent -> {	    
	    	IOController.print(); //appeler la fonction imprimer

	    });
	    
	    openMenuItem.setOnAction(actionEvent -> {	    
	    	
		    	FileChooser fileChooser = new FileChooser(); 
				fileChooser.setSelectedExtensionFilter(new ExtensionFilter( "*.png", "*.jpg"));
		        File file = fileChooser.showOpenDialog(null); 
		        IOController.openImage(file);
			
		});
	    getHelpItem.setOnAction(actionEvent -> {
	    	IOFile.openBrowser();

	    });
	    saveAsMenuItem.setOnAction(actionEvent -> {	    
	        try {
				IOController.saveAsImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	    
	    
	    saveMenuItem.setOnAction(actionEvent -> {	    
	        try {
				IOController.saveImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	    menuBar.getMenus().addAll(pixelmaticMenu,fileMenu,editMenu,helpMenu);
	    return menuBar;
	}
}
