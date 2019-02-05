/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldtimeline.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
/**
 *
 * @author Alex
 */
public class GenericTemplateController {
    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private Label bodyText, title;
    
    @FXML
    private VBox imageVBox, labelVBox;
    
    public void initialize() {
        imageVBox.setPrefWidth(450);
        scrollPane.setPrefWidth(900);
    }
    
    public void setImageWidth(int size) {
        imageVBox.setPrefWidth(size);
        scrollPane.setPrefWidth(400);
    }
    
    public void addImage(String url){
        Image image = new Image(url);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);
        imageVBox.getChildren().add(imageView);

    }

    public void addText(String text) {
        Label label = new Label(text);
        label.setStyle("    -fx-alignment:baseline-left;\n"
                + "    -fx-pref-width: 400;\n"
                + "    -fx-font: 16px normal;\n"
                + "    -fx-wrap-text: true;\n"
                + "    -fx-max-height: Infinity;");
        labelVBox.getChildren().add(label);
    }

    public void setTitle(String text) {
        title.setText(text);
    }

    public void addHeader(String text) {
        Label label = new Label(text);
        label.setStyle("    -fx-font: 20px normal;\n"
                + "    -fx-stroke: black;\n"
                + "    -fx-stroke-width: 1;\n"
                + "    -fx-text-alignment: center;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-wrap-text: true;");
        labelVBox.getChildren().add(label);
    }

}
