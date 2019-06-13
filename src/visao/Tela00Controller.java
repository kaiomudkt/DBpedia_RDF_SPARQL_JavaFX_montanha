package visao;

import controle.ControleTela5;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.ModeloMontanha;
import sun.applet.Main;

public class Tela00Controller implements Initializable {

    @FXML
    private Button buttonTodasMontanhas;

    @FXML
    private Button buttonDevioPadrao;

    @FXML
    void buttonTodasMontanhas(ActionEvent event) {
//chama a quinta tela
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLTela5ListaMontanhasDoMundo.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        buttonDevioPadrao.getScene().getWindow().hide();
    }

    @FXML
    void buttonDevioPadrao(ActionEvent event) {
        //chama a primeira tela
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLTela1Continentes.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        buttonDevioPadrao.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
