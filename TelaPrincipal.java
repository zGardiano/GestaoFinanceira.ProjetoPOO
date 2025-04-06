import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaPrincipal {
    private static ArrayList<Transacao> transacoes = new ArrayList<>();
    private static JLabel labelResumo;

    public static void abrirTela(String usuario) {
        JFrame frame = new JFrame("Bem-vindo, " + usuario);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        DefaultTableModel modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Descrição");
        modeloTabela.addColumn("Valor");
        modeloTabela.addColumn("Tipo");
        modeloTabela.addColumn("Data");

        JTable tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JButton botaoNovaTransacao = new JButton("Nova Transação");

        labelResumo = new JLabel("Saldo: R$ 0.00 | Entradas: R$ 0.00 | Saídas: R$ 0.00");
        atualizarResumo();

        botaoNovaTransacao.addActionListener(e -> {
            Transacao.abrir(novaTransacao -> {
                transacoes.add(novaTransacao);
                modeloTabela.addRow(new Object[]{
                        novaTransacao.getDescricao(),
                        String.format("R$ %.2f", novaTransacao.getValor()),
                        novaTransacao.getTipo(),
                        novaTransacao.getData().toString()
                });
                atualizarResumo();
            });
        });

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(labelResumo, BorderLayout.CENTER);
        topo.add(botaoNovaTransacao, BorderLayout.EAST);

        frame.add(topo, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void atualizarResumo() {
        double entradas = 0, saidas = 0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equals("Entrada")) {
                entradas += t.getValor();
            } else {
                saidas += t.getValor();
            }
        }
        double saldo = entradas - saidas;
        labelResumo.setText(String.format("Saldo: R$ %.2f | Entradas: R$ %.2f | Saídas: R$ %.2f", saldo, entradas, saidas));
    }
}