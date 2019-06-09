package visao;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
       //fecha essa tela1 atual
        //chama a segunda tela2
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLTela2ListaPaisesDoContinente.fxml"));

    }
    
}
