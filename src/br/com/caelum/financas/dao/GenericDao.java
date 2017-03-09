package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> {

	private Class clazz;
	private EntityManager manager;

	public GenericDao() {
	}

	public GenericDao(EntityManager manager, Class clazz) {
		this.manager = manager;
		this.clazz = clazz;

	}

	public void adiciona(T entity) {
		this.manager.persist(entity);
	}

	public void remove(T entity) {
		this.manager.remove(entity);
	}

	public T busca(Integer id) {
		return (T) this.manager.find(clazz, id);
	}
	
	public List<T> lista() {
		return this.manager.createQuery("select g from " + clazz.getSimpleName() + " g", clazz).getResultList();
	}
}
