package com.helloworld;

import com.gluonhq.charm.down.Platform;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Inside init() method! Perform necessary initializations here.");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello World on "+Platform.getCurrent().name());
        label.setAlignment(Pos.CENTER);
            Scene scene = new Scene(label);

        primaryStage.setTitle("Hello World App");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(HelloWorld.class.getResourceAsStream("/icon.png")));
        setScreenSize(primaryStage);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Inside stop() method! Destroy resources. Perform Cleanup.");
    }
    
    void setScreenSize(Stage primaryStage){
        if(Platform.isAndroid() || Platform.isIOS()){
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setX(primaryScreenBounds.getMinX());
            primaryStage.setY(primaryScreenBounds.getMinY());
            primaryStage.setWidth(primaryScreenBounds.getWidth());
            primaryStage.setHeight(primaryScreenBounds.getHeight());
        }
        else{
            primaryStage.setWidth(320);
            primaryStage.setHeight(570);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
