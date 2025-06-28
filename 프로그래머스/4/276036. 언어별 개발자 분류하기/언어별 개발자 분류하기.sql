SELECT
    CASE
        WHEN SKILL_CODE & (SELECT SUM(CODE)
                           FROM SKILLCODES
                           WHERE CATEGORY LIKE 'Front End')
             AND SKILL_CODE & (SELECT CODE
                           FROM SKILLCODES
                           WHERE NAME = 'Python') THEN 'A'
        WHEN SKILL_CODE & (SELECT CODE
                           FROM SKILLCODES
                           WHERE NAME = 'C#') THEN 'B'
        WHEN SKILL_CODE & (SELECT SUM(CODE)
                           FROM SKILLCODES
                           WHERE CATEGORY LIKE 'Front End') THEN 'C'
        ELSE NULL
    END AS 'GRADE',
    ID,
    EMAIL
FROM DEVELOPERS D
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID