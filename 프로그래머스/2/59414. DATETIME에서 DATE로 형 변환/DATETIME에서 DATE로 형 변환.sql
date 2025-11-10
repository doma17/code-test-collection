-- 코드를 입력하세요
SELECT
    i.ANIMAL_ID,
    i.NAME,
    DATE_FORMAT(i.DATETIME, '%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS i
ORDER BY i.ANIMAL_ID;