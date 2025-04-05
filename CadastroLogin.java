import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import java.util.Hashtable;

public class CadastroLogin {
    private static Hashtable<String, String> usuarios = new Hashtable<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro/Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JTextField campoUsuario = new JTextField();
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoEntrar = new JButton("Entrar");

        frame.add(new JLabel("Usuário:"));
        frame.add(campoUsuario);
        frame.add(new JLabel("Senha:"));
        frame.add(campoSenha);
        frame.add(botaoCadastrar);
        frame.add(botaoEntrar);

        botaoCadastrar.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            if (usuario.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
            } else if (usuarios.containsKey(usuario)) {
                JOptionPane.showMessageDialog(frame, "Usuário já existe.");
            } else {
                usuarios.put(usuario, senha);
                JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!");
            }
        });

        botaoEntrar.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                frame.dispose();
                TelaPrincipal.abrirTela(usuario);
            } else {
                JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos.");
            }
        });

        frame.setVisible(true);
    }
}