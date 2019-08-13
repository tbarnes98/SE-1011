package barnestr;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

/**
 * This class implements the lab5.FXML into the root scene and launches the application window.
 * @author barnestr
 * @version
 */
public class Lab5 extends Application {

    /**
     * Launches the application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the primary stage.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("lab5.fxml"));
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(new Scene(root, 700,700));
        primaryStage.show();

    }
}