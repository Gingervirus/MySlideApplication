package com.myschool.amwentzel.myslideapplication.repositories;

import java.util.Set;

/**
 * Created by amwentzel on 2016/08/29.
 */
public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}
