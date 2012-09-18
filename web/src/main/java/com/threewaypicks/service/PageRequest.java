package com.threewaypicks.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: flgor
 * Date: 9/18/12
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageRequest implements Pageable {
    private int pageNumber;
    private  int pageSize;
    private int offset;
    private Sort sort;

    private PageRequest(){

    }

    public PageRequest(int pageNumber, int pageSize, int offset, Sort sort){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.offset = offset;
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }
}
