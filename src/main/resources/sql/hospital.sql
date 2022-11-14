/*
경기도 수원시에 있는 피부과를 모두 찾아보세요
 */
SELECT * FROM `likelion-db`.national_hospitals
         where road_name_address LIKE '경기도 수원시%' AND hospital_name LIKE '%피부과%';
/*
특정 구의 - 보건진료소, 보건지소, 보건소 모두 찾기
*/
SELECT * FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소', '보건진료소')
  and road_name_address like '%광진구%';