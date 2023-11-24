import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

            System.out.println("Conectou no banco de dados.");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar no BD: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
            ex.printStackTrace();
            return null;
        }
    }
}
