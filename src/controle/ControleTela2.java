package controle;

import java.util.ArrayList;
import dao.ObjetoDeAcessoAosDados;
import org.eclipse.rdf4j.query.BindingSet;
import modelo.ModeloPais;
import org.eclipse.rdf4j.model.IRI;

public class ControleTela2 {
    
    
    /**
     * Recebe a String "continente" e pesquisa todos os paises
     *
     * @param continente
     * @return uma linkedList de paises
     *
     * recebe uma lista do tipo (List<BindingSet>) e transforma em uma
     * (linkedList)
     */
    public ArrayList<ModeloPais> listaTodosPaisesDoContinente(String continente) {
        ObjetoDeAcessoAosDados dao = new ObjetoDeAcessoAosDados();
        ArrayList<ModeloPais> lista = new ArrayList<>();

        for (BindingSet bs : dao.listaTodosPaisesDoContinente(continente)){
            String nomePais = ((IRI) bs.getValue("Pais")).getLocalName();//retorna a Area_Localizada
            String link = bs.getValue("Pais").stringValue();//retorna a Area_Localizada
            //System.out.println("Link do pais: "+link);
            int qtdMontanhas = 0;
            try {
                lista.add(new ModeloPais(nomePais, qtdMontanhas, continente, link));
            } catch (Exception e) {
                System.out.println("Deu errado na inserção da lista");
            }
        
        }
        return lista;
        
    }

    

}
