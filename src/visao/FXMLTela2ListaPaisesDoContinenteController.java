package visao;

import com.sun.javaws.Main;
import controle.ControleTela2;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FXMLTela2ListaPaisesDoContinenteController {

    @FXML
    private TableColumn<?, ?> colunaNomePais;

    @FXML
    private TableColumn<?, ?> colunaQTDMontanhas;

    @FXML
    private TableView<?> tabelaPaises;

    @FXML
    private Button buttonBuscarMontanhasDestePais;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //chama metodo que preenche a tabela

        for (Object lista : new ControleTela2().buscaMontanhasDestePais("japan")) {
            //System.out.println(lista);
        }
    }
    
    
    @FXML
    void buttonBuscaMontanhasDestePais(ActionEvent event) {

        //chama a terceira tela
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLTela3ListaDeMontanhasDoPais.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //fecha essa tela2 atual
        buttonBuscarMontanhasDestePais.getScene().getWindow().hide();
    }


    

}
