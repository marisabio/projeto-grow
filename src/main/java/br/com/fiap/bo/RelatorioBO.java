package br.com.fiap.bo;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.RelatorioDAO;
import br.com.fiap.to.RelatorioTO;

public class RelatorioBO {
	
	public ArrayList<RelatorioTO> exibirDadosRelatorio() {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			RelatorioDAO relatoriodao = new RelatorioDAO(con);
			ArrayList<RelatorioTO> relatorios = relatoriodao.exibirRelatorio();
			return relatorios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito.");
			Conexao.fecharConexao(con);
		}
	}

}
