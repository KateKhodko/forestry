package com.khodko.forestry.service;

import com.khodko.forestry.dao.TreeKindDao;
import com.khodko.forestry.entity.TreeKind;

import java.io.Serializable;
import java.util.List;

public class TreeKindService {

    private final TreeKindDao treeKindService = new TreeKindDao();

    public TreeKindService() {
    }

    public Serializable save(TreeKind item) {
        return treeKindService.save(item);
    }

    public void update(TreeKind item) {
        treeKindService.update(item);
    }

    public void delete(TreeKind item) {
        treeKindService.delete(item);
    }

    public TreeKind findById(long id) {
        return treeKindService.findById(id);
    }

    public List<TreeKind> findAll() {
        return treeKindService.findAll();
    }

}
