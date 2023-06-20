package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.AlimentoTO;

public class AlimentoDAO {

	private Connection conexao;

	public final Connection getConexao() {
		return conexao;
	}
	public final void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	public AlimentoDAO(Connection conexao) {
		setConexao(conexao);
	}
	public AlimentoDAO() {

	}

	public ArrayList<AlimentoTO> exibirAlimento() {
		String sql = "SELECT * FROM alimento";
		ArrayList<AlimentoTO> retornarAlimento = new ArrayList<>();

		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					AlimentoTO alimento = new AlimentoTO();
					alimento.setCodAlimento(rs.getInt(1));
					alimento.setNomeAlimento(rs.getString(2));
					alimento.setTipoAlimento(rs.getString(3));
					alimento.setQntdSementeAlimento(rs.getInt(4));
					retornarAlimento.add(alimento);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar os objetos Alimento: " + e.getMessage());
		}
		return retornarAlimento;
	}

	public AlimentoTO exibirAlimentoId(int codAlimento) {
		String sql = "SELECT * FROM alimento WHERE cod_alimento = ?";
		AlimentoTO alimento = null;
		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setInt(1, codAlimento);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					alimento = new AlimentoTO();
					alimento.setCodAlimento(rs.getInt(1));
					alimento.setNomeAlimento(rs.getString(2));
					alimento.setTipoAlimento(rs.getString(3));
					alimento.setQntdSementeAlimento(rs.getInt(4));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o objeto Alimento: " + e.getMessage());
		}

		return alimento;
	}

	public void inserir(AlimentoTO alimento) {
		String sql = "insert into alimento(cod_alimento, nome_alimento, tipo_alimento, qntd_semente_alimento) values (?,?,?,?)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, alimento.getCodAlimento());
			ps.setString(2, alimento.getNomeAlimento());
			ps.setString(3, alimento.getTipoAlimento());
			ps.setInt(4, alimento.getQntdSementeAlimento());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao inserir o objeto Alimento: " + e.getMessage());
		}
	}

	public void atualizar(AlimentoTO alimento) {
		String sql = "UPDATE alimento SET nome_alimento = ?, tipo_alimento = ?, qntd_semente_alimento = ? WHERE cod_alimento = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, alimento.getCodAlimento());
			ps.setString(2, alimento.getNomeAlimento());
			ps.setString(3, alimento.getTipoAlimento());
			ps.setInt(4, alimento.getQntdSementeAlimento());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar o objeto Alimento: " + e.getMessage());
		}
	}

	public void excluir(int codAlimento) {
		String sql = "DELETE FROM alimento WHERE cod_alimento = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codAlimento);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao excluir o objeto Alimento: " + e.getMessage());
		}
	}

}
