
SELECT MONTH(a.START_DATE) AS MONTH, a.CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
JOIN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01' AND START_DATE <= '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
) b ON a.CAR_ID = b.CAR_ID
WHERE a.START_DATE >= '2022-08-01' AND a.START_DATE <= '2022-10-31'
GROUP BY MONTH(a.START_DATE), a.CAR_ID
ORDER BY MONTH(a.START_DATE), a.CAR_ID DESC;