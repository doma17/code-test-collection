SELECT i.ANIMAL_ID, i.NAME, I.SEX_UPON_INTAKE
FROM ANIMAL_INS i
WHERE i.NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY 1;