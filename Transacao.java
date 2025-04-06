import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import java.util.Date;

public class Transacao {
    public interface CallbackTransacao {
        void aoRegistrar(Transacao transacao);
    }

    private String descricao;
    private double valor;
    private String tipo;
    private Date data;

    public Transacao(String descricao, double valor, String tipo, Date data) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getData() {
        return data;
    }

    public static void abrir(CallbackTransacao callback) {
        JFrame frame = new JFrame("Nova Transação");
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(6, 2));

        JTextField campoDescricao = new JTextField();
        JTextField campoValor = new JTextField();
        String[] tipos = {"Entrada", "Saída"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        JButton botaoRegistrar = new JButton("Registrar");

        frame.add(new JLabel("Descrição:"));
        frame.add(campoDescricao);
        frame.add(new JLabel("Valor:"));
        frame.add(campoValor);
        frame.add(new JLabel("Tipo:"));
        frame.add(comboTipo);
        frame.add(new JLabel());
        frame.add(botaoRegistrar);

        botaoRegistrar.addActionListener(e -> {
            String descricao = campoDescricao.getText();
            String valorStr = campoValor.getText();
            String tipo = (String) comboTipo.getSelectedItem();

            try {
                double valor = Double.parseDouble(valorStr);
                Transacao novaTransacao = new Transacao(descricao, valor, tipo, new Date());
                callback.aoRegistrar(novaTransacao);
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Valor inválido.");
            }
        });

        frame.setVisible(true);
    }
}