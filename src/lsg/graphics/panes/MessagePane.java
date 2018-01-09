package lsg.graphics.panes;

import javafx.scene.layout.VBox;
import lsg.graphics.widgets.texts.GameLabel;

/**
 * Created by sclerbou on 09/01/18.
 */
public class MessagePane extends VBox{

    private GameLabel game;

    public void showMessage(String msg){

        game = new GameLabel(msg);
        this.getChildren().addAll(game);
    }

}
