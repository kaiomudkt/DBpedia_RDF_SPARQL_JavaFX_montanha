/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author kaio
 */
public class ModeloPais {
    private String nome;
    private int qtdMontanhas;
    private String continente;
    private ArrayList listaMontanhas;
    private String link;

    public ModeloPais(String nome, int qtdMontanhas, String continente, String link) {
        this.nome = nome;
        this.qtdMontanhas = qtdMontanhas;
        this.continente = continente;
        //this.listaMontanhas = listaMontanhas;
        this.link = link;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdMontanhas() {
        return qtdMontanhas;
    }

    public void setQtdMontanhas(int qtdMontanhas) {
        this.qtdMontanhas = qtdMontanhas;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public ArrayList getListaMontanhas() {
        return listaMontanhas;
    }

    public void setListaMontanhas(ArrayList listaMontanhas) {
        this.listaMontanhas = listaMontanhas;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
