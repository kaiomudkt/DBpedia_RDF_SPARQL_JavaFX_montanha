package visao;

//import com.sun.javaws.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import sun.applet.Main;
import controle.Auxiliar;

public class FXMLTela1ContinentesController implements Initializable {

    @FXML
    private ToggleGroup grupoRadioContinentes;

    @FXML
    private RadioButton europa;

    @FXML
    private RadioButton africa;

    @FXML
    private Button buscarContinente;

    @FXML
    private RadioButton oceania;

    @FXML
    private RadioButton asia;

    @FXML
    private RadioButton america;
        
    public static RadioButton continenteSelecionado;

    @FXML
    void pegarPaisSelecionado() throws IOException {//tirei (ActionEvent event)
        //passa qual pais foi chamado
        continenteSelecionado = (RadioButton) grupoRadioContinentes.getSelectedToggle();//pega o radioButton selecionado
        Auxiliar.continenteSelecionado = continenteSelecionado.getId();
        System.out.println("Tela 1 Auxilar.auxilar: "+Auxiliar.continenteSelecionado);

        System.out.println(continenteSelecionado.getId());

        //chama a segunda tela2
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLTela2ListaPaisesDoContinente.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //fecha essa tela1 atual
        buscarContinente.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
