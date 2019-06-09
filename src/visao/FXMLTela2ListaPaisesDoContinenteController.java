package visao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    } 

}

