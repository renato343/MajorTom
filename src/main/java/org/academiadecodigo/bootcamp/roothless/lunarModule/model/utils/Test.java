package org.academiadecodigo.bootcamp.roothless.lunarModule.model.utils;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.academiadecodigo.bootcamp.roothless.Navigation;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;

import java.util.Random;

/**
 * Created by codecadet on 31/03/2017.
 */
public class Test extends Application {
    private DynSpaceShip dynSpaceShip = new DynSpaceShip();
    private double xPosition;
    private double yPosition;


    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);
        navigation.loadScreen("Landingpage2");

      //  Parent root = FXMLLoader.load(getClass().getResource("/view/Untitled.fxml"));



/*        System.out.println("----------------------------------------");

        GameLoop gameLoop = new GameLoop();
        Service service = new Service();
        service.setDynSpaceShip(dynSpaceShip);
        dynSpaceShip.start(gameLoop);
        gameLoop.setDynSpaceShip(dynSpaceShip);*/

       /* LunarModule lunarModule = new LunarModule("localhost", 8080,service);
        lunarModule.start();*/

      /*  service.thrustUp(200);*/

      /*  Image image = new Image("LuaMax.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        imageView.setFitWidth(1000);
        imageView.setPreserveRatio(true);
        imageView.setCache(true);

       Pane pane = new Pane();
        Scene scene = new Scene(root, 1024, 728);
       pane.getChildren().add(imageView);

        primaryStage.setTitle("Major Tom");
        primaryStage.setWidth(900);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();

        primaryStage.show();
        moveView(imageView);*/


    }
    public void moveView(ImageView imageView) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ev -> {
            System.out.println("atualizando");

            System.out.println("X POSITION AT MAIN" + dynSpaceShip.getxPosition());
            System.out.println("Y POSITION AT MAIN" + dynSpaceShip.getyPosition());

            imageView.setViewport(new Rectangle2D(2100 + dynSpaceShip.getxPosition() / 10, 1700 + dynSpaceShip.getyPosition() / 10, 900, 400));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }





    private int random(int i) {
        return new Random().nextInt((30 - 10) + 10);
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }
}
