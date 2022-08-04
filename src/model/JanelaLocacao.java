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

public class JanelaLocacao extends JFrame{
    private JPanel panel;
    private JLabel lblDiarias;
    private JTextField txtDiaria;
    private JLabel lblCliente;
    private JTextField txtCliente;
    private JLabel lblCarro;
    private JTextField txtCarro;
    private JButton btnCadastrar;
    
    private GerenciadorClientes gc = GerenciadorClientes.getInstance();
    private GerenciadorCarros gca = GerenciadorCarros.getInstance();
    private GerenciadorLocacoes gl = GerenciadorLocacoes.getInstance();

    public JanelaLocacao(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();
        
        lblDiarias = new JLabel("Informe quantas diárias serão: ");
        txtDiaria = new JTextField (10);
        
        lblCliente = new JLabel("Nome do cliente: ");
        txtCliente = new JTextField (10);
        
        lblCarro = new JLabel("Marca do carro: ");
        txtCarro = new JTextField (10);

        btnCadastrar = new JButton("Registrar");
        btnCadastrar.addActionListener(e -> {
            String n = this.txtDiaria.getText();
            String c = this.txtCliente.getText();
            String r = this.txtCarro.getText();
            
            Cliente cliente = gc.consultarCliente(c);
            Carro carro = gca.consultarCarro(r);
            
            if(cliente != null && carro != null){
                Locacao l = new Locacao(Integer.parseInt(n), cliente, carro);
                try{
                    gl.registrarLocacao(l);
                }catch(ElementoInexistenteException ex){
                    Logger.getLogger(JanelaLocacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            this.txtDiaria.setText("");
            this.txtCliente.setText("");
            this.txtCarro.setText("");
        });
        
        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(lblDiarias);
        panel.add(txtDiaria);
        panel.add(lblCliente);
        panel.add(txtCliente);
        panel.add(lblCarro);
        panel.add(txtCarro);
        panel.add(btnCadastrar);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Registro de Locação");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
