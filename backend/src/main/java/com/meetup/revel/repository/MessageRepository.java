package com.meetup.revel.repository;

import com.meetup.revel.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("select versionId from CampaignActivityPeriod per where ?1 between per.startDate and per.endDate")
    List<Message> findMessagesByChatId(Integer chatId);
}
