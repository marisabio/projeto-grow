package br.com.fiap.bo;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.service.ViacepService;
import br.com.fiap.to.EnderecoTO;
import br.com.fiap.to.UsuarioTO;

public class UsuarioBO {

	public ArrayList<UsuarioTO> exibirDadosUsuario() {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			UsuarioDAO usuariodao = new UsuarioDAO(con);
			ArrayList<UsuarioTO> usuarios = usuariodao.exibirUsuario();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito");
			Conexao.fecharConexao(con);
		}
	}

	public UsuarioTO exibirDadosUsuarioId(int codUsuario) {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			UsuarioDAO usuariodao = new UsuarioDAO(con);
			UsuarioTO empresa = usuariodao.exibirUsuarioId(codUsuario);
			return empresa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			System.out.println("Feito");
			Conexao.fecharConexao(con);
		}
	}

	public void inserirUsuario(UsuarioTO usuario) throws SQLException {
		ViacepService viacepservice = new ViacepService();
		Connection con = null;
		if (validacaoUsuario(usuario) == true) {
			usuario.setCodUsuario(usuario.getCodUsuario());
			usuario.setNome(usuario.getNome());
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			usuario.setEmail(usuario.getEmail());
			usuario.setCep(usuario.getCep());
			try {
				EnderecoTO endereco = viacepservice.getEndereco(usuario.getCep());
				usuario.setRua(endereco.getLogradouro());
				usuario.setBairro(endereco.getBairro());
				usuario.setCidade(endereco.getLocalidade());
				usuario.setUf(endereco.getUf());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				con = Conexao.abrirConexao();
				UsuarioDAO usuariodao = new UsuarioDAO(con);
				usuariodao.inserir(usuario);
				System.out.println("Usuario com sucesso.");
			} finally {
				Conexao.fecharConexao(con);
			}
		}
	}

	public void atualizarUsuario(UsuarioTO usuario) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			UsuarioDAO usuariodao = new UsuarioDAO(con);
			usuariodao.atualizar(usuario);
			System.out.println("Empresa atualizada com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}

	public void excluirUsuario(int codUsuario) throws SQLException {
		Connection con = null;
		try {
			con = Conexao.abrirConexao();
			UsuarioDAO usuariodao = new UsuarioDAO(con);
			usuariodao.excluir(codUsuario);
			System.out.println("Empresa excluída com sucesso.");
		} finally {
			Conexao.fecharConexao(con);
		}
	}
	
	public boolean validacaoUsuario(UsuarioTO usuario) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<UsuarioTO>> violations = validator.validate(usuario);
		int violantionCount = 0;
		for (ConstraintViolation<UsuarioTO> violation : violations) {
			violantionCount++;
			System.out.println(violation.getMessage());
		}
		if (violantionCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	public String criptografarSenha(String senha) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = senha.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			senha = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return senha;
	}

}
