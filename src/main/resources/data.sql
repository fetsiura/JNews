INSERT INTO Role (role_id, role) VALUES (1, 'ROLE_USER');
INSERT INTO Role (role_id, role) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER (id, login,email,password,enabled) VALUES (1, 'linuxgt','linuxgt@gmail.com','$2a$12$64Qtds/2pEUfR8TIbSHWtunZtYQAxm51UBd6Pp026L3cQTNg/8BRi',1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO USER (id, login,email,password,enabled) VALUES (2, 'jaro','jaro@gmail.com','$2a$12$64Qtds/2pEUfR8TIbSHWtunZtYQAxm51UBd6Pp026L3cQTNg/8BRi',1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);