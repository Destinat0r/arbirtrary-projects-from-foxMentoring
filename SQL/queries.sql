SELECT name, COUNT(students.id) AS number_of_students 
  FROM groups 
    RIGHT JOIN students ON groups.id = students.group_id 
GROUP BY name 
HAVING COUNT(students.id) < 10;

DELETE FROM students 
  WHERE students.group_id = (
	SELECT group_id FROM groups
	  WHERE name = 'SR-01'
  );

SELECT courses.name AS course_name,
    string_agg(students.first_name || ' ' || students.last_name, ', ') AS students
  FROM courses
	JOIN students_courses ON courses.id = students_courses.course_id
	JOIN students ON students.id = students_courses.student_id
GROUP BY courses.name
ORDER BY courses.name;
