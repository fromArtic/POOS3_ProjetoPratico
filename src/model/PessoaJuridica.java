package model;

public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String nome, String cnpj, String razaoSocial){
        super(nome);
        this.cnpj = cnpj.substring(0, 14); //CNPJ: 14 dígitos
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getId(){
        return cnpj;
    }
    public String getRazaoSocial(){
        return razaoSocial;
    }
    
    @Override
    public String toString(){
        return "PessoaJuridica{[" + this.getCdg() + "] " + this.getNome() + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + '}';
    }
}
