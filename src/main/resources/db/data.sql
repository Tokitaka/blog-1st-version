INSERT INTO user_tb(username, password, email, created_at) values('ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb(username, password, email, created_at) values('love', '1234', 'love@nate.com', now());

INSERT INTO board_tb(title, content, user_id, created_at) values('1번째 제목', '1번째 내용', 1, now());
INSERT INTO board_tb(title, content, user_id, created_at) values('2번째 제목', '2번째 내용', 1, now());
INSERT INTO board_tb(title, content, user_id, created_at) values('3번째 제목', '3번째 내용', 1, now());
INSERT INTO board_tb(title, content, user_id, created_at) values('4번째 제목', '4번째 내용', 2, now());
INSERT INTO board_tb(title, content, user_id, created_at) values('5번째 제목', '5번째 내용', 2, now());
INSERT INTO board_tb(title, content, user_id, created_at) values('6번째 제목', '6번째 내용', 2, now());

commit;