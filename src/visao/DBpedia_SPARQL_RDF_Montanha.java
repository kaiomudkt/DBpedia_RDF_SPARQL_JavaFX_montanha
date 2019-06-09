package visao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controle.ControleTela3;
import java.util.ArrayList;
import java.util.LinkedList;

public class DBpedia_SPARQL_RDF_Montanha extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTela1Continentes.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<modelo.ModeloMontanha> listaMont = (new ControleTela3().buscaMontanhasDestePais("japan")) ;
        for(modelo.ModeloMontanha mont : listaMont){
            System.out.println(mont.getNome());
        }
        launch(args);
    }
    
}
