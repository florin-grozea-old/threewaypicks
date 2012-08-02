package com.threewaypicks.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 8/3/12
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class DaoTemplate<T> {
    protected abstract PagingAndSortingRepository<T,String> getRepository();

    public T save(T record){
        return getRepository().save(record);
    }

    public void delete(T record){
        getRepository().delete(record);
    }

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }
}
