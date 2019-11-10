package com.meetup.revel.dao.rowMappers;

import com.meetup.revel.entity.MessageDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static com.meetup.revel.keys.Key.*;

public class MessageRowMapper implements RowMapper<MessageDTO> {
    @Override
    public MessageDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setMessageId(resultSet.getInt(MESSAGE_MESSAGE_ID));
        messageDTO.setSenderId(resultSet.getInt(MESSAGE_SENDER_ID));
        messageDTO.setChatId(resultSet.getInt(MESSAGE_CHAT_ID));
        messageDTO.setText(resultSet.getString(MESSAGE_TEXT));
        messageDTO.setSenderLogin(resultSet.getString(MESSAGE_SENDER_LOGIN));
        Timestamp date = resultSet.getTimestamp(MESSAGE_MESSAGE_DATE);
        messageDTO.setMessageDate(date == null ? null : date.toString());

        return messageDTO;
    }

    public static Map<String, Object> paramsMapper(MessageDTO messageDTO) {
        Map<String, Object> paramsMapper = new HashMap<>();
        paramsMapper.put(MESSAGE_MESSAGE_ID, messageDTO.getMessageId());
        paramsMapper.put(MESSAGE_SENDER_ID, messageDTO.getSenderId());
        paramsMapper.put(MESSAGE_CHAT_ID, messageDTO.getChatId());
        paramsMapper.put(MESSAGE_TEXT, messageDTO.getText());
        paramsMapper.put(MESSAGE_MESSAGE_DATE, (messageDTO.getMessageDate() != null ? Timestamp.valueOf(messageDTO.getMessageDate()) : null));
        return paramsMapper;
    }
}
