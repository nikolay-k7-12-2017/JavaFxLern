import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationCom implements Initializable{
        @FXML
        private ProgressBar prBarr1;
        @FXML
        private Button button1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
        double w=1;

    public void prBarr1(ActionEvent actionEvent) {

        prBarr1.setVisible(true);
        prBarr1.setProgress(0);

        //    prBarr1.paddingProperty().unbind();


        System.out.println("button 1 klisk");
        if (prBarr1.isVisible() == true && w < 10) {
            prBarr1.setVisible(true);
        } else prBarr1.setVisible(false);
        w++;

        //  prBarr1.progressProperty().setValue(w);
        if (w >= 10) {
            w = 1;
        }
 /*       for (int i = 0; i < 100_000; i++) {
         //   Double d = Double.valueOf(i / 100_000);
      //      prBarr1.progressProperty().unbind();
            try {
                wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //prBarr1.progressProperty().unbind();
        }
           Ru thread = new Thread(new Runnable() {
            @Override
            public void run() {
                prBarr1.progressProperty();
            }
        }) ;   */
    }
}

