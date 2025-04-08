import javax.swing.*;
import java.util.Hashtable;

public class CadastroLogin {
    private static Hashtable<String, String> usuarios = new Hashtable<>();

    public static String executarLoginOuCadastro() {
        while (true) {
            String[] opcoes = {"Login", "Cadastrar", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao Sistema de Gestão Financeira",
                    "Tela Inicial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);

            if (escolha == 0) {
                String usuario = realizarLogin();
                if (usuario != null) return usuario;
            } else if (escolha == 1) {
                realizarCadastro();
            } else {
                return null;
            }
        }
    }

    private static void realizarCadastro() {
        String nome = JOptionPane.showInputDialog("Digite o nome de usuário:");
        if (nome == null) return;

        if (usuarios.containsKey(nome)) {
            JOptionPane.showMessageDialog(null, "Usuário já existe!");
            return;
        }

        String senha = JOptionPane.showInputDialog("Digite a senha:");
        if (senha == null) return;

        usuarios.put(nome, senha);
        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
    }

    private static String realizarLogin() {
        String nome = JOptionPane.showInputDialog("Digite o nome de usuário:");
        if (nome == null) return null;

        String senha = JOptionPane.showInputDialog("Digite a senha:");
        if (senha == null) return null;

        if (usuarios.containsKey(nome) && usuarios.get(nome).equals(senha)) {
            JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
            return nome;
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
            return null;
        }
    }
}
