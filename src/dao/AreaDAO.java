package dao;

import beans.Area;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO {

    public void cadastrar(Area area) {
        String sql = "INSERT INTO area (nome_area) VALUES (?)";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, area.getNomeArea());
            pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar área", e);
        }
    }

    public List<Area> getArea(String nomeArea) {
        String sql = "SELECT id, nome_area FROM area WHERE nome_area LIKE ? ORDER BY nome_area";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + nomeArea + "%");

            try (ResultSet rs = pst.executeQuery()) {
                
                List<Area> listaAreas = new ArrayList<>();
                
                while (rs.next()) {
                    Area a = new Area();
                    a.setId(rs.getInt("id"));
                    a.setNomeArea(rs.getString("nome_area"));
                    listaAreas.add(a);
                }
                
                return listaAreas;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar áreas: " + e.getMessage(), e);
        }

        
    }

}
