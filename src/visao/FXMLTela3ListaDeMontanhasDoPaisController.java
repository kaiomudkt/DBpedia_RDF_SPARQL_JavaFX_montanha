package visao;

//import com.sun.javaws.Main;
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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.ModeloMontanha;
import controle.Auxilar;
import sun.applet.Main;

public class FXMLTela3ListaDeMontanhasDoPaisController implements Initializable {

    ControleTela3 controle;

    @FXML
    private Button buttonBuscar;

    @FXML
    private TableColumn<ModeloMontanha, String> columnLocalizacao;

    @FXML
    private TableView<ModeloMontanha> tabelaMontanhas;

    @FXML
    private TableColumn<ModeloMontanha, String> columnMontanha;

    @FXML
    private TableColumn<ModeloMontanha, String> columnElevacao;
    
    private ObservableList<ModeloMontanha> obsTableList;
    private ArrayList<ModeloMontanha> montanhas;
    
    

    /**
     * método acionado pelo o evento do clique no botão "buttonBuscar", pega a
     * linha selecionada na tabela, ou seja, o nome da montanha, e envia como
     * parâmetro do método responsaval preenchar a tela4.
     *
     * Chama a proxíma tela4, e fecha a atual tela3.
     *
     * @param event
     */
    @FXML
    void buttonTela4DesvioPadrao(ActionEvent event) {
        //pega conteudo selecionado na tabela
        try {
            ModeloMontanha montanha = (ModeloMontanha) tabelaMontanhas.getSelectionModel().getSelectedItem();
            System.out.println(montanha.getNome());
            //TODO

            //falta enviar o objeto montanha para a proxima tela saber preencher a tabela
        } catch (Exception e) {
            System.out.println("OBJETO NULO, SELECIONA ALGUM ITEM DA TABELA (tela3)");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        montanhas = new ControleTela3().ListaTodasMontanhasDeUmPais(Auxilar.auxilar);
        //chama metodo que inicializar toda a tabela
        inicializarTabela();
    }

    public void inicializarTabela() {
        columnMontanha.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnElevacao.setCellValueFactory(new PropertyValueFactory<>("elevacao"));
        columnLocalizacao.setCellValueFactory(new PropertyValueFactory<>("areaLocalizacao"));
        obsTableList = FXCollections.observableArrayList(montanhas);
        tabelaMontanhas.setItems(obsTableList);
    }

}
