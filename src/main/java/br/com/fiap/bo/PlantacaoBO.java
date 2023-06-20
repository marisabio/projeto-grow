package br.com.fiap.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PlantacaoDAO;
import br.com.fiap.to.PlantacaoTO;

public class PlantacaoBO {

	public ArrayList<PlantacaoTO> exibirDadosPlantacao() {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			PlantacaoDAO plantacaodao = new PlantacaoDAO(con);
			ArrayList<PlantacaoTO> plantacoes = plantacaodao.exibirPlantacao();
			return plantacoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

	public PlantacaoTO exibirDadosPlantacaoId(int codPlantacao) {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			PlantacaoDAO plantacaodao = new PlantacaoDAO(con);
			PlantacaoTO plantacao = plantacaodao.exibirPlantacaoId(codPlantacao);
			return plantacao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

	public void inserirPlantacao(PlantacaoTO plantacao) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			PlantacaoDAO plantacaodao = new PlantacaoDAO(con);
			plantacaodao.inserir(plantacao);
			System.out.println("Plantacao inserida com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

	public void atualizarPlantacao(PlantacaoTO plantacao) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			PlantacaoDAO plantacaodao = new PlantacaoDAO(con);
			plantacaodao.atualizar(plantacao);
			System.out.println("Plantacao atualizada com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

	public void excluirPlantacao(int codPlantacao) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			PlantacaoDAO plantacaodao = new PlantacaoDAO(con);
			plantacaodao.excluir(codPlantacao);
			System.out.println("Plantacao excluída com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

}
