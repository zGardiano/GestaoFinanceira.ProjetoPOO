public class Main {
    public static void main(String[] args) {
        String usuarioLogado = CadastroLogin.executarLoginOuCadastro();

        if (usuarioLogado != null) {
            TelaPrincipal.abrirTela(usuarioLogado);
        } else {
            System.out.println("Sistema encerrado.");
        }
    }
}
