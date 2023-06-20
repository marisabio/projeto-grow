package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.PlantacaoTO;

public class PlantacaoDAO {

private Connection conexao;
    
    public final Connection getConexao() {
        return conexao;
    }
    public final void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    public PlantacaoDAO(Connection conexao) {
        setConexao(conexao);
    }
    public PlantacaoDAO() {
		
	}

	public ArrayList<PlantacaoTO> exibirPlantacao() {
        String sql = "SELECT * FROM plantacao";
        ArrayList<PlantacaoTO> retornarPlantacao = new ArrayList<>();
        
        try {
            if (conexao != null) {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                	PlantacaoTO plantacao = new PlantacaoTO();
                	plantacao.setCodPlantacao(rs.getInt(1));
                	plantacao.setCodUsuario(rs.getInt(2));
                	plantacao.setCodAlimento(rs.getInt(3));
                	plantacao.setCodHorta(rs.getInt(4));
                	plantacao.setFileira(rs.getInt(5));
                	plantacao.setPosicao(rs.getInt(6));
					plantacao.setQntdPlantada(rs.getInt(7));
					retornarPlantacao.add(plantacao);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar os objetos Plantacao: " + e.getMessage());
        }
        return retornarPlantacao;
    }
	
	public PlantacaoTO exibirPlantacaoId(int codPlantacao) {
	    String sql = "SELECT * FROM plantacao WHERE cod_plantacao = ?";
	    PlantacaoTO plantacao = null;
	    try {
	        if (conexao != null) {
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setInt(1, codPlantacao);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	plantacao = new PlantacaoTO();
	                plantacao.setCodPlantacao(rs.getInt(1));
                	plantacao.setCodUsuario(rs.getInt(2));
                	plantacao.setCodAlimento(rs.getInt(3));
                	plantacao.setCodHorta(rs.getInt(4));
                	plantacao.setFileira(rs.getInt(5));
                	plantacao.setPosicao(rs.getInt(6));
					plantacao.setQntdPlantada(rs.getInt(7));
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao buscar o objeto Plantacao: " + e.getMessage());
	    }

	    return plantacao;
	}
	
	public void inserir(PlantacaoTO plantacao) {
	    String sql = "insert into plantacao(cod_plantacao, cod_usuario, cod_alimento, cod_horta, fileira, posicao, qntd_plantada) values (?,?,?,?,?,?,?)";
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setInt(1, plantacao.getCodPlantacao());
			ps.setInt(2, plantacao.getCodUsuario());
			ps.setInt(3, plantacao.getCodAlimento());
			ps.setInt(4, plantacao.getCodHorta());
			ps.setInt(5, plantacao.getFileira());
			ps.setInt(6, plantacao.getPosicao());
			ps.setInt(7, plantacao.getQntdPlantada());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("Erro ao inserir o objeto Plantacao: " + e.getMessage());
	    }
	}

	public void atualizar(PlantacaoTO plantacao) {
	    String sql = "UPDATE plantacao SET cod_usuario = ?, cod_alimento = ?, cod_horta = ?, fileira = ?, posicao = ?, qntd_plantada = ? WHERE cod_plantacao = ?";
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setInt(1, plantacao.getCodPlantacao());
			ps.setInt(2, plantacao.getCodUsuario());
			ps.setInt(3, plantacao.getCodAlimento());
			ps.setInt(4, plantacao.getCodHorta());
			ps.setInt(5, plantacao.getFileira());
			ps.setInt(6, plantacao.getPosicao());
			ps.setInt(7, plantacao.getQntdPlantada());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("Erro ao atualizar o objeto Plantacao: " + e.getMessage());
	    }
	}

	public void excluir(int codPlantacao) {
	    String sql = "DELETE FROM plantacao WHERE cod_plantacao = ?";
	    try {
	        PreparedStatement ps = conexao.prepareStatement(sql);
	        ps.setInt(1, codPlantacao);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir o objeto Plantacao: " + e.getMessage());
	    }
	}

}
