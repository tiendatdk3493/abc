package com.tma.gbst.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thuynghi on 5/4/2015.
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    List<T> findAll();
}
