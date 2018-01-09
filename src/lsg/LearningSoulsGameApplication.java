package lsg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import lsg.characters.Hero;
import lsg.characters.Zombie;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.HUDPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.characters.renderers.HeroRenderer;
import lsg.graphics.widgets.characters.renderers.ZombieRenderer;
import lsg.graphics.widgets.texts.GameLabel;
import lsg.weapons.Hand;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;


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
    private Hero hero;
    private HeroRenderer heroRenderer;
    private Zombie zombie;
    private ZombieRenderer zombieRenderer;
    private HUDPane hudPane;

    public void createHero(){

        hero = new Hero();
        hero.setWeapon(new Sword());
        heroRenderer = animationPane.createHeroRenderer();
        heroRenderer.goTo(animationPane.getPrefWidth()*0.5 - heroRenderer.getFitWidth()*0.65, null);

    }

    public void createMonster(EventHandler<ActionEvent> finishedHandler){

        zombie = new Zombie();
        zombie.setWeapon(new Hand());
        zombieRenderer = animationPane.createZombieRenderer();
        zombieRenderer.goTo(animationPane.getPrefWidth()*0.5 - zombieRenderer.getBoundsInLocal().getWidth() * 0.15, finishedHandler);

    }

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
        hudPane = new HUDPane();
        root.setLeftAnchor(hudPane,0.0);
        root.setRightAnchor(hudPane, 0.0);
        root.setTopAnchor(hudPane, 0.0);
        root.setBottomAnchor(hudPane, 0.0);

    }

    private void play(){

        root.getChildren().addAll(animationPane);
        root.getChildren().addAll(hudPane);
        createHero();
        createMonster((event) -> {hudPane.getMessagePane().showMessage("FIGHT !");});

    }

    private void addListeners(){

        creationPane.getNameField().setOnAction((event -> {

            heroName = creationPane.getNameField().getText();
            System.out.println("Nom du héro : " + heroName);
            if(!heroName.equals("")){

                root.getChildren().removeAll(creationPane);
                gameTitle.zoomOut((event1 -> {

                    play();

                }));

            }

        }));

    }

    public void startGame(){

        gameTitle.zoomIn((event) -> {

            creationPane.fadeIn((event1) -> {
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
