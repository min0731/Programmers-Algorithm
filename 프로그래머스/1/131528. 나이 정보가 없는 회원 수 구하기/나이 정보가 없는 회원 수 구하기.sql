-- 나이정보가 없는 회원이 몇명인지
SELECT count(*) as users
from USER_INFO
where age is null 