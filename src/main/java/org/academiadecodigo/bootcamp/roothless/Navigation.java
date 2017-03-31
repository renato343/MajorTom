package org.academiadecodigo.bootcamp.roothless;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by codecadet on 08/03/2017.
 */
public final class Navigation {

    private final int MIN_WIDTH = 1024; // window width
    private final int MIN_HEIGHT = 768; // window height
    private LinkedList<Scene> scenes = new LinkedList<Scene>(); // Navigation History
    private Map<String, Initializable> controllers;
    private Stage stage;
    private static Navigation instance = null;
    private final String VIEW_PATH = "/view";

    private Navigation() {
        controllers = new HashMap<String, Initializable>();
    }

    public static synchronized Navigation getInstance() {

        if (instance == null) {
            instance = new Navigation();
        }
        return instance;
    }

    public void loadScreen(String view) {
        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));

            /*
            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {


                @Override
                public Object call(Class<?> param) {
                    return controllers.get(view) ;
                }
            });
            */

            Parent root = fxmlLoader.load();

            //Store the controller
            controllers.put(view, fxmlLoader.<Initializable>getController());


            // Create a new scene and add it to the stack
            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void back() {
        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();

        setScene(scenes.peek());
    }

    private void setScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Initializable getController(String view) {
        return controllers.get(view);
    }

    public void setControllers(Map<String, Initializable> controllers) {
        this.controllers = controllers;
    }
}


