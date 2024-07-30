-- 대장균 크기 100이하 : low , 100초과 1000이하면 medium, 1000초과면 high 


select id,
CASE 
WHEN SIZE_OF_COLONY between 0 and 100 THEN 'LOW'
WHEN SIZE_OF_COLONY between 101 AND 1000 THEN 'MEDIUM'
ELSE'HIGH' 
END AS SIZE
from ECOLI_DATA
ORDER BY ID