package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lsg.graphics.widgets.texts.GameLabel;
import javafx.util.Duration;

import javafx.event.EventHandler;




/**
 * Created by sclerbou on 09/01/18.
 */
public class CreationPane extends VBox{

    private TextField nameField;
    private GameLabel game;
    private static final Duration ANIMATION_DURATION = Duration.millis(1500);

    public TextField getNameField(){

        return this.nameField;

    }

    public CreationPane(){

        super();
        game = new GameLabel("Player Name");
        nameField = new TextField();
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(game);
        this.getChildren().addAll(nameField);
        nameField.setMaxWidth(300);


    }

    public void fadeIn(EventHandler<ActionEvent> finishedHandler){

        FadeTransition ft = new FadeTransition(ANIMATION_DURATION, this);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1); // nombre de répétitions de l'effet.
        ft.play();

    }

}
