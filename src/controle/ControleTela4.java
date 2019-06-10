package controle;

import dao.ObjetoDeAcessoAosDados;
import java.util.ArrayList;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.query.BindingSet;



public class ControleTela4 {
    /**
     * método recebe a lista de elevações das montanhas de um determinado continente
     * e calcula o desvio padrão
     * 
     * @param listaElevacoes
     * @return desvioPadraoLista
     */
    public double desvioPadrao(String continente) {
        double desvioPadraoLista = 0;
        //TODO
        //calcula desvio padrao com todas as elevações desta lista
        //
        double elevacao = 0;
        ObjetoDeAcessoAosDados dao = new ObjetoDeAcessoAosDados();
        for (BindingSet bs : dao.consultaListaMontanhasDeDeterminadoContinente(continente)) {
            elevacao = ((Literal) bs.getValue("Elevacao")).doubleValue();
            System.out.println("Elevacao: " + elevacao);
            desvioPadraoLista += elevacao;//nem sei como calcula isso KKKK
        }
        return desvioPadraoLista;
    }
    
}
