package com.meetup.revel.dao;

import com.meetup.revel.entity.Folder;

import java.util.List;


public interface FolderDao extends Dao<Folder> {

    Folder findById(int id, int userId);

    List<Folder> getUserFolders(int id);

    void moveEventsToGeneral(int id);

}
