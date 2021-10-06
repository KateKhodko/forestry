package com.khodko.forestry.service;

import com.khodko.forestry.dao.ForestryDao;
import com.khodko.forestry.entity.Forestry;

import java.io.Serializable;
import java.util.List;

public class ForestryService {

    private final ForestryDao forestryDao = new ForestryDao();

    public ForestryService() {
    }

    public Serializable save(Forestry item) {
        return forestryDao.save(item);
    }

    public void update(Forestry item) {
        forestryDao.update(item);
    }

    public void delete(Forestry item) {
        forestryDao.delete(item);
    }

    public Forestry findById(long id) {
        return forestryDao.findById(id);
    }

    public List<Forestry> findAll() {
        return forestryDao.findAll();
    }
}
