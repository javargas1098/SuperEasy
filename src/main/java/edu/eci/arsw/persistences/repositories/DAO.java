package edu.eci.arsw.persistences.repositories;

import java.io.Serializable;
import java.util.List;

public interface DAO <T	extends Serializable, PK> {
	public List<T> findAll();
	public T find(PK id);
    public void save(T entity);
    public void update(T entity);
    public void delete(T o);
    public void remove(String id);

}
