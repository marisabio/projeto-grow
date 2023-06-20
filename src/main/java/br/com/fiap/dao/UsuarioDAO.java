package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.UsuarioTO;

public class UsuarioDAO {

    private Connection conexao;
    
    public final Connection getConexao() {
        return conexao;
    }
    public final void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    public UsuarioDAO(Connection conexao) {
        setConexao(conexao);
    }
    public UsuarioDAO() {
		
	}

	public ArrayList<UsuarioTO> exibirUsuario() {
        String sql = "SELECT * FROM usuario";
        ArrayList<UsuarioTO> retornarUsuario = new ArrayList<>();
        
        try {
            if (conexao != null) {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	UsuarioTO usuario = new UsuarioTO();
					usuario.setCodUsuario(rs.getInt(1));
					usuario.setNome(rs.getString(2));
					usuario.setEmail(rs.getString(3));
					usuario.setCep(rs.getString(4));
					usuario.setRua(rs.getString(5));
					usuario.setBairro(rs.getString(6));
					usuario.setCidade(rs.getString(7));
					usuario.setUf(rs.getString(8));
					usuario.setSenha(rs.getString(9));
					retornarUsuario.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar os objetos Usuario: " + e.getMessage());
        }
        return retornarUsuario;
    }
	
	public UsuarioTO exibirUsuarioId(int codUsuario) {
	    String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";
	    UsuarioTO usuario = null;
	    try {
	        if (conexao != null) {
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setInt(1, codUsuario);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                usuario = new UsuarioTO();
	                usuario.setCodUsuario(rs.getInt(1));
					usuario.setNome(rs.getString(2));
					usuario.setEmail(rs.getString(3));
					usuario.setCep(rs.getString(4));
					usuario.setRua(rs.getString(5));
					usuario.setBairro(rs.getString(6));
					usuario.setCidade(rs.getString(7));
					usuario.setUf(rs.getString(8));
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar o objeto Usuario: " + e.getMessage());
	    }

	    return usuario;
	}
	
	public void inserir(UsuarioTO usuario) {
	    String sql = "insert into usuario(cod_usuario, nome, email, cep, rua, bairro, cidade, uf, senha) values (?,?,?,?,?,?,?,?,?)";
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setInt(1, usuario.getCodUsuario());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getCep());
			ps.setString(5, usuario.getRua());
			ps.setString(6, usuario.getBairro());
			ps.setString(7, usuario.getCidade());
			ps.setString(8, usuario.getUf());
			ps.setString(9, usuario.getSenha());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("Erro ao inserir o objeto Usuario: " + e.getMessage());
	    }
	}

	public void atualizar(UsuarioTO usuario) {
	    String sql = "UPDATE usuario SET nome = ?, email = ?, cep = ?, rua = ?, bairro = ?, cidade = ?, uf = ?, senha = ? WHERE cod_usuario = ?";
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setInt(1, usuario.getCodUsuario());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getCep());
			ps.setString(5, usuario.getRua());
			ps.setString(6, usuario.getBairro());
			ps.setString(7, usuario.getCidade());
			ps.setString(8, usuario.getUf());
			ps.setString(9, usuario.getSenha());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("Erro ao atualizar o objeto Usuario: " + e.getMessage());
	    }
	}

	public void excluir(int codUsuario) {
	    String sql = "DELETE FROM usuario WHERE cod_usuario = ?";
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setInt(1, codUsuario);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir o objeto Usuario: " + e.getMessage());
	    }
	}

}
