import java.sql.*;

public class Cadastro {
    public static void cadastrarUsuario(String nome, String login, String senha, String email) {
        try (Connection conexao = ConexaoBancoDados.getConexao()) {
            String query = "INSERT INTO usuario(nome, login, senha, email) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, login);
                preparedStatement.setString(3, senha);
                preparedStatement.setString(4, email);

                preparedStatement.executeUpdate();
                System.out.println("Cadastro efetuado com sucesso!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar usuário. Por favor, tente novamente.");
        }
    }
}