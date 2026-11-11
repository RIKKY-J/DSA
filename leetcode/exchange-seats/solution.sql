# Write your MySQL query statement below
select 
    case
        when 
            id = (select max(id) from Seat) AND MOD(id, 2) = 1
            THEN id
        when
            MOD(id, 2) = 1
            THEN id+1
        ELSE
            id-1
    END as id , student
from Seat
order by id