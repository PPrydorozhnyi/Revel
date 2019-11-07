ALTER TABLE rv_item_comment ADD CONSTRAINT item_comment_user_id_fk FOREIGN KEY (author_id) REFERENCES rv_user(user_id);
ALTER TABLE rv_item_comment ADD CONSTRAINT item_comment_item_id_fk FOREIGN KEY (item_id) REFERENCES rv_item(item_id) ON DELETE CASCADE;

ALTER TABLE rv_user_item ADD CONSTRAINT u_item_fk_booker FOREIGN KEY(id_who_booked) REFERENCES rv_user(user_id);

ALTER TABLE rv_user_item ADD CONSTRAINT u_item_fk_user FOREIGN KEY(user_id) REFERENCES rv_user(user_id);
ALTER TABLE rv_user_item ADD CONSTRAINT u_item_fk_item FOREIGN KEY(item_id) REFERENCES rv_item(item_id);

ALTER TABLE rv_like ADD CONSTRAINT like_fk_item FOREIGN KEY(item_id) REFERENCES rv_item(item_id) ON DELETE CASCADE;
ALTER TABLE rv_like ADD CONSTRAINT like_fk_user FOREIGN KEY(user_id) REFERENCES rv_user(user_id);

ALTER TABLE rv_friend ADD CONSTRAINT friend_fk_user_s FOREIGN KEY(sender_id) REFERENCES rv_user(user_id);
ALTER TABLE rv_friend ADD CONSTRAINT friend_fk_user_r FOREIGN KEY(receiver_id) REFERENCES rv_user(user_id);

ALTER TABLE rv_user_event ADD CONSTRAINT u_event_fk_user FOREIGN KEY(user_id) REFERENCES rv_user(user_id);
ALTER TABLE rv_user_event ADD CONSTRAINT u_event_fk_event FOREIGN KEY(event_id) REFERENCES rv_event(event_id);

ALTER TABLE rv_folder ADD CONSTRAINT folder_fk_user FOREIGN KEY(user_id) REFERENCES rv_user(user_id);

ALTER TABLE rv_event ADD CONSTRAINT event_fk_folder FOREIGN KEY(folder_id) REFERENCES rv_folder(folder_id);

ALTER TABLE rv_message ADD CONSTRAINT message_fk_user FOREIGN KEY(chat_id) REFERENCES rv_chat(chat_id);
ALTER TABLE rv_message ADD CONSTRAINT message_fk_chat FOREIGN KEY(sender_id) REFERENCES rv_user(user_id);

ALTER TABLE rv_chat ADD CONSTRAINT chat_fk_event FOREIGN KEY(event_id) REFERENCES rv_event(event_id);

ALTER TABLE rv_tag_item ADD CONSTRAINT tag_item_fk_tag FOREIGN KEY (tag_id) REFERENCES rv_tag(tag_id);
ALTER TABLE rv_tag_item ADD CONSTRAINT tag_item_fk_item FOREIGN KEY (item_id) REFERENCES rv_item(item_id) ON DELETE CASCADE;
