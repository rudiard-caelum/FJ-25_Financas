package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.GenericDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();

		EntityManager manager = new JPAUtil().getEntityManager();

		/* ContaDao dao = new ContaDao(manager); */
		GenericDao dao = new GenericDao(manager, Conta.class);

		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-7");
		conta.setAgencia("0990");

		manager.getTransaction().begin();

		dao.adiciona(conta);

		manager.getTransaction().commit();
		manager.close();

		System.out.println("Conta gravada com sucesso!");

		long fim = System.currentTimeMillis();

		System.out.println("Executado em: " + (fim - inicio) + "ms");
	}

}
