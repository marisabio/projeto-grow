package br.com.fiap.teste;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;

public class TesteInserir {
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		UsuarioBO usuarioBO = new UsuarioBO();

		System.out.println("Código de usuário: ");
		int codUsuario = Integer.parseInt(input.nextLine());
		System.out.println("Nome: ");
		String nome = input.nextLine();
		System.out.println("Senha: ");
		String senha = input.nextLine();
		System.out.println("Email: ");
		String email = input.nextLine();
		System.out.println("CEP: ");
		String cep = input.nextLine();

		UsuarioTO usuario = new UsuarioTO(codUsuario, nome, senha, email, cep);

		usuarioBO.inserirUsuario(usuario);

		input.close();
	}
}
