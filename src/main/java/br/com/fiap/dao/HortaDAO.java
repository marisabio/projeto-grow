package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.HortaTO;

public class HortaDAO {

	private Connection conexao;

	public final Connection getConexao() {
		return conexao;
	}

	public final void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	public HortaDAO(Connection conexao) {
		setConexao(conexao);
	}
	public HortaDAO() {

	}

	public ArrayList<HortaTO> exibirHorta() {
		String sql = "SELECT * FROM horta";
		ArrayList<HortaTO> retornarHorta = new ArrayList<>();

		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					HortaTO horta = new HortaTO();
					horta.setCodHorta(rs.getInt(1));
					horta.setNomeHorta(rs.getString(2));
					horta.setCapacidadePlantio(rs.getInt(3));
					retornarHorta.add(horta);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar os objetos Horta: " + e.getMessage());
		}
		return retornarHorta;
	}

	public HortaTO exibirHortaId(int codHorta) {
		String sql = "SELECT * FROM horta WHERE cod_horta = ?";
		HortaTO horta = null;
		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setInt(1, codHorta);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					horta = new HortaTO();
					horta.setCodHorta(rs.getInt(1));
					horta.setNomeHorta(rs.getString(2));
					horta.setCapacidadePlantio(rs.getInt(3));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar o objeto Horta: " + e.getMessage());
		}

		return horta;
	}

	public void inserir(HortaTO horta) {
		String sql = "insert into horta(cod_horta, nome_horta, capacidade_plantio) values (?,?,?)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, horta.getCodHorta());
			ps.setString(2, horta.getNomeHorta());
			ps.setInt(3, horta.getCapacidadePlantio());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao inserir o objeto Horta: " + e.getMessage());
		}
	}

	public void atualizar(HortaTO horta) {
		String sql = "UPDATE horta SET nome_horta = ?, capacidade_plantio = ? WHERE cod_horta = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, horta.getCodHorta());
			ps.setString(2, horta.getNomeHorta());
			ps.setInt(3, horta.getCapacidadePlantio());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar o objeto Horta: " + e.getMessage());
		}
	}

	public void excluir(int codHorta) {
		String sql = "DELETE FROM horta WHERE cod_horta = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codHorta);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao excluir o objeto Horta: " + e.getMessage());
		}
	}

}
