package barnestr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  This class is the controller for lab5.fxml
 */
public class Controller implements Initializable {

    /**
     * Declares the LifeGrid called game
     */
    LifeGrid game;

    @FXML
    private BorderPane gamePane;

    @FXML
    private HBox buttons;

    @FXML
    private Button nextButton;

    @FXML
    private Button randomizeButton;

    @FXML
    private Label aliveDeadCount;

    @FXML
    void getClicked(MouseEvent event) {
        game.setState(event);
        labelUpdater();
    }

    @FXML
    void iterate(ActionEvent event) {
        game.iterate();
        labelUpdater();
    }

    @FXML
    void randomize(ActionEvent event) {
        game.randomize();
        labelUpdater();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert gamePane != null :"fx:id=\"gamePane\" was not injected: check your FXML file 'game.fxml'.";
        game = new LifeGrid(gamePane);
    }

    /**
     * Updates the label that displays amount of dead or alive cells.
     */
    private void labelUpdater() {
        aliveDeadCount.setText("Alive: "+ game.aliveCells +" Dead: " + game.deadCells);
    }
}

