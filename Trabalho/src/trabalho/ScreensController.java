/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Carolini
 */
class ScreensController  extends StackPane{
    
    private HashMap<String, Node> screens = new HashMap();
    
    public ScreensController(){
        super();
    }
    
    public void addScreen (String nome, Node screen){
        screens.put(nome, screen);
    }
    
    public Node getScreen(String nome){
        return screens.get(nome);
    }
    
    public boolean loadScreen(String nome, String resource){
        try{
            FXMLLoader myloader =  new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myloader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myloader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(nome, loadScreen);
            return true;
        }catch(Exception e){
            System.out.println("testeErro");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean setScreen(final String nome){
         if(screens.get(nome) != null){
            final DoubleProperty opacity = opacityProperty();
            
            if(!getChildren().isEmpty()){
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                        
                            public void handle(ActionEvent t){
                                getChildren().remove(0);
                                getChildren().add(0, screens.get(nome));
                                Timeline fadeIn = new Timeline(
                                       new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                       new KeyFrame(new Duration (800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                            
                        }, new KeyValue(opacity,0.0)));
                        fade.play();
                
            }else{
                setOpacity(0.0);
                getChildren().add(screens.get(nome));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
         }else{
             System.out.println("");
             return false;
         }   
    
    }
    
    
    public boolean unloadScreen (String nome){
    
        if(screens.remove(nome) == null){
            System.out.println("");
            return false;
        }else{
            return true;
        }
    }
    
    
}
