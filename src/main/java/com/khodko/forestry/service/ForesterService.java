package com.khodko.forestry.service;

import com.khodko.forestry.dao.ForesterDao;
import com.khodko.forestry.entity.Forester;

import java.io.Serializable;
import java.util.List;

public class ForesterService {

    private final ForesterDao foresterDao = new ForesterDao();

    public ForesterService() {
    }

    public Serializable save(Forester item) {
        return foresterDao.save(item);
    }

    public void update(Forester item) {
        foresterDao.update(item);
    }

    public void delete(Forester item) {
        foresterDao.delete(item);
    }

    public Forester findById(long id) {
        return foresterDao.findById(id);
    }

    public List<Forester> findAll() {
        return foresterDao.findAll();
    }
}
