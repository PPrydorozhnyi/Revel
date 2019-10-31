insert into rv_periodicity(PERIODICITY_NAME) values('hour');
INSERT INTO rv_periodicity(periodicity_name) VALUES('DAY');
INSERT INTO rv_periodicity(periodicity_name) VALUES('WEEK');
INSERT INTO rv_periodicity(periodicity_name) VALUES('MONTH');
INSERT INTO rv_periodicity(periodicity_name) VALUES('YEAR');
INSERT INTO rv_periodicity(periodicity_name) VALUES('ONCE');

INSERT INTO rv_event_type(type) VALUES('EVENT');
INSERT INTO rv_event_type(type) VALUES('NOTE');
INSERT INTO rv_event_type(type) VALUES('PRIVATE_EVENT');

INSERT INTO rv_role(name) VALUES('OWNER');
INSERT INTO rv_role(name) VALUES('PARTICIPANT');

INSERT INTO rv_priority(name) VALUES ('URGENT');
INSERT INTO rv_priority(name) VALUES ('NORMAL');
INSERT INTO rv_priority(name) VALUES ('LOW');

INSERT INTO rv_chat_type(type) VALUES('WITH_OWNER');
INSERT INTO rv_chat_type(type) VALUES('WITHOUT_OWNER');
