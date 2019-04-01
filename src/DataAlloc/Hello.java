package DataAlloc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Hello extends Application{
	@Override
	public void start(Stage ps) {
		Button btn = new Button();
		btn.setText("Say 'Hello'");
		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello");
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
Scene scene = new Scene(root, 300, 250);
	
		ps.setTitle("Hello!");
		ps.setScene(scene);
		ps.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
