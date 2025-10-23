WITH RECURSIVE CTE AS (
    SELECT 
        ID,
        PARENT_ID,
        1 AS 'LEVEL'
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT 
        e.ID,
        e.PARENT_ID,
        CTE.LEVEL + 1
    FROM ECOLI_DATA e
    INNER JOIN CTE ON e.PARENT_ID = CTE.ID
)

SELECT ID
FROM CTE
WHERE LEVEL = 3















# WITH RECURSIVE CTE AS (
#     SELECT 
#         ID,
#         PARENT_ID,
#         1 AS LEVEL
#     FROM ECOLI_DATA
#     WHERE PARENT_ID IS NULL
    
#     UNION ALL
    
#     SELECT 
#         A.ID,
#         A.PARENT_ID,
#         CTE.LEVEL + 1
#     FROM ECOLI_DATA A INNER JOIN CTE
#     ON A.PARENT_ID = CTE.ID
# )
# SELECT ID
# FROM CTE
# WHERE LEVEL = 3