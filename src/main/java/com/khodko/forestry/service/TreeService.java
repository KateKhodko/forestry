package com.khodko.forestry.service;

import com.khodko.forestry.dao.TreeDao;
import com.khodko.forestry.entity.Tree;

import java.io.Serializable;
import java.util.List;

public class TreeService {

    private final TreeDao treeKindService = new TreeDao();

    public TreeService() {
    }

    public Serializable save(Tree item) {
        return treeKindService.save(item);
    }

    public void update(Tree item) {
        treeKindService.update(item);
    }

    public void delete(Tree item) {
        treeKindService.delete(item);
    }

    public Tree findById(long id) {
        return treeKindService.findById(id);
    }

    public List<Tree> findAll() {
        return treeKindService.findAll();
    }
}
