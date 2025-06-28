SELECT
    A.EMP_NO,
    A.EMP_NAME,
    B.GRADE,
    CASE
        WHEN B.GRADE = 'S' THEN A.SAL * 0.2
        WHEN B.GRADE = 'A' THEN A.SAL * 0.15
        WHEN B.GRADE = 'B' THEN A.SAL * 0.1
        ELSE 0
    END AS 'BONUS'
FROM HR_EMPLOYEES A LEFT JOIN (SELECT 
                                EMP_NO,
                                CASE 
                                    WHEN AVG(SCORE) >= 96 THEN 'S'
                                    WHEN AVG(SCORE) >= 90 THEN 'A'
                                    WHEN AVG(SCORE) >= 80 THEN 'B'
                                    ELSE 'C'
                                END AS GRADE
                            FROM HR_GRADE
                            GROUP BY EMP_NO) B
    ON A.EMP_NO = B.EMP_NO
ORDER BY A.EMP_NO