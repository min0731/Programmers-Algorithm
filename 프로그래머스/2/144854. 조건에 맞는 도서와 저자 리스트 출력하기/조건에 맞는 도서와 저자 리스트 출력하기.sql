-- 출판일로 오름차순
-- 경제 카테고리에 속하는 도서, 저자명, 출판일
SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE,'%Y-%m-%d')
FROM BOOK B JOIN AUTHOR A ON B.AUTHOR_ID=A.AUTHOR_ID
WHERE B.CATEGORY LIKE '경제'
ORDER BY PUBLISHED_DATE