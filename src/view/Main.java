package view;

/**
 *
 * @author João Vitor B. Loreti, Camilly de Melo
 */

import java.io.IOException;
import model.DisponibilidadeDiscordanteException;
import model.ElementoInexistenteException;
import model.EntradaCadastroException;
import model.JanelaPrincipal;

public class Main{
    public static void main(String[] args) throws EntradaCadastroException, ElementoInexistenteException, DisponibilidadeDiscordanteException, IOException{
        
        new JanelaPrincipal();
        
        /**
        *
        * Para testes, desconsiderando a interface visual
        */
        
        /*GerenciadorClientes gc = GerenciadorClientes.getInstance();
        GerenciadorCarros gk = GerenciadorCarros.getInstance();
        GerenciadorLocacoes gl = GerenciadorLocacoes.getInstance();
        
        PessoaFisica pf1 = new PessoaFisica("Berg L", "123456789123456789");
        PessoaFisica pf2 = new PessoaFisica("Yawn J", "987654321987654321"); //IDs diferentes -> Válido
        
        PessoaJuridica pj1 = new PessoaJuridica("Tom K", "123456789123456789", "Tom K Entertainment");
        PessoaJuridica pj2 = new PessoaJuridica("Dom D", "123456789123456789", "Dom D Big Show"); //IDs iguais -> Inválido
        
        gc.cadastrar(pf1);
        gc.cadastrar(pf2);
        gc.cadastrar(pj1);
        //gc.cadastrar(pj2); //EntradaCadastroException
        gc.listarClientes();
        
        Carro c1 = new Carro("Hyundai", "Veloster", 2014, "BTM1729", 2, true, 940);
        Carro c2 = new Carro("Volkswagen", "New Beetle", 2009, "CFU1980", 4, false, 250.25);
        Carro c3 = new Carro("Ford", "Edge", 2022, "CFU1980", 4, true, 15000); //Placas iguais -> Inválido
        
        gk.cadastrar(c1);
        gk.cadastrar(c2);
        //gk.cadastrar(c3); //EntradaCadastroException
        gk.listarCarros();
        
        Locacao l1 = new Locacao(5, pf1, c1);
        Locacao l2 = new Locacao(7, pj1, c2);
        Locacao l3 = new Locacao(2, pj2, c3); //Contém o cliente e carro que tiveram seus registros invalidados
        
        gl.registrarLocacao(l1);
        gl.registrarLocacao(l2);
        //gl.registrarLocacao(l3); //ElementoInexistenteException
        gl.listarLocacoes();
        
        //c1.setDisponibilidade(true); //DisponibilidadeDiscordanteException
        
        gl.registrarDevolucao(l1);
        gl.listarLocacoes();*/
    }
}
