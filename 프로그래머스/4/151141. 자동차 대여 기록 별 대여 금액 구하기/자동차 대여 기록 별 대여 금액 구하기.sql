WITH RentalDays AS (
    SELECT
        R.HISTORY_ID,
        R.CAR_ID,
        DATEDIFF(R.END_DATE, R.START_DATE) + 1 AS DAYS
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY R
),
TruckRentals AS (
    -- 1) '트럭'만 필터링하고 일수 CTE 조인
    SELECT
        RD.HISTORY_ID,
        C.DAILY_FEE,
        RD.DAYS
    FROM
        RentalDays RD
        JOIN CAR_RENTAL_COMPANY_CAR C
          ON RD.CAR_ID = C.CAR_ID
    WHERE
        C.CAR_TYPE = '트럭'
),
Discounted AS (
    -- 2) 기간별 할인율 매칭
    SELECT
        T.HISTORY_ID,
        T.DAILY_FEE,
        T.DAYS,
        COALESCE(DP.DISCOUNT_RATE, 0) AS DISCOUNT_RATE
    FROM
        TruckRentals T
        LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP
          ON DP.CAR_TYPE = '트럭'
         AND DP.DURATION_TYPE = CASE
             WHEN T.DAYS >= 90 THEN '90일 이상'
             WHEN T.DAYS >= 30 THEN '30일 이상'
             WHEN T.DAYS >= 7  THEN '7일 이상'
             ELSE NULL
           END
)
-- 3) 최종 요금 계산 및 정렬
SELECT
    HISTORY_ID,
    FLOOR( DAILY_FEE * DAYS * (100 - DISCOUNT_RATE) / 100 ) AS FEE
FROM
    Discounted
ORDER BY
    FEE DESC,
    HISTORY_ID DESC;
