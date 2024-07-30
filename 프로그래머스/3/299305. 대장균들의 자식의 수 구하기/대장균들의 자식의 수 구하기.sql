-- 대장균 개체의 아이디와 잣힉의 수를 출려
-- 자식 없으면 자식 수는 0으로 출력 
-- 개체 id에 대해 오름차순 정렬 


SELECT E.ID, ifnull(C.COUNT, 0) as CHILD_COUNT
FROM 
    ECOLI_DATA E
LEFT JOIN 
    (SELECT 
         PARENT_ID, 
         COUNT(ID) AS COUNT
     FROM 
         ECOLI_DATA
     GROUP BY 
         PARENT_ID) C
ON 
    E.ID = C.PARENT_ID
order by id