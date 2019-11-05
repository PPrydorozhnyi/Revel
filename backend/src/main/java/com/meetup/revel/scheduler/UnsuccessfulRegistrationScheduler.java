package com.meetup.revel.scheduler;

import com.meetup.revel.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UnsuccessfulRegistrationScheduler {

    private static final Logger log = LoggerFactory.getLogger(UnsuccessfulRegistrationScheduler.class);

    private final UserDao userDao;

    @Scheduled(cron="${cron.daily}")
    public void changeEventDate() {
        log.debug("Try to delete unconfirmed users from dao");

        int count = userDao.deleteUnconfirmedAccounts();

        log.debug("Successfully deleted {} accounts", count);
    }

}
