package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaMovimentacao {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDao movimentacao = new MovimentacaoDao(manager);

		System.out.println(movimentacao.busca(1).getConta().getTitular());

	}
}
