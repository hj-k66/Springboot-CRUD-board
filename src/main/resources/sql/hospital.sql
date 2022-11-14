/*
경기도 수원시에 있는 피부과를 모두 찾아보세요
 */
SELECT * FROM `likelion-db`.national_hospitals
         where road_name_address LIKE '경기도 수원시%' AND hospital_name LIKE '%피부과%';