package visao;

//import com.sun.javaws.Main;
import controle.ControleTela4;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import controle.Auxiliar;
import sun.applet.Main;

public class FXMLTela4DesvioPadraoController implements Initializable{

    @FXML
    private Label labelValorDesvioPadrao;

    @FXML
    private Label labelElevacaoMontEscolhido;

    @FXML
    private Label labelNomeMontanha;

    @FXML
    private Label labelNomeContinente;

    @FXML
    private Button buttonVolta;

 

    @FXML
    void buttonVoltaAcao(ActionEvent event) {
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
        //fecha essa tela4 atual
        buttonVolta.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelElevacaoMontEscolhido.setText(Double.toString(Auxiliar.montanha.getElevacao()));
        labelNomeMontanha.setText(Auxiliar.montanha.getNome());
        ControleTela4 controle = new ControleTela4();
        String desvioP = String.valueOf(controle.desvioPadrao(Auxiliar.continenteSelecionado));
        labelValorDesvioPadrao.setText(desvioP);
        //TODO
        labelNomeContinente.setText(Auxiliar.continenteSelecionado);
    }

}

