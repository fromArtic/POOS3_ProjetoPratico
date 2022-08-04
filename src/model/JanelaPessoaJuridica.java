package model;

import controller.GerenciadorClientes;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaPessoaJuridica extends JFrame{
    private JPanel panel;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblCnpj;
    private JTextField txtCnpj;
    private JLabel lblRazao;
    private JTextField txtRazao;
    private JButton btnCadastrar;
    
    private GerenciadorClientes gc = GerenciadorClientes.getInstance();

    public JanelaPessoaJuridica(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();
        
        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField (10);
        
        lblCnpj = new JLabel("Cnpj: ");
        txtCnpj = new JTextField (10);
        
        lblRazao = new JLabel("Razão: ");
        txtRazao = new JTextField (10);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            String n = this.txtNome.getText();
            String c = this.txtCnpj.getText();
            String r = this.txtRazao.getText();
            
            PessoaJuridica pj = new PessoaJuridica(n,c,r);
            
            try{
                gc.cadastrar(pj);
            }catch(EntradaCadastroException ex){
                Logger.getLogger(JanelaPessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException ex){
                Logger.getLogger(JanelaPessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.txtNome.setText("");
            this.txtCnpj.setText("");
        });
        
        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblCnpj);
        panel.add(txtCnpj);
        panel.add(lblRazao);
        panel.add(txtRazao);
        panel.add(btnCadastrar);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Pessoa Jurídica");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
