

INSERT INTO user (created_at, status, updated_at, bio, name, user_permission, content) VALUES ('2023-11-01 20:12:32.000000', 'ACTIVE', '2023-11-01 22:48:45.426958', '안녕하세요! 매일 성장하는 개발자 홍길동 입니다.방문해주셔서 감사합니다.', '홍길동', 'ADMIN', '안녕하세요 반갑습니다. ㅎㅎ ');

INSERT INTO skills (name, skill_level, user_id) VALUES ('JAVA', 'LANGUAGES', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('Spring Boot', 'PROFESSIONAL', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('Node.js', 'PROFESSIONAL', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('Python', 'LANGUAGES', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('AWS(EC2)', 'PROFESSIONAL', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('AWS(RDS)', 'PROFESSIONAL', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('JavaScript', 'LANGUAGES', 1);
INSERT INTO skills (name, skill_level, user_id) VALUES ('Notion', 'PROFESSIONAL', 1);

INSERT INTO project (created_at, status, updated_at, content, name, end_day, start_day, link) VALUES ('2023-11-01 22:21:46.000000', 'ACTIVE', '2023-11-01 22:21:52.000000', '도커 CI 파이프라인 구축 프로젝트', '도커 프로젝트', '2024-3-01', '2024-06-01', 'https://github.com/hosung-222/docker-ci');

INSERT INTO experience (created_at, status, updated_at, content, name, place, time_line, resume) VALUES ('2023-11-15 15:41:42.000000', 'ACTIVE', '2023-11-15 15:41:40.000000', '00대학교 컴퓨터 공학과 학부생', '00대학교', '00.univ', '2019.03.~', 'EDUCATION');

INSERT INTO contact (email, message, name, phone) VALUES ('johndoe@example.com', 'This is a test message.', 'John Doe', '(123) 456-7890');
