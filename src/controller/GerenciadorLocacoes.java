package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Carro;
import model.Cliente;
import model.DisponibilidadeDiscordanteException;
import model.ElementoInexistenteException;
import model.Locacao;

public class GerenciadorLocacoes{
    private static GerenciadorLocacoes instance;
    private List<Locacao> locacoes;
    private static int counter = 0;
    
    GerenciadorClientes gc = GerenciadorClientes.getInstance();
    GerenciadorCarros gk = GerenciadorCarros.getInstance();
    
    public GerenciadorLocacoes(){
        locacoes = new ArrayList<>();
    }
    
    public static synchronized GerenciadorLocacoes getInstance(){
        if(instance == null){
            instance = new GerenciadorLocacoes();
        }
        return instance;
    }
    
    public boolean registrarLocacao(Locacao locacao) throws ElementoInexistenteException{
        if(locacao != null){
            if(locacao.getCliente() == null){ //Invalida campo do cliente nulo
                ElementoInexistenteException exception = new ElementoInexistenteException("ERRO: A locação registrada contém um cliente não cadastrado no sistema.");
                throw exception;
            }else if(locacao.getCarro() == null){ //Invalida campo do carro nulo
                ElementoInexistenteException exception = new ElementoInexistenteException("ERRO: A locação registrada contém um carro não cadastrado no sistema.");
                throw exception;
            }
            
            if(gc.validarCliente(locacao.getCliente()) == true){ //Verifica se o cliente está cadastrado
                if(gk.validarCarro(locacao.getCarro()) == true){ //Verifica se o carro está cadastrado
                    locacoes.add(locacao);
            
                    counter++;
                    locacao.setNumero(counter);

                    locacao.locarCarro();
                    
                    atualizarArquivo();
                    gk.atualizarArquivo();
                    JOptionPane.showMessageDialog(null, "Locação registrada com sucesso!");
                    listarLocacoes();
                    return true;
                }else{
                    ElementoInexistenteException exception = new ElementoInexistenteException("ERRO: A locação registrada contém um carro não cadastrado no sistema.");
                    throw exception;
                }
            }else{
                ElementoInexistenteException exception = new ElementoInexistenteException("ERRO: A locação registrada contém um cliente não cadastrado no sistema.");
                throw exception;
            }
        }
        
        return false;
    }
    
    public boolean registrarDevolucao(Locacao locacao) throws DisponibilidadeDiscordanteException{
        if(locacao != null){
            if(locacao.getCarro().isDisponibilidade() == true){
                DisponibilidadeDiscordanteException exception = new DisponibilidadeDiscordanteException("ERRO: O carro envolvido na devolução não possui o estado de locado.");
                throw exception;
            }
            
            locacao.setDtDevolucao(LocalDate.now());
            locacao.disponibilizarCarro();
            
            
            JOptionPane.showMessageDialog(null, "Valor total da locação: R$ " + String.valueOf(locacao.calcularValor()));
           
            atualizarArquivo();
            gk.atualizarArquivo();
            
            return true;
        }
        return false;
    }
    
    public Locacao consultarLocacao (Cliente c, Carro ca){
        for(Locacao locacao : locacoes){
            if(ca == locacao.getCarro() && c == locacao.getCliente()){
                return locacao;
            }
        }
        return null;
    }
    
    public void listarLocacoes(){
        for(Locacao locacao : locacoes){
            System.out.println(locacao.toString());
        }
    }

    public void atualizarArquivo(){
        try(PrintWriter p = new PrintWriter(new FileOutputStream("/Downloads/ArquivoLocacoes.txt", false))){
            for(Locacao locacao : locacoes){
                p.println(locacao.toString());
            }  
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
     }
}
