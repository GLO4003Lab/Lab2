package ca.ulaval.glo4003.labodesignpatterns1.singleton.services;

import java.util.List;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Student;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;

public class RegistrationService {

	public void addStudentToCourse(String courseName, String idul) {
		CourseRepository courseRepository = ServiceLocator.resolve(CourseRepository.class);
		StudentRepository studentRepository = ServiceLocator.resolve(StudentRepository.class);

		Course course = courseRepository.findByName(courseName);
		Student student = studentRepository.findByIdul(idul);

		course.addStudent(student);
		student.registerForCourse(course);

		courseRepository.persist(course);
		studentRepository.persist(student);
	}

	public void cancelCourse(String courseName) {
		CourseRepository courseRepository = ServiceLocator.resolve(CourseRepository.class);

		Course course = courseRepository.findByName(courseName);

		course.cancel();

		courseRepository.persist(course);
	}

	public void closeDownUniversityAndCancelAllCourses() {
		CourseRepository courseRepository = ServiceLocator.resolve(CourseRepository.class);

		List<Course> courses = courseRepository.findAll();

		for (Course course : courses) {
			course.cancel();
			courseRepository.persist(course);
		}

	}

}
