import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    private conectaDAO conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.getConexao();
    }

    public boolean cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES"
                + "(?,?,?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro em cadastrar produtos: " + e.getMessage());
            return false;
        }
    }
    
    public List<ProdutosDTO> lista(ProdutosDTO p){      
        String sql = "SELECT * FROM produtos"; 
        
        List<ProdutosDTO> lista = new ArrayList<>();
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);      
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
            }
            
        } catch (Exception e) {
        }
    }

}
