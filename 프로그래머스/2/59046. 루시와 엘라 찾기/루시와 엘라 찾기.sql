-- 루시, 엘라 뭐시기뭐시기
-- 아이디 이름 성별 및 중성화

SELECT  ANIMAL_ID, NAME, SEX_UPON_INTAKE
from ANIMAL_INS
where NAME in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')