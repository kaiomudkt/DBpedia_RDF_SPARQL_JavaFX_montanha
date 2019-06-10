/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kaio
 */
public class ModeloMontanha {
    private String nome;
    private String areaLocalizacao;
    private String anoSubida;
    private String lowestMountain;
    private double elevacao;
    private String link;

    public ModeloMontanha(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    public ModeloMontanha(String nome, double elevacao, String link) {
        this.nome = nome;
        this.elevacao = elevacao;
        this.link = link;
    }

    public ModeloMontanha(String nome, String areaLocalizacao, String anoSubida, String lowestMountain, double elevacao, String link) {
        this.nome = nome;
        this.areaLocalizacao = areaLocalizacao;
        this.anoSubida = anoSubida;
        this.lowestMountain = lowestMountain;
        this.elevacao = elevacao;
        this.link = link;
    }
    



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaLocalizacao() {
        return areaLocalizacao;
    }

    public void setAreaLocalizacao(String areaLocalizacao) {
        this.areaLocalizacao = areaLocalizacao;
    }

    public String getAnoSubida() {
        return anoSubida;
    }

    public void setAnoSubida(String anoSubida) {
        this.anoSubida = anoSubida;
    }

    public String getLowestMountain() {
        return lowestMountain;
    }

    public void setLowestMountain(String lowestMountain) {
        this.lowestMountain = lowestMountain;
    }

    public double getElevacao() {
        return elevacao;
    }

    public void setElevacao(double elevacao) {
        this.elevacao = elevacao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    
    
}
