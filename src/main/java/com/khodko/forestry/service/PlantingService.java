package com.khodko.forestry.service;

import com.khodko.forestry.dao.PlantingDao;
import com.khodko.forestry.entity.Planting;

import java.io.Serializable;
import java.util.List;

public class PlantingService {

    private final PlantingDao plantingDao = new PlantingDao();

    public PlantingService() {
    }

    public Serializable save(Planting item) {
        return plantingDao.save(item);
    }

    public void update(Planting item) {
        plantingDao.update(item);
    }

    public void delete(Planting item) {
        plantingDao.delete(item);
    }

    public Planting findById(long id) {
        return plantingDao.findById(id);
    }

    public List<Planting> findAll() {
        return plantingDao.findAll();
    }
}
