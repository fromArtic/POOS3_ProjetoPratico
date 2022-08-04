package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Locacao{
    private int numero;
    private LocalDate dtRealizacao;
    private int numDiarias;
    private LocalDate dtMaxDevolucao;
    private LocalDate dtDevolucao;
    private Cliente cliente;
    private Carro carro;

    public Locacao(int numDiarias, Cliente cliente, Carro carro){
        this.dtRealizacao = LocalDate.now();
        this.numDiarias = numDiarias;
        this.dtMaxDevolucao = dtRealizacao.plusDays(numDiarias);
        this.dtDevolucao = null;
        this.cliente = cliente;
        this.carro = carro;
    }

    public void locarCarro(){
        this.carro.setDisponibilidade(false);
    }
    public void disponibilizarCarro(){
        this.carro.setDisponibilidade(true);
    }
    public double calcularValor(){
        return numDiarias * carro.getDiaria();
    }

    public int getNumero(){
        return numero;
    }
    public LocalDate getDtRealizacao(){
        return dtRealizacao;
    }
    public int getNumDiarias(){
        return numDiarias;
    }
    public LocalDate getDtMaxDevolucao(){
        return dtMaxDevolucao;
    }
    public LocalDate getDtDevolucao(){
        return dtDevolucao;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public Carro getCarro(){
        return carro;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setDtDevolucao(LocalDate dtDevolucao){
        this.dtDevolucao = dtDevolucao;
    }

    @Override
    public String toString(){
        if(dtDevolucao == null){
            return "Locacao{[" + numero + "] dtRealizacao=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dtRealizacao) 
                + ", numDiarias=" + numDiarias + ", dtMaxDevolucao=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dtMaxDevolucao)
                + ", dtDevolucao=" + dtDevolucao + ", cliente=" + cliente + ", carro=" + carro + '}';
        }else{
            return "Locacao{[" + numero + "] dtRealizacao=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dtRealizacao) 
                + ", numDiarias=" + numDiarias + ", dtMaxDevolucao=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dtMaxDevolucao)
                + ", dtDevolucao=" + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dtDevolucao) + ", cliente=" + cliente + ", carro=" + carro + '}';
        }
    }
}
