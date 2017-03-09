package br.com.caelum.financas.listeners;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.caelum.financas.interfaces.Atualizavel;

public class AtualizadorDeData {

	@PrePersist
	@PreUpdate
	public void preAltera(Object entidade) {
		System.out.println("Atualizando a data da movimentação.");
		Atualizavel a = (Atualizavel) entidade;
		a.setData(Calendar.getInstance());
	}
}
