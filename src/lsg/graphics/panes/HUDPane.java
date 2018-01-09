package lsg.graphics.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

/**
 * Created by sclerbou on 09/01/18.
 */
public class HUDPane extends BorderPane{

    private MessagePane messagePane;

    public MessagePane getMessagePane(){

        return this.messagePane;


    }

    public void buildCenter(){

        messagePane = new MessagePane();
        this.getChildren().addAll(messagePane);
        messagePane.setAlignment(Pos.CENTER);

    }

    public HUDPane(){

        buildCenter();

    }

}
