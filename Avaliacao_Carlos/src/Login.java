import java.sql.*;

public class Login {
    public static boolean autenticarUsuario(String login, String senha) {
        try (Connection conexao = ConexaoBancoDados.getConexao()) {
            String query = "SELECT id, nome, login, senha, email FROM usuario WHERE login = ? AND senha = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, senha);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Acesso Autorizado!!");
                        return true;
                    } else {
                        System.out.println("Acesso Negado!!");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao autenticar usuário. Por favor, tente novamente.");
            return false;
        }
    }
}