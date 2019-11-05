package com.meetup.revel.dao.rowMappers;

import com.meetup.revel.entity.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.meetup.revel.keys.Key.*;

public class ItemRowMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setItemId(resultSet.getInt(ITEM_ITEM_ID));
        item.setName(resultSet.getString(ITEM_NAME));
        item.setDescription(resultSet.getString(ITEM_DESCRIPTION));
        item.setImageFilepath(resultSet.getString(ITEM_IMAGE_FILEPATH));
        item.setLink(resultSet.getString(ITEM_LINK));
        item.setLikes(resultSet.getInt(ITEM_LIKES));
        return item;
    }
}
