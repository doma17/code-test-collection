SELECT
    i.ANIMAL_ID,
    i.NAME,
    CASE 
        WHEN i.SEX_UPON_INTAKE LIKE '%Neutered%' THEN 'O'
        WHEN i.SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
    END AS '중성화'
FROM ANIMAL_INS i
ORDER BY 1;