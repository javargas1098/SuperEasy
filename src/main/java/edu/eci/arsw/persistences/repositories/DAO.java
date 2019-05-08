package edu.eci.arsw.persistences.repositories;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DAO <T	extends Serializable, PK> {
	public List<T> findAll() throws SQLException, ParseException;
	public T find(PK id);
    public void save(T entity) throws SQLException;
    public void update(T entity);
    public void delete(T o);
    public void remove(String id);

}
