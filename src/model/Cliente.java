package model;

public abstract class Cliente{
    private int cdg;
    private String nome;
    
    public Cliente(String nome){
        this.nome = nome;
    }
    
    public abstract String getId(); //CPF para pessoa física, CNPJ para jurídica

    public int getCdg(){
        return cdg;
    }
    public String getNome(){
        return nome;
    }
    public void setCdg(int cdg){
        this.cdg = cdg;
    }
}
