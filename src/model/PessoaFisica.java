package model;

public class PessoaFisica extends Cliente{
    private String cpf;
    
    public PessoaFisica(String nome, String cpf){
        super(nome);
        this.cpf = cpf.substring(0, 11); //CPF: 11 dígitos
    }

    @Override
    public String getId(){
        return cpf;
    }

    @Override
    public String toString(){
        return "PessoaFisica{[" + this.getCdg() + "] " + this.getNome() + ", cpf=" + cpf + '}';
    }
}
