package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Carro;
import model.EntradaCadastroException;

public class GerenciadorCarros{
    private static GerenciadorCarros instance;
    private List<Carro> carros;
    private static int counter = 0;
    
    public GerenciadorCarros(){
        carros = new ArrayList<>();
    }
    
    public static synchronized GerenciadorCarros getInstance(){
        if(instance == null){
            instance = new GerenciadorCarros();
        }
        return instance;
    }
    
    public boolean cadastrar(Carro carro) throws EntradaCadastroException{
        if(carro != null){
            for(Carro c : carros){
                if(c.getPlaca().equals(carro.getPlaca())){ //Verifica se já existe outro carro com a placa informada
                    EntradaCadastroException exception = new EntradaCadastroException("ERRO: A placa do veículo informado para cadastro já possui registros no sistema.");
                    throw exception;
                }
            }
            
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            if(carro.getAno() < 1934 || carro.getAno() > anoAtual){ //Verifica se o ano informado é válido
                EntradaCadastroException exception = new EntradaCadastroException("ERRO: O ano do veículo informado para cadastro é inválido.");
                throw exception;
            }
            
            carros.add(carro);
            
            counter++;
            carro.setCdg(counter);
            
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
            listarCarros();
            atualizarArquivo();
            
            return true;
        }
        return false;
    }
    
    public void listarCarros(){
        for(Carro carro : carros){
            System.out.println(carro.toString());
        }
    }
    
    public Boolean validarCarro(Carro c){
        for(Carro carro : carros){
            if(carro == c){
                return true;
            }
        }
        return false;
    }
    public Carro consultarCarro(String marca){
        for(Carro c : carros){
                if(c.getMarca().equals(marca) || c.isDisponibilidade()){ 
                    return c;
                }
            }
        return null;
    }

    public void atualizarArquivo(){
        try(PrintWriter p = new PrintWriter(new FileOutputStream("/Downloads/ArquivoCarros.txt", false))){
            for(Carro carro : carros){
                p.println(carro.toString());
            }  
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
     }
}
