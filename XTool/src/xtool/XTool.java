/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xtool;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
/**
 *
 * @author funkoigame
 */
public class XTool extends Application {
    
 @Override
  public void start(final Stage stage) {
 
      TextField addressBar = new TextField();
      addressBar.setText("https://eclipse.org");
      Button goButton = new Button("Go!");
      Label stateLabel = new Label();
 
      stateLabel.setTextFill(Color.RED);
      ProgressBar progressBar = new ProgressBar();
 
      final WebView browser = new WebView();
      final WebEngine webEngine = browser.getEngine();
      GoogleReg googleReg=new GoogleReg(webEngine);
      // Worker làm nhiệm vụ tải trang web
      Worker<Void> worker = webEngine.getLoadWorker();
 
     
        // Lắng nghe các trạng thái tải trang web.
      worker.stateProperty().addListener(new ChangeListener<State>() {
 
          @Override
          public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
              stateLabel.setText("Loading state: " + newValue.toString());
              if (newValue == Worker.State.SUCCEEDED) {
                      stage.setTitle(webEngine.getLocation());
                      stateLabel.setText("Finish");
                      googleReg.createUser();
                      googleReg.setAllValue();
                    //  googleReg.Submit();
                      enableFirebug(webEngine);
               
              }
          }
      });
 
      // Kết nối thuộc tính progress của progressBar
      // với thuộc tính progressBar của Worker tải nội dung trang.
      progressBar.progressProperty().bind(worker.progressProperty());
 
      goButton.setOnAction(new EventHandler<ActionEvent>() {
 
          @Override
          public void handle(ActionEvent event) {
             String url = addressBar.getText();
              // Tải nội dung trang
              webEngine.load(url);
          }
      });
      //
 
      VBox root = new VBox();
      root.getChildren().addAll(addressBar, goButton, stateLabel, progressBar, browser);
 
      Scene scene = new Scene(root);
 
      stage.setTitle("JavaFX WebView (o7planning.org)");
      stage.setScene(scene);
      stage.setWidth(1000);
      stage.setHeight(500);
 
      stage.show();
  }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

  private static void enableFirebug(final WebEngine engine) {
    engine.executeScript("if (!document.getElementById('FirebugLite')){E = document['createElement' + 'NS'] && document.documentElement.namespaceURI;E = E ? document['createElement' + 'NS'](E, 'script') : document['createElement']('script');E['setAttribute']('id', 'FirebugLite');E['setAttribute']('src', 'https://getfirebug.com/' + 'firebug-lite.js' + '#startOpened');E['setAttribute']('FirebugLite', '4');(document['getElementsByTagName']('head')[0] || document['getElementsByTagName']('body')[0]).appendChild(E);E = new Image;E['setAttribute']('src', 'https://getfirebug.com/' + '#startOpened');}"); 
  }
}
