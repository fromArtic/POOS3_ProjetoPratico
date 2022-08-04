package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.EntradaCadastroException;

public class GerenciadorClientes{
    private static GerenciadorClientes instance;
    private List<Cliente> clientes;
    private static int counter = 1;
    
    public GerenciadorClientes(){
        clientes = new ArrayList<>();
    }
    
    public static synchronized GerenciadorClientes getInstance(){
        if(instance == null){
            instance = new GerenciadorClientes();
        }
        return instance;
    }
    
    public boolean cadastrar(Cliente cliente) throws EntradaCadastroException, IOException{
        if(cliente != null){
            for(Cliente c : clientes){
                if(c.getId().equals(cliente.getId())){ //Verifica se já existe outro cliente com o ID informado
                    EntradaCadastroException exception = new EntradaCadastroException("ERRO: O ID informado para cadastro já possui registros no sistema.");
                    throw exception;
                }
            }
            
            if(cliente.getId().matches("^\\d+$") == false){ //Verifica se o String ID só possui dígitos, do início ao fim
                EntradaCadastroException exception = new EntradaCadastroException("ERRO: O ID informado para cadastro deve somente conter números.");
                throw exception;
            }
            
            clientes.add(cliente);
            
            cliente.setCdg(counter);
            counter++;
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            listarClientes();
            atualizarArquivo();
            
            return true;
        }
        return false;
    }
    
    public Cliente consultarCliente(String nome){
            for(Cliente c : clientes){
                if(c.getNome().equals(nome)){ 
                    return c;
                }
            }
        return null;
    }
    
    public void listarClientes(){
        for(Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }
    }
    
    public Boolean validarCliente(Cliente c){
        for(Cliente cliente : clientes){
            if(cliente == c){
                return true;
            }
        }
        return false;
    }
    
    public void atualizarArquivo() throws IOException{
        try(PrintWriter p = new PrintWriter(new FileOutputStream("/Downloads/ArquivoClientes.txt", false))){
            for(Cliente cliente : clientes){
                p.println(cliente.toString());
            }  
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
     }
}
