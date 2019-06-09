package controle;

import dao.ObjetoDeAcessoAosDados;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.rdf4j.query.BindingSet;

public class ControleTela2 {
    private ObjetoDeAcessoAosDados dao;
    
    
    public void listaPaises(String continente){
        //add quantidades de montanhas por pais
    }
    /**
     * Recebe a String "pais" e pesquisa todas as montanhas desse pais
     * @param pais
     * @return uma linkedList de montanhas
     */
    public LinkedList buscaMontanhasDestePais(String pais){
        LinkedList lista = null;
        for (BindingSet bs : dao.buscaMontanhasDestePais(pais)) {
            lista.add(bs);
        }
        return lista;
    }
    
    
}
