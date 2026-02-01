package dao;

import beans.Processo;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcessoDAO {

    public void cadastrar(Processo processo) {
        String sql = "INSERT INTO processo (nome_processo) VALUES (?)";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, processo.getNomeProcesso());
            pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar processo", e);
        }
    }

    public List<Processo> getProcesso(String nomeProcesso) {
        String sql = "SELECT id, nome_processo FROM processo WHERE nome_processo LIKE ? ORDER BY nome_processo";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + nomeProcesso + "%");

            try (ResultSet rs = pst.executeQuery()) {
                
                List<Processo> listaProcesso = new ArrayList<>();
                
                
                while (rs.next()) {
                    Processo p = new Processo();
                    
                    p.setId(rs.getInt("id"));
                    p.setNomeProcesso(rs.getString("nome_processo"));
                    listaProcesso.add(p);
                }
                return listaProcesso;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar processos: " + e.getMessage(), e);
        }

        
    }
}
