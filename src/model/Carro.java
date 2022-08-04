package model;

public class Carro{
    private int cdg;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int qtdPortas;
    private boolean arCond;
    private double diaria;
    private boolean disponibilidade;

    public Carro(String marca, String modelo, int ano, String placa, int qtdPortas, boolean arCond, double diaria){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.qtdPortas = qtdPortas;
        this.arCond = arCond;
        this.diaria = diaria;
        this.disponibilidade = true;
    }

    public int getCdg(){
        return cdg;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public int getAno(){
        return ano;
    }
    public String getPlaca(){
        return placa;
    }
    public int getQtdPortas(){
        return qtdPortas;
    }
    public boolean isArCond(){
        return arCond;
    }
    public double getDiaria(){
        return diaria;
    }
    public boolean isDisponibilidade(){
        return disponibilidade;
    }
    public void setCdg(int cdg){
        this.cdg = cdg;
    }
    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }
    
    @Override
    public String toString(){
        return "Carro{[" + cdg + "] marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa + ", qtdPortas=" + qtdPortas 
                + ", arCond=" + arCond + ", diaria=" + diaria + ", disponibilidade=" + disponibilidade + '}';
    }
}
