-- hogwarts_db 데이터베이스 생성
CREATE DATABASE hogwarts_db
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
  -- hogwarts_db 데이터베이스는 모든 문자열을 utf8mb4로 저장하고, 유니코드 기준으로 정렬하며, 대소문자는 구분하지 않는다

-- 사용자 hat 생성 및 권한 부여
CREATE USER 'hat'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON hogwarts_db.* TO 'hat'@'localhost';

FLUSH PRIVILEGES;

-- house 테이블 생성
USE hogwarts_db;

CREATE TABLE house (
    house_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    mascot TEXT
);

-- student 테이블 생성
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    grade INT CHECK (grade BETWEEN 1 AND 7),
    gender VARCHAR(10) CHECK (gender IN ('남자', '여자')),
    house_id INT,
    FOREIGN KEY (house_id) REFERENCES house(house_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- house 테이블 더미 데이터
INSERT INTO house (house_id, name, description, mascot)
VALUES
    (1, '그리핀도르', '용기, 대담함, 결단력, 기사도', '사자'),
    (2, '슬리데린', '야망, 교활함, 지도력, 자원 활용', '뱀'),
    (3, '레번클로', '지능, 창의성, 학습, 재치', '독수리'),
    (4, '후플푸프', '근면, 인내, 충성심, 공정함', '오소리');

-- student 테이블 더미 데이터
INSERT INTO student (name, grade, gender, house_id)
VALUES
    ('해리 포터', 5, '남자', 1),
    ('헤르미온느 그레인저', 6, '여자', 1),
    ('네빌 롱바텀', 4, '남자', 1),

    ('드레이코 말포이', 5, '남자', 2),
    ('팬지 파킨슨', 6, '여자', 2),
    ('블레이즈 자비니', 4, '남자', 2),

    ('루나 러브굿', 4, '여자', 3),
    ('초 챙', 6, '여자', 3),
    ('테리 부트', 3, '남자', 3),

    ('세드릭 디고리', 7, '남자', 4);

-- 학생 테이블 전체 삭제 (id 자동 증가값도 초기화하고 싶다면 TRUNCATE 사용)
TRUNCATE TABLE student;

-- 연결 테스트
SELECT s.id, s.name, h.name AS house_name
FROM student s
LEFT JOIN house h ON s.house_id = h.house_id;