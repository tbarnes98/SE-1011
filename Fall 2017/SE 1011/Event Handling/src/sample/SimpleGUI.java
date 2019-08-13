package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Pane root = new StackPane();
        Label label = new Label("Here is some text that can be manipulated with the button above.");
        Button clickMe = new Button("Click Me");
        clickMe.setOnAction(event -> {
            if(label.getEffect()==null) {
                label.setEffect(new BoxBlur());
            } else {
                label.setEffect(null);
            }
        });
        root.getChildren().addAll(label, clickMe);
        primaryStage.setTitle("Simple GUI");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
}
