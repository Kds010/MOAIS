INSERT INTO USERS (ID, NICKNAME, PASSWORD, USER_ID) VALUES (default, 'ho', '{bcrypt}$2a$10$p7FqM8M3vVVmaKpQo.JCkO8eIEsd/xSNcZPJfFspBdp5JJPhczJ8K', 'kds');
INSERT INTO USERS (ID, NICKNAME, PASSWORD, USER_ID) VALUES (default, 'ho2', '{bcrypt}$2a$10$/0G052u0wXdjuvCy2aAfWeyrxl24dgEeg7q5yS4MkaYejVbeUh5Pm', 'kds2');
INSERT INTO USERS (ID, NICKNAME, PASSWORD, USER_ID) VALUES (default, 'ho6', '{bcrypt}$2a$10$ilVpWd2yVZDCXDiJhLeW5eYmTc6PbfRUdvvxD8vEAH1xQ5hq2TgLy', 'kds6');

INSERT INTO AUTHORITY (AUTHORITY_NAME) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (AUTHORITY_NAME) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (1, 'ROLE_USER');
INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (1, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (2, 'ROLE_USER');

INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (3, 'ROLE_USER');

INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 1, '2024-05-02');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 2, '2024-05-05');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 0, '2024-05-06');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 3, '2024-05-12');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 2, '2024-05-11');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 0, '2024-05-07');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 1, '2024-05-13');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 1, '2024-05-09');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 0, '2024-05-01');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 2, '2024-05-15');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 0, '2024-05-24');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 1, '2024-05-23');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 0, '2024-05-26');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 3, '2024-05-21');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 0, '2024-05-18');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 2, '2024-05-22');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 0, '2024-05-19');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 1, '2024-05-20');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 0, '2024-05-10');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 2, 'test1', 1, '2024-05-08');
INSERT INTO TODO (ID, USER_ID, CONTENT, STATE, PROCEED_DATE) VALUES (default, 1, 'test1', 1, '2024-05-09');
