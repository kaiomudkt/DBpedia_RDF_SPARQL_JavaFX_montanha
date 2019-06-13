package visao;

//import com.sun.javaws.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.ModeloPais;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controle.Auxiliar;
import controle.ControleTela2;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import sun.applet.Main;

public class FXMLTela2ListaPaisesDoContinenteController implements Initializable {

    @FXML
    private TableColumn<ModeloPais, String> colunaNomePais;
    @FXML
    private TableColumn<ModeloPais, String> colunaLink;
    @FXML
    private Button buttonVoltaPraTela1;
    @FXML
    private TableColumn<ModeloPais, String> colunaQTDMontanhas;
    @FXML
    private TableView<ModeloPais> tabelaPaises;
    @FXML
    private Button buttonBuscarMontanhasDestePais;
    @FXML
    private Label labelContinenteSelecionado;

    private ArrayList<ModeloPais> paises;
    private ObservableList<ModeloPais> obsTableList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelContinenteSelecionado.setText(Auxiliar.continenteSelecionado);
        System.out.println("Tela2, continente a ser consultado: " + Auxiliar.continenteSelecionado);
        paises = new ControleTela2().listaTodosPaisesDoContinente(Auxiliar.continenteSelecionado);
        //chama metodo que inicializar toda a tabela
        inicializarTabela();
    }

    /**
     * Este método acionado pelo evento do clique do botão, pega a linha da
     * tabela que esta selecionado, ou seja, qual país, e o passa como parametro
     * para o metodo que busca no DBpedia.
     *
     * Este método ainda, manda inicializar a proxima tela3, e manda fechar essa
     * atual tela2.
     *
     * @param event
     */
    @FXML
    void buttonBuscaMontanhasDestePais(ActionEvent event) {
        try {
            //pega linha da tabela selecionado
            ModeloPais pais = tabelaPaises.getSelectionModel().getSelectedItem();
            Auxiliar.pais = pais;
            System.out.println("Tela 2 Auxilar.auxilar: linha selecionada " + Auxiliar.pais.getNome());
            //

            //TODO
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
            //e fecha essa atual tela2
            buttonBuscarMontanhasDestePais.getScene().getWindow().hide();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Selecione um país!");
            //alert.setContentText("I have a great message for you!");
            alert.showAndWait();

        }

    }

    public void inicializarTabela() {
        colunaNomePais.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaQTDMontanhas.setCellValueFactory(new PropertyValueFactory<>("qtdMontanhas"));
        colunaLink.setCellValueFactory(new PropertyValueFactory<>("link"));
        obsTableList = FXCollections.observableArrayList(paises);
        tabelaPaises.setItems(obsTableList);
    }

    @FXML
    void buttonVoltaPraTela1(ActionEvent event) {
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
        buttonVoltaPraTela1.getScene().getWindow().hide();
    }
}
