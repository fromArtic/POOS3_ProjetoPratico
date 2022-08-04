package model;

import controller.GerenciadorCarros;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCarro extends JFrame{
    private JPanel panel;
    private JLabel lblMarca;
    private JTextField txtMarca;
    private JLabel lblModelo;
    private JTextField txtModelo;
    private JLabel lblAno;
    private JTextField txtAno;
    private JLabel lblPlaca;
    private JTextField txtPlaca;
    private JLabel lblPorta;
    private JTextField txtPorta;
    private JLabel lblAr;
    private JCheckBox chkAr;
    private JLabel lblDiaria;
    private JTextField txtDiaria;
    private JButton btnCadastrar;
    
    private GerenciadorCarros gca = GerenciadorCarros.getInstance();

    public JanelaCarro(){
        componentesJanela();
        propriedadesJanela();
    }

    private void componentesJanela(){
        panel = new JPanel();
        
        lblMarca = new JLabel("Informe a marca: ");
        txtMarca = new JTextField (10);
        
        lblModelo = new JLabel("Modelo: ");
        txtModelo = new JTextField (10);
        
        lblAno = new JLabel("Ano: ");
        txtAno = new JTextField (10);
        
        lblPlaca = new JLabel("Placa: ");
        txtPlaca = new JTextField (10);
        
        lblPorta = new JLabel("Quantidade de portas: ");
        txtPorta = new JTextField (10);
        
        lblAr = new JLabel("Possui ar?");
        chkAr = new JCheckBox();
        
        lblDiaria = new JLabel("Valor da diária: ");
        txtDiaria = new JTextField (10);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            String ma = this.txtMarca.getText();
            String mo = this.txtModelo.getText();
            String a = this.txtAno.getText();
            String p = this.txtPlaca.getText();
            String po = this.txtPorta.getText();
            boolean ar = this.chkAr.isSelected(); 
            String d = this.txtDiaria.getText();
            
            Carro carro = new Carro(ma, mo, Integer.parseInt(a), p, Integer.parseInt(po), ar, Double.parseDouble(d));
            
            try{
                gca.cadastrar(carro);
            }catch(EntradaCadastroException ex){
                Logger.getLogger(JanelaCarro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.txtMarca.setText("");
            this.txtModelo.setText("");
            this.txtAno.setText("");
            this.txtPlaca.setText("");
            this.txtPorta.setText("");
            this.txtDiaria.setText("");
        });
        
        adicionarComponentes();
    }

    private void adicionarComponentes(){
        add(panel);
        panel.add(lblMarca);
        panel.add(txtMarca);
        panel.add(lblModelo);
        panel.add(txtModelo);
        panel.add(lblAno);
        panel.add(txtAno);
        panel.add(lblPlaca);
        panel.add(txtPlaca);
        panel.add(lblPorta);
        panel.add(txtPorta);
        panel.add(lblAr);
        panel.add(chkAr);
        panel.add(lblDiaria);
        panel.add(txtDiaria);
        panel.add(btnCadastrar);
    }

    private void propriedadesJanela(){
        setVisible(true);
        setTitle("Cadastro de Carro");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
