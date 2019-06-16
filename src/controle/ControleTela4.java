package controle;

import dao.ObjetoDeAcessoAosDados;
import java.util.ArrayList;
import modelo.ModeloPais;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.query.BindingSet;

public class ControleTela4 {

    /**
     * método recebe a lista de elevações das montanhas de um determinado
     * continente e calcula o desvio padrão
     *
     * @param listaElevacoes
     * @return desvioPadraoLista
     */
    public double desvioPadraoContinente(String continente) {
        double desvioPadraoLista = 0;
        double elevacao = 0;
        ArrayList<Integer> lista = new ArrayList<>();
        for (BindingSet bs : new ObjetoDeAcessoAosDados().consultaListaMontanhasDeDeterminadoContinente(continente)) {
            elevacao = ((Literal) bs.getValue("Elevacao")).doubleValue();
            lista.add((int) elevacao);
        }
        return Desvio.sd(lista);
    }

    public double desvioPadraoPais(ModeloPais pais) {
        double desvioPadraoLista = 0;
        double elevacao = 0;
        ArrayList<Integer> lista = new ArrayList<>();
        for (BindingSet bs : new ObjetoDeAcessoAosDados().consultaListaMontanhasDeDeterminadoPais(pais)) {
            elevacao = ((Literal) bs.getValue("Elevacao")).doubleValue();
            lista.add((int) elevacao);
        }
        return Desvio.sd(lista);
    }
}