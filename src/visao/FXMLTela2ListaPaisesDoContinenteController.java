package visao;

import com.sun.javaws.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.ModeloPais;
import controle.ControleTela3;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLTela2ListaPaisesDoContinenteController implements Initializable {

    @FXML
    private TableColumn<?, ?> colunaNomePais;

    @FXML
    private TableColumn<?, ?> colunaQTDMontanhas;

    @FXML
    private TableView<?> tabelaPaises;

    @FXML
    private Button buttonBuscarMontanhasDestePais;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //chama metodo que preenche a tabela

//        for (Object lista : new ControleTela3().buscaMontanhasDestePais("japan")) {
//            System.out.println(lista);
//        }
    }

    @FXML
    void buttonBuscaMontanhasDestePais(ActionEvent event) {

        try {
            //pega linha da tabela selecionado
            ModeloPais pais = (ModeloPais) tabelaPaises.getSelectionModel().getSelectedItem();
            //chama a proxima tela dandos os parametros que ela precisa
            //new ControleTela3().criaChamaTela4(pais.getNome());
            new ControleTela3().buscaMontanhasDestePais("japan");
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
            System.out.println("Não foi selecionado uma linha da tabela (tela2)");
        }

    }

}
