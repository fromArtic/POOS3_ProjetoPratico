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

public class JanelaPessoaFisica extends JFrame{
    private JPanel panel;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblCpf;
    private JTextField txtCpf;
    private JButton btnCadastrar;
    
    private GerenciadorClientes gc = GerenciadorClientes.getInstance();

    public JanelaPessoaFisica(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();
        
        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField (10);
        
        lblCpf = new JLabel("Cpf: ");
        txtCpf = new JTextField (10);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            String n = this.txtNome.getText();
            String c = this.txtCpf.getText();
            
            PessoaFisica pf = new PessoaFisica(n,c);
            try{
                gc.cadastrar(pf);
            }catch(EntradaCadastroException ex){
                Logger.getLogger(JanelaPessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException ex){
                Logger.getLogger(JanelaPessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.txtNome.setText("");
            this.txtCpf.setText("");
        });

        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblCpf);
        panel.add(txtCpf);
        panel.add(btnCadastrar);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Pessoa Física");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
