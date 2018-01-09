package lsg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;


/**
 * Created by sclerbou on 08/01/18.
 */
public class LearningSoulsGameApplication extends Application {

    private javafx.scene.Scene scene;
    private javafx.scene.layout.AnchorPane root;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    private String heroName;
    private AnimationPane animationPane;

    private void BuildUI(){

        gameTitle = new TitlePane(scene, "Learning Souls Game");
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
        root.getChildren().addAll(gameTitle);
        root.setLeftAnchor(gameTitle,0.0);
        root.setRightAnchor(gameTitle, 0.0);
        root.setTopAnchor(gameTitle, 0.0);

        creationPane = new CreationPane();
        creationPane.setOpacity(0);
        root.getChildren().addAll(creationPane);
        root.setLeftAnchor(creationPane,0.0);
        root.setRightAnchor(creationPane, 0.0);
        root.setTopAnchor(creationPane, 0.0);
        root.setBottomAnchor(creationPane, 0.0);

        animationPane = new AnimationPane(root);

    }

    private void play(){

        root.getChildren().addAll(animationPane);
        animationPane.startDemo();

    }

    private void addListeners(){

        creationPane.getNameField().setOnAction((event -> {

            heroName = creationPane.getNameField().getText();
            System.out.println("Nom du héro : " + heroName);
            if(heroName != " "){

                root.getChildren().removeAll(creationPane);
                gameTitle.zoomOut(null);
                play();

            }

        }));

    }

    public void startGame(){

        gameTitle.zoomIn(event -> {

            creationPane.fadeIn(event1 -> {
                ImageFactory.preloadAll(() -> {
                    System.out.println("Pré-chargement des images terminé");
                });
            });

        });
        System.out.println("Animation lancée !");

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Learning Souls Game");

        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        BuildUI();
        addListeners();
        primaryStage.show();
        startGame();

    }
}
