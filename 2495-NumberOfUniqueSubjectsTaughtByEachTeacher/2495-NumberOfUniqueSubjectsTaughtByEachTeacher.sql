-- Last updated: 7/12/2026, 11:13:53 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
select teacher_id, count(distinct subject_id) as cnt
from teacher
group by teacher_id