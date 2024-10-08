INSERT INTO users (idx, username, age, email, password, wdate, role)
VALUES (1, 'Red', 25, 'red@example.com', '$2a$10$cUVnZQldXFb3J5EE97cMBev4fN9ipRNW2h0uS0vV0TDB.iesMnU6O', '2024-09-24 10:00:00', 'ROLE_ADMIN');
INSERT INTO users (idx, username, age, email, password, wdate, role)
VALUES (2, 'Blue', 30, 'blue@example.com', '$2a$10$cUVnZQldXFb3J5EE97cMBev4fN9ipRNW2h0uS0vV0TDB.iesMnU6O', '2024-09-24 10:00:00', 'ROLE_ADMIN');
INSERT INTO users (idx, username, age, email, password, wdate, role)
VALUES (3, 'Green', 22, 'green@example.com', '$2a$10$cUVnZQldXFb3J5EE97cMBev4fN9ipRNW2h0uS0vV0TDB.iesMnU6O', '2024-09-24 10:00:00', 'ROLE_ADMIN');
INSERT INTO users (idx, username, age, email, password, wdate, role)
VALUES (4, 'Yellow', 28, 'yellow@example.com', '$2a$10$cUVnZQldXFb3J5EE97cMBev4fN9ipRNW2h0uS0vV0TDB.iesMnU6O', '2024-09-24 10:00:00', 'ROLE_ADMIN');
INSERT INTO users (idx, username, age, email, password, wdate, role)
VALUES (5, 'Purple', 35, 'purple@example.com', '$2a$10$cUVnZQldXFb3J5EE97cMBev4fN9ipRNW2h0uS0vV0TDB.iesMnU6O', '2024-09-24 10:00:00', 'ROLE_ADMIN');

INSERT INTO freeboard (idx, title, content, user_idx, cre_author, mod_author, reg_date, mod_date, view_count)
VALUES (1, 'First Title', 'This is the first content.', 1, 'Author1', 'Modifier1', '2024-09-24 10:00:00', '2024-09-24 10:00:00', 0);
INSERT INTO freeboard (idx, title, content, user_idx, cre_author, mod_author, reg_date, mod_date, view_count)
VALUES (2, 'Second Title', 'This is the second content.', 2, 'Author2', 'Modifier2', '2024-09-23 09:00:00', '2024-09-23 09:00:00', 5);
INSERT INTO freeboard (idx, title, content, user_idx, cre_author, mod_author, reg_date, mod_date, view_count)
VALUES (3, 'Third Title', 'This is the third content.', 3, 'Author3', 'Modifier3', '2024-09-22 08:30:00', '2024-09-23 08:45:00', 10);
INSERT INTO freeboard (idx, title, content, user_idx, cre_author, mod_author, reg_date, mod_date, view_count)
VALUES (4, 'Fourth Title', 'This is the fourth content.', 4, 'Author4', 'Modifier4', '2024-09-21 07:45:00', '2024-09-21 08:15:00', 20);
INSERT INTO freeboard (idx, title, content, user_idx, cre_author, mod_author, reg_date, mod_date, view_count)
VALUES (5, 'Fifth Title', 'This is the fifth content.', 5, 'Author5', 'Modifier5', '2024-09-20 07:00:00', '2024-09-20 07:30:00', 50);

INSERT INTO freeboard_files (`free_board_idx`, `idx`, `file_desc`, `name`) VALUES (5, 1, '이미지파일', 'aa.jpg');