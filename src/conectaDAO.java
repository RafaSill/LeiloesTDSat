
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    private Connection conn;
    
    public Connection getConexao() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/uc11?useSSL=false",
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
