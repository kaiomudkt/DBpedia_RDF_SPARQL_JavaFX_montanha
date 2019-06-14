package controle;

import dao.ObjetoDeAcessoAosDados;
import java.util.ArrayList;
import modelo.ModeloMontanha;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.query.BindingSet;

public class ControleTela5 {
    ObjetoDeAcessoAosDados dao = new ObjetoDeAcessoAosDados();
    
    
    public ArrayList<ModeloMontanha> listaTodasMontanhasDoMundo(){
        ArrayList<ModeloMontanha> lista = new ArrayList<>();
        for (BindingSet bs : dao.consultaListaMontanhasDoMundo()){
            String nomeMontanha = ((IRI) bs.getValue("Montanha")).getLocalName();//retorna a Area_Localizada
            String areaLocalizacao = ((IRI) bs.getValue("Area_Localizada")).getLocalName();//retorna o nome
            double elevacao = ((Literal) bs.getValue("Elevacao")).doubleValue();
            String linkMontanha = bs.getValue("Montanha").stringValue();//retorna o link da montanha
            //System.out.println("link: "+linkMontanha);
            try {
                lista.add(new ModeloMontanha(nomeMontanha, areaLocalizacao, elevacao, linkMontanha));
            } catch (Exception e) {
                System.out.println("Deu errado na inserção da lista");
            }
        }
        return lista;
    }
}
