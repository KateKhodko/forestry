package com.khodko.forestry.service;

import com.khodko.forestry.dao.ForestTypeDao;
import com.khodko.forestry.entity.ForestType;
import com.khodko.forestry.entity.Tree;

import java.io.Serializable;
import java.util.List;

public class ForestTypeService {

    private final ForestTypeDao forestTypeDao = new ForestTypeDao();

    public ForestTypeService() {
    }

    public Serializable save(ForestType item) {
        return forestTypeDao.save(item);
    }

    public void update(ForestType item) {
        forestTypeDao.update(item);
    }

    public void delete(ForestType item) {
        forestTypeDao.delete(item);
    }

    public ForestType findById(long id) {
        return forestTypeDao.findById(id);
    }

    public List<ForestType> findAll() {
        return forestTypeDao.findAll();
    }
}
