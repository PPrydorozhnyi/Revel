package com.meetup.revel.security.authorization;

import com.meetup.revel.dao.ItemCommentDao;
import com.meetup.revel.entity.ItemComment;
import com.meetup.revel.entity.User;
import com.meetup.revel.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "itemCommentPermissionChecker")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemCommentPermissionChecker {

    private static Logger log = LoggerFactory.getLogger(ItemCommentPermissionChecker.class);

    private final ItemCommentDao itemCommentDao;

    private final AuthenticationFacade authenticationFacade;

    public boolean canDeleteItemComment(int commentId) {

        boolean permission = checkPermission(commentId);

        log.info("Delete permission is '{}'", permission);

        return permission;
    }

    private boolean checkPermission(int commentId) {
        log.debug("Check permission for delete comment with id '{}'", commentId);

        log.debug("Try to get auth user");
        User user = authenticationFacade.getAuthentication();

        log.debug("Try to get itemComment for permission");
        ItemComment itemComment = itemCommentDao.findById(commentId);

        return itemComment.getAuthorId() == user.getId();

    }
}
