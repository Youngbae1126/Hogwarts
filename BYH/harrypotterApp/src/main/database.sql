DROP TABLE IF EXISTS house;
DROP TABLE IF EXISTS student;

-- house 테이블

-- 컬럼
-- house_id PK, INT
-- name 기숙사명
-- description 기숙사 특징 설명
-- mascot 기숙사 마스코트

CREATE TABLE house (
                       house_id INT PRIMARY KEY ,
                       name VARCHAR(50) NOT NULL ,
                       description TEXT ,
                       mascot TEXT
);

-- house 테이블 더미 데이터
INSERT INTO house (house_id, name, description, mascot)
VALUES
    (1, '그리핀도르', '용기, 대담함, 결단력, 기사도', '사자'),
    (2, '슬리데린', '야망, 교활함, 지도력, 자원 활용', '뱀'),
    (3, '레번클로', '지능, 창의성, 학습, 재치', '독수리'),
    (4, '후플푸프', '근면, 인내, 충성심, 공정함', '오소리');



-- student 테이블

-- 컬럼
-- id 학생 아이디, PK, INT, AUTO_INCREMENT
-- name 학생 이름
-- grade 학년
-- gender 성별
-- house_id 기숙사 아이디

CREATE TABLE student
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(50) NOT NULL,
    grade    INT CHECK ( grade BETWEEN 1 AND 7 ),
    gender   VARCHAR(10) CHECK ( gender IN ('Male', 'Female')),
    house_id INT NOT NULL DEFAULT 1,
    FOREIGN KEY (house_id) REFERENCES house (house_id)
        ON DELETE RESTRICT  # 다른 테이블에서 참조하고 있으니 삭제하지 못하도록 막아둠
        ON UPDATE CASCADE   # 다른 테이블에서 변경사항이 일어나면 자동으로 같이 변경됨
);

-- student 테이블 더미 데이터
INSERT INTO student (id, name, grade, gender, house_id)
VALUES
    (null, '해리 포터', 5, 'Male', 1),         -- Gryffindor
    (null, '헤르미온느 그레인저', 6, 'Female', 1),
    (null, '네빌 롱바텀', 4, 'Male', 1),

    (null, '드레이코 말포이', 5, 'Male', 2),     -- Slytherin
    (null, '팬지 파킨슨', 6, 'Female', 2),
    (null, '블레이즈 자비니', 4, 'Male', 2),

    (null, '루나 러브굿', 4, 'Female', 3),       -- Ravenclaw
    (null, '초 챙', 6, 'Female', 3),
    (null, '테리 부트', 3, 'Male', 3),

    (null, '세드릭 디고리', 7, 'Male', 4);       -- Hufflepuff

-- 데이터 삭제
DELETE FROM student;

-- AUTO_INCREMENT 초기화
ALTER TABLE student AUTO_INCREMENT = 1;

SELECT * FROM student