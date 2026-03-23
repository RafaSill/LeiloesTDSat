
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/uc11",
                    "root",
                    "root"
            );
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE CONEXAO COM  O BANCO: " + e.getMessage());
        }
        return null;
    }

    public void desconetar() {
        try {
            conn.close();
        } catch (SQLException e) {

        }
    }
}
