package model;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame{
    private JPanel panel;
    private JButton btnCliente;
    private JButton btnCarro;
    private JButton btnLocacao;
    private JButton btnDevolucao;

    public JanelaPrincipal(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();

        btnCliente = new JButton("Inserir Cliente");
        btnCliente.addActionListener(e -> {
            new JanelaCliente();
        });

        btnCarro = new JButton("Inserir Carro");
        btnCarro.addActionListener(e -> {
            new JanelaCarro();
        });
        
        btnLocacao = new JButton("Realizar Locação");
        btnLocacao.addActionListener(e -> {
            new JanelaLocacao();
        });
        
        btnDevolucao = new JButton("Realizar Devolução");
        btnDevolucao.addActionListener(e -> {
            new JanelaDevolucao();
        });
        
        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(btnCliente);
        panel.add(btnCarro);
        panel.add(btnLocacao);
        panel.add(btnDevolucao);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Sistema de locadora de carro");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
