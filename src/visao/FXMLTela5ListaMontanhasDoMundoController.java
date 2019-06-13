package visao;

//import com.sun.javaws.Main;
import controle.Auxiliar;
import controle.ControleTela5;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.ModeloMontanha;
import sun.applet.Main;

public class FXMLTela5ListaMontanhasDoMundoController implements Initializable {

    @FXML
    private TableColumn<ModeloMontanha, String> columnLocalizacao;
    @FXML
    private Button buttonVoltar;
    @FXML
    private Label qtdMontanhas;
    @FXML
    private TableView<ModeloMontanha> tabelaMontanhas;
    @FXML
    private TableColumn<ModeloMontanha, String> columnMontanha;
    private ObservableList<ModeloMontanha> obsTableList;
    @FXML
    private TableColumn<ModeloMontanha, String> columnElevacao;
    private ArrayList<ModeloMontanha> listaMontanhasMundo;
    @FXML
    void buttonVoltar(ActionEvent event) {
//chama a zero tela
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Tela00.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        buttonVoltar.getScene().getWindow().hide();
    }

    public void inicializarTabela() {
        columnMontanha.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnElevacao.setCellValueFactory(new PropertyValueFactory<>("elevacao"));
        columnLocalizacao.setCellValueFactory(new PropertyValueFactory<>("areaLocalizacao"));
        obsTableList = FXCollections.observableArrayList(listaMontanhasMundo);
        tabelaMontanhas.setItems(obsTableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Auxiliar.listaMontanhasDoMundo == null) {
            this.listaMontanhasMundo = new ControleTela5().listaTodasMontanhasDoMundo();
            Auxiliar.listaMontanhasDoMundo = this.listaMontanhasMundo;
        } else {
            this.listaMontanhasMundo = Auxiliar.listaMontanhasDoMundo;
        }
        qtdMontanhas.setText(Integer.toString(this.listaMontanhasMundo.size()));
        inicializarTabela();
    }

}
