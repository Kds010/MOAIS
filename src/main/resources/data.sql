INSERT INTO USERS (ID, NICKNAME, PASSWORD, USER_ID) VALUES (default, 'ho', '123', 'kds');
INSERT INTO USERS (ID, NICKNAME, PASSWORD, USER_ID) VALUES (default, 'ho2', '222', 'kds2');

INSERT INTO AUTHORITY (AUTHORITY_NAME) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (AUTHORITY_NAME) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (1, 'ROLE_USER');
INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (1, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (ID, AUTHORITY_NAME) VALUES (2, 'ROLE_USER');