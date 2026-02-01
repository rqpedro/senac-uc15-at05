package dao;

import beans.Perfil;
import beans.Usuario;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void cadastrar(Usuario u) {
        String sql = """
            INSERT INTO usuario 
            (nome_usuario, email_usuario, login, senha, ativo, id_perfil)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, u.getNomeUsuario());
            pst.setString(2, u.getEmailUsuario());
            pst.setString(3, u.getLogin());
            pst.setString(4, u.getSenha());
            pst.setBoolean(5, u.isAtivo());
            pst.setInt(6, u.getPerfil().getId());

            pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar usuário", e);
        }
    }

    public Usuario login(String login, String senha) {
        String sql = "SELECT u.id, u.nome_usuario, u.email_usuario, u.login, u.senha, u.ativo, "
                + "p.id AS perfil_id, p.nome_perfil "
                + "FROM usuario u "
                + "JOIN perfil p ON u.id_perfil = p.id "
                + "WHERE u.login = ? AND u.senha = ?";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, login);
            pst.setString(2, senha);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNomeUsuario(rs.getString("nome_usuario"));
                    usuario.setEmailUsuario(rs.getString("email_usuario"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setAtivo(rs.getBoolean("ativo"));

                    Perfil perfil = new Perfil();
                    perfil.setId(rs.getInt("perfil_id"));
                    perfil.setPerfil(rs.getString("nome_perfil"));

                    usuario.setPerfil(perfil);

                    return usuario;
                } else {
                    // Login ou senha incorretos
                    return null;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar logar", e);
        }
    }

    public List<Usuario> getUsuario(String nomeUsuario) {
        String sql = "SELECT u.id, u.nome_usuario, u.email_usuario, u.login, u.ativo, u.id_perfil, p.nome_perfil "
                + "FROM usuario u "
                + "JOIN perfil p ON u.id_perfil = p.id "
                + "WHERE u.nome_usuario LIKE ? "
                + "ORDER BY u.nome_usuario";

        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + nomeUsuario + "%");

            try (ResultSet rs = pst.executeQuery()) {

                List<Usuario> listaUsuario = new ArrayList<>();

                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNomeUsuario(rs.getString("nome_usuario"));
                    u.setEmailUsuario(rs.getString("email_usuario"));
                    u.setLogin(rs.getString("login"));
                    u.setAtivo(rs.getBoolean("ativo"));

                    Perfil perfil = new Perfil();
                    perfil.setId(rs.getInt("id_perfil"));
                    perfil.setPerfil(rs.getString("nome_perfil"));
                    u.setPerfil(perfil);

                    listaUsuario.add(u);
                }
                return listaUsuario;
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuários: " + e.getMessage(), e);
        }

    }

}
