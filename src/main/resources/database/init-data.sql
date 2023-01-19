INSERT INTO injection.users(id, username, password, name, surname, token, role)
    VALUES (1, 'admin1', 'admin1!', 'Admin', 'User', md5('admin1'), 'admin');
INSERT INTO injection.users(id, username, password, name, surname, token, role)
    VALUES (2, 'user1', 'user1!', 'Test', 'User', md5('user1'), 'user');
INSERT INTO injection.users(id, username, password, name, surname, token, role)
    VALUES (3, 'user2', 'user2!', 'Test2', 'User', md5('user2'), 'user');

