
CREATE TYPE rv_periodicity as ENUM (
    'HOUR', 'DAY', 'WEEK', 'MONTH', 'YEAR', 'ONCE'
);

CREATE TYPE rv_event_type as ENUM (
    'EVENT', 'NOTE', 'PRIVATE_EVENT'
);

CREATE TYPE rv_role as ENUM (
    'OWNER', 'PARTICIPANT'
);

CREATE TYPE rv_priority as ENUM (
    'URGENT', 'NORMAL', 'LOW'
);

CREATE TYPE rv_chat_type as ENUM (
    'WITH_OWNER', 'WITHOUT_OWNER'
);

CREATE TABLE rv_user (
  user_id SERIAL PRIMARY KEY,
  login VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NULL,
  name VARCHAR(254) NOT NULL,
  last_name VARCHAR(254) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  time_zone INTEGER,
  image_filepath VARCHAR(200),
  birthday TIMESTAMP ,
  phone VARCHAR(25),
  pinned_event_id INTEGER,
  periodical_email VARCHAR(100),
  register_date TIMESTAMP
);

CREATE TABLE rv_user_item (
  user_id INTEGER NOT NULL,
  item_id INTEGER NOT NULL,
  id_who_booked INTEGER,
  priority rv_priority,
  due_date TIMESTAMP NOT NULL,
  UNIQUE (user_id, item_id)
);

CREATE TABLE rv_like (
  like_id SERIAL PRIMARY KEY,
  item_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  UNIQUE (item_id, user_id)
);

CREATE TABLE rv_item (
  item_id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(1023),
  image_filepath VARCHAR(200) NOT NULL,
  link VARCHAR(200)
);

CREATE TABLE rv_tag_item (
  tag_id INTEGER NOT NULL,
  item_id INTEGER NOT NULL,
  UNIQUE (tag_id, item_id)
);

CREATE TABLE rv_tag (
  tag_id SERIAL PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE rv_friend (
  sender_id INTEGER NOT NULL,
  receiver_id INTEGER NOT NULL,
  is_Confirmed BOOLEAN  NOT NULL,
  UNIQUE (sender_id, receiver_id)
);

CREATE TABLE rv_user_event (
  user_id INTEGER NOT NULL,
  event_id INTEGER NOT NULL,
  role rv_role NOT NULL,
  UNIQUE (user_id, event_id)
);

CREATE TABLE rv_folder (
  folder_id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  user_id INTEGER NOT NULL
);

CREATE TABLE rv_event (
  event_id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  event_date timestamp,
  description VARCHAR(1023),
  periodicity rv_periodicity,
  place VARCHAR(100),
  event_type rv_event_type NOT NULL,
  is_draft BOOLEAN NOT NULL,
  folder_id INTEGER NOT NULL,
  image_filepath VARCHAR(255) NOT NULL
);

CREATE TABLE rv_message (
  message_id SERIAL PRIMARY KEY,
  sender_id INTEGER NOT NULL,
  text VARCHAR(250) NOT NULL,
  message_date TIMESTAMP NOT NULL,
  chat_id INTEGER NOT NULL
);


CREATE TABLE rv_chat (
  chat_id SERIAL PRIMARY KEY,
  chat_type rv_chat_type NOT NULL,
  event_id INTEGER NOT NULL
);

CREATE TABLE rv_item_comment (
  comment_id SERIAL PRIMARY KEY,
  body_text VARCHAR(2000) NOT NULL,
  post_time TIMESTAMP NOT NULL,
  author_id INTEGER NOT NULL,
  item_id INTEGER NOT NULL
);
