package visao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FXMLTela3ListaDeMontanhasDoPaisController {

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



    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
