/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.ModeloMontanha;
import dao.ObjetoDeAcessoAosDados;
import java.util.ArrayList;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.query.BindingSet;

/**
 *
 * @author kaio
 */
public class ControleTela3 {

    private ObjetoDeAcessoAosDados dao = new ObjetoDeAcessoAosDados();

    /**
     * Recebe a String "pais" e pesquisa todas as montanhas desse pais
     *
     * @param pais
     * @return uma linkedList de montanhas
     *
     * recebe uma lista do tipo (List<BindingSet>) e transforma em uma
     * (linkedList)
     */
    public ArrayList<ModeloMontanha> ListaTodasMontanhasDeUmPais(String linkPais){
        //busca no DBpedia todas as montanhas deste país
        ArrayList<ModeloMontanha> lista = new ArrayList<>();
        for (BindingSet bs : dao.buscaMontanhasDestePais(linkPais)) {
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
