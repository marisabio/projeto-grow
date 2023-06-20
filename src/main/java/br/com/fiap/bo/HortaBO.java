package br.com.fiap.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.HortaDAO;
import br.com.fiap.to.HortaTO;

public class HortaBO {

	public ArrayList<HortaTO> exibirDadosHorta() {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			HortaDAO alimentodao = new HortaDAO(con);
			ArrayList<HortaTO> hortas = alimentodao.exibirHorta();
			return hortas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

	public HortaTO exibirDadosHortaId(int codHorta) {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			HortaDAO alimentodao = new HortaDAO(con);
			HortaTO horta = alimentodao.exibirHortaId(codHorta);
			return horta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

	public void inserirHorta(HortaTO horta) throws SQLException {
        Connection con = null;
        try {
            con = Conexao.abrirConexao();
            HortaDAO hortadao = new HortaDAO(con);
            hortadao.inserir(horta);
            System.out.println("Horta inserida com sucesso.");
        } finally {
            Conexao.fecharConexao(con);
        }
    }

	public void atualizarHorta(HortaTO horta) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			HortaDAO hortadao = new HortaDAO(con);
			hortadao.atualizar(horta);
			System.out.println("Horta atualizada com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

	public void excluirHorta(int codHorta) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			HortaDAO hortadao = new HortaDAO(con);
			hortadao.excluir(codHorta);
			System.out.println("Horta excluída com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

}
