/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.SqlConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Quentin Fankrache
 * @param <E>
 */
public interface DAO<E> {

    Connection connection = SqlConnection.getInstance();

    List<E> getAll();

    E find(Integer id);

    void create(E e);

    void delete(Integer id);

    void update(E e);
}
