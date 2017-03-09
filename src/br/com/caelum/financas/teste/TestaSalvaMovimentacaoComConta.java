package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDao dao = new MovimentacaoDao(manager);

		Movimentacao mov = new Movimentacao();

		mov.setValor(new BigDecimal("0.1"));
		mov.setDescricao("Teste de movimentação.");
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);

		Conta conta = new Conta();
		conta.setBanco("Banco Santander");
		conta.setNumero("09999-9");
		conta.setAgencia("099");
		conta.setTitular("Maria");
		mov.setConta(conta);

		manager.getTransaction().begin();
		dao.adiciona(mov);
		manager.getTransaction().commit();
		manager.close();

		System.out.println("Movimentação gravada com sucesso!");

	}

}
