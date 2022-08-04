package model;

import controller.GerenciadorCarros;
import controller.GerenciadorClientes;
import controller.GerenciadorLocacoes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaDevolucao extends JFrame{
    private JPanel panel;
    private JLabel lblCliente;
    private JTextField txtCliente;
    private JLabel lblCarro;
    private JTextField txtCarro;
    private JButton btnCadastrar;
    
    private GerenciadorClientes gc = GerenciadorClientes.getInstance();
    private GerenciadorCarros gca = GerenciadorCarros.getInstance();
    private GerenciadorLocacoes gl = GerenciadorLocacoes.getInstance();

    public JanelaDevolucao(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();
        
        lblCliente = new JLabel("Nome do cliente: ");
        txtCliente = new JTextField (10);
        
        lblCarro = new JLabel("Marca do carro: ");
        txtCarro = new JTextField (10);

        btnCadastrar = new JButton("Devolver");
        btnCadastrar.addActionListener(e -> {
            String c = this.txtCliente.getText();
            String r = this.txtCarro.getText();
            
            Cliente cliente = gc.consultarCliente(c);
            Carro carro = gca.consultarCarro(r);
            
            if(cliente != null && carro != null){
                Locacao loc = gl.consultarLocacao(cliente, carro);
                if(loc != null){
                    try{
                        gl.registrarDevolucao(loc);
                    }catch(DisponibilidadeDiscordanteException ex){
                        Logger.getLogger(JanelaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            this.txtCliente.setText("");
            this.txtCarro.setText("");
        });
        
        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(lblCliente);
        panel.add(txtCliente);
        panel.add(lblCarro);
        panel.add(txtCarro);
        panel.add(btnCadastrar);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Registro de Devolução");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
