CREATE TABLE IF NOT EXISTS groups (
	id SERIAL PRIMARY KEY,
	name VARCHAR(15) UNIQUE NOT NULL	
);

CREATE TABLE IF NOT EXISTS students (
	id SERIAL PRIMARY KEY,
	group_id INT REFERENCES groups(id),
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL,
	description VARCHAR(255) 
);

CREATE TABLE IF NOT EXISTS students_courses (
	student_id INT REFERENCES students(id),
	course_id INT REFERENCES courses(id),
	CONSTRAINT primary_key PRIMARY KEY(student_id, course_id)
);
