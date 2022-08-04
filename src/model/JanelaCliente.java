package model;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaCliente extends JFrame{
    private JPanel panel;
    private JButton btnFisica;
    private JButton btnJuridica;

    public JanelaCliente(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();

        btnFisica = new JButton("Pessoa Física");
        btnFisica.addActionListener(e -> {
            new JanelaPessoaFisica();
        });

        btnJuridica = new JButton("Pessoa Jurídica");
        btnJuridica.addActionListener(e -> {
            new JanelaPessoaJuridica();
        });
        
        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(btnFisica);
        panel.add(btnJuridica);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Inserção de Cliente");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
