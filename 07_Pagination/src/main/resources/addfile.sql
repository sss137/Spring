#page = 1
SELECT uid, first_name, last_name, email, gender, ip_address
  FROM tbl_user
 ORDER BY uid DESC
 LIMIT 0, 20;

#page = 2 
SELECT uid, first_name, last_name, email, gender, ip_address
  FROM tbl_user
 ORDER BY uid DESC
 LIMIT 20, 20;
 
 #page = 3 
SELECT uid, first_name, last_name, email, gender, ip_address
  FROM tbl_user
 ORDER BY uid DESC
 LIMIT 40, 20;
 
 