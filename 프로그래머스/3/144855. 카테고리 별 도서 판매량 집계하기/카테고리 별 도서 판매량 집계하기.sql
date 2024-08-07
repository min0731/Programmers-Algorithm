-- 1월의 카테고리별 도서 판매량 합산  (판매일 기준: 1월 )
-- 카테고리명으로 오름차순

SELECT B.CATEGORY,SUM(S.SALES) as TOTAL_SALES
FROM BOOK B JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
WHERE S.SALES_DATE >= '2022-01-01' AND S.SALES_DATE <= '2022-01-31'
group by B.CATEGORY
ORDER BY B.CATEGORY