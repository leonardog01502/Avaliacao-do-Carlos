import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectado com Banco de Dados bem Sucedido !!");
            return DriverManager.getConnection("jdbc:mysql://localhost/prova", "root", "root");

        }catch (ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    }
}