SELECT 
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    B.CATEGORY,
    SUM(BS.SALES * B.PRICE) AS TOTAL_SALES
FROM BOOK_SALES BS 
    LEFT JOIN BOOK B ON BS.BOOK_ID = B.BOOK_ID
    LEFT JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE DATE_FORMAT(BS.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY A.AUTHOR_ID, B.CATEGORY 
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC