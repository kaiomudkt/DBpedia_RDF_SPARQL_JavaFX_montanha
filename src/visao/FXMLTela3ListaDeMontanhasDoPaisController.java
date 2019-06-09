package visao;

import com.sun.javaws.Main;
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
import controle.ControleTela3;
import modelo.ModeloMontanha;

public class FXMLTela3ListaDeMontanhasDoPaisController {

    ControleTela3 controle;

    @FXML
    private Button buttonBuscar;

    @FXML
    private TableColumn<?, ?> columnLocalizacao;

    @FXML
    private TableView<?> tabelaMontanhas;

    @FXML
    private TableColumn<?, ?> columnMontanha;

    @FXML
    private TableColumn<?, ?> columnElevacao;
/**
 * método acionado pelo o evento do clique no botão "buttonBuscar",
 * pega o item selecionado no 
 * 
 * 
 * @param event 
 */
    @FXML
    void buttonTela4DesvioPadrao(ActionEvent event) {
        //pega conteudo selecionado na tabela
        try{
        ModeloMontanha montanha = (ModeloMontanha) tabelaMontanhas.getSelectionModel().getSelectedItem();
        System.out.println(montanha.getNome());
        }catch(Exception e){
            System.out.println("OBJETO NULO, SELECIONA ALGUM ITEM DA TABELA");
        }
        //chama a quarta tela
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLTela4DesvioPadrao.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //fecha essa tela3 atual
        buttonBuscar.getScene().getWindow().hide();
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //chama metodo que inicializar toda a tabela
    }

}
