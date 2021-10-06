package com.khodko.forestry.service;

import com.khodko.forestry.dao.VillageDao;
import com.khodko.forestry.entity.Village;

import java.io.Serializable;
import java.util.List;

public class VillageService {

    private final VillageDao villageDao = new VillageDao();

    public VillageService() {
    }

    public Serializable save(Village item) {
        return villageDao.save(item);
    }

    public void update(Village item) {
        villageDao.update(item);
    }

    public void delete(Village item) {
        villageDao.delete(item);
    }

    public Village findById(long id) {
        return villageDao.findById(id);
    }

    public List<Village> findAll() {
        return villageDao.findAll();
    }
}
