/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.LinkedList;
import modelo.ModeloMontanha;
import dao.ObjetoDeAcessoAosDados;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.query.BindingSet;

/**
 *
 * @author kaio
 */
public class ControleTela3 {
        private ObjetoDeAcessoAosDados dao;
    /**
     * Recebe a String "pais" e pesquisa todas as montanhas desse pais
     * @param pais
     * @return uma linkedList de montanhas
     * 
     * recebe uma lista do tipo (List<BindingSet>)
     * e transforma em uma (linkedList)
     */
    public LinkedList<ModeloMontanha> buscaMontanhasDestePais(String pais){
        LinkedList<ModeloMontanha> lista = null;
        for (BindingSet bs : dao.buscaMontanhasDestePais(pais)) {
        System.out.println("CHEGOU AQUIIIIIII");
            String nomeMontanha = ((IRI) bs.getValue("Montanha")).getLocalName();
            double elevacao = ((Literal) bs.getValue("Elevacao")).doubleValue();
            lista.add(new ModeloMontanha(nomeMontanha, elevacao));
        }
        for (ModeloMontanha montanha : lista) {
            System.out.println(montanha.getNome());
        }
        return lista;
    }
}
