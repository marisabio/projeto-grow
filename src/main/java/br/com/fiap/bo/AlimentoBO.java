package br.com.fiap.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.AlimentoDAO;
import br.com.fiap.to.AlimentoTO;

public class AlimentoBO {
	
	public ArrayList<AlimentoTO> exibirDadosAlimento() {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			AlimentoDAO alimentodao = new AlimentoDAO(con);
			ArrayList<AlimentoTO> alimentos = alimentodao.exibirAlimento();
			return alimentos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

	public AlimentoTO exibirDadosAlimentoId(int codAlimento) {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			AlimentoDAO alimentodao = new AlimentoDAO(con);
			AlimentoTO alimento = alimentodao.exibirAlimentoId(codAlimento);
			return alimento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

	public void inserirAlimento(AlimentoTO alimento) throws SQLException {
        Connection con = null;
        try {
            con = Conexao.abrirConexao();
            AlimentoDAO alimentodao = new AlimentoDAO(con);
            alimentodao.inserir(alimento);
            System.out.println("Alimento inserido com sucesso.");
        } finally {
            Conexao.fecharConexao(con);
        }
    }

	public void atualizarAlimento(AlimentoTO alimento) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			AlimentoDAO alimentodao = new AlimentoDAO(con);
			alimentodao.atualizar(alimento);
			System.out.println("Alimento atualizado com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

	public void excluirAlimento(int codAlimento) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			AlimentoDAO alimentodao = new AlimentoDAO(con);
			alimentodao.excluir(codAlimento);
			System.out.println("Alimento excluído com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

}
