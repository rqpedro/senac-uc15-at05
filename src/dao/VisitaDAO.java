package dao;

import beans.Area;
import beans.Processo;
import beans.Usuario;
import beans.Visita;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VisitaDAO {

    public void cadastrar(Visita v) {
        String sql = "INSERT INTO visita (id_area, id_processo, id_usuario, data_visita) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, v.getArea().getId());
            pst.setInt(2, v.getProcesso().getId());
            pst.setInt(3, v.getUsuario().getId());
            pst.setDate(4, java.sql.Date.valueOf(v.getDataVisita()));
            pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar visita", e);
        }
    }

    public List<Visita> listar() {

        String sql = """
            SELECT
                v.id            AS id_visita,
                a.nome_area     AS nome_area,
                p.nome_processo AS nome_processo,
                u.nome_usuario  AS nome_usuario,
                v.data_visita   AS data_visita
            FROM visita v
            INNER JOIN area a     ON a.id = v.id_area
            INNER JOIN processo p ON p.id = v.id_processo
            INNER JOIN usuario u  ON u.id = v.id_usuario
            ORDER BY v.id
        """;

        List<Visita> lista = new ArrayList<>();

        try (
                Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Visita v = new Visita();
                v.setId(rs.getInt("id_visita"));
                v.setDataVisita(rs.getDate("data_visita").toLocalDate());

                Area a = new Area();
                a.setNomeArea(rs.getString("nome_area"));
                v.setArea(a);

                Processo p = new Processo();
                p.setNomeProcesso(rs.getString("nome_processo"));
                v.setProcesso(p);

                Usuario u = new Usuario();
                u.setNomeUsuario(rs.getString("nome_usuario"));
                v.setUsuario(u);

                lista.add(v);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar visitas", e);
        }

        return lista;
    }

    public void excluir(int idVisita) {
        String sql = "DELETE FROM visita WHERE id = ?";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idVisita);
            pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir visita", e);
        }
    }

}
