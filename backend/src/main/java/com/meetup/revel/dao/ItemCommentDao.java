package com.meetup.revel.dao;

import com.meetup.revel.entity.ItemComment;

import java.util.List;

public interface ItemCommentDao extends Dao<ItemComment> {
    List<ItemComment> getCommentsForItemId(int id);
}
