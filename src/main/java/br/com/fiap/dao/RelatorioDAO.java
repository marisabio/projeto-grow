package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.RelatorioTO;

public class RelatorioDAO {

	private Connection conexao;

	public final Connection getConexao() {
		return conexao;
	}

	public final void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public RelatorioDAO(Connection conexao) {
		setConexao(conexao);
	}

	public RelatorioDAO() {

	}

	public ArrayList<RelatorioTO> exibirRelatorio() {
		String sql = "SELECT NOME, NOME_HORTA, NOME_ALIMENTO, FILEIRA, POSICAO, QNTD_PLANTADA FROM PLANTACAO inner join USUARIO on PLANTACAO.COD_USUARIO = USUARIO.COD_USUARIO inner join ALIMENTO on  PLANTACAO.COD_ALIMENTO = ALIMENTO.COD_ALIMENTO inner join HORTA on PLANTACAO.COD_HORTA = HORTA.COD_HORTA order by 1";
		ArrayList<RelatorioTO> retornarRelatorio = new ArrayList<>();
		try {
			if (conexao != null) {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					RelatorioTO relatorio = new RelatorioTO();
					relatorio.setNome(rs.getString(1));
					relatorio.setNomeHorta(rs.getString(2));
					relatorio.setNomeAlimento(rs.getString(3));
					relatorio.setFileira(rs.getInt(4));
					relatorio.setPosicao(rs.getInt(5));
					relatorio.setQntdPlantada(rs.getInt(6));
					retornarRelatorio.add(relatorio);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar os Relatorios: " + e.getMessage());
		}
		return retornarRelatorio;
	}

}
