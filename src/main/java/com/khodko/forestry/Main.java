package com.khodko.forestry;

import com.khodko.forestry.dao.BaseDao;
import com.khodko.forestry.dao.VillageDao;
import com.khodko.forestry.entity.Village;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");


        VillageDao dao = new VillageDao();
        Village village = new Village();
        village.setName("Vil");
        dao.findAll();

    }
}
