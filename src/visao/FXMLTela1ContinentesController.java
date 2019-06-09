package visao;

import com.sun.javaws.Main;
import java.io.IOException;
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

public class FXMLTela1ContinentesController {

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

    public static RadioButton paisSelecionado;
    
        @FXML
    void pegarPaisSelecionado() throws IOException {//tirei (ActionEvent event)
        //passa qual pais foi chamado
        //inicia a variavel static (paisSelecionado)
        paisSelecionado = (RadioButton) grupoRadioContinentes.getSelectedToggle();//pega o radioButton selecionado
        System.out.println(paisSelecionado.getText());

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
    
}
