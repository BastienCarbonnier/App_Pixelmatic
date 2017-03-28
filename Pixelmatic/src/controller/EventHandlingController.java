package controller;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class EventHandlingController {
		
	
	@FXML 
	private javafx.scene.control.Button closeButton;
	
    private void initialize() {
		// Handle Button event.
    }
    @FXML
	private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        System.out.println("Button Action\n");
    }
    

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
