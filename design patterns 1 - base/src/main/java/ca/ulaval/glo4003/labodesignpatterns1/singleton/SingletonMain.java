package ca.ulaval.glo4003.labodesignpatterns1.singleton;

import java.util.Date;


import ca.ulaval.glo4003.labodesignpatterns1.singleton.contexts.ContextInMemory;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Student;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.AttendanceService;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.RegistrationService;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.RoomAssignationService;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.ServiceLocator;

public class SingletonMain {

	public static void main(String[] args) {
		Course course = new Course();
		course.name = "course1";

		Student student = new Student();
		student.idul = "idul1";
		
		ContextInMemory.apply();

		ServiceLocator.resolve(CourseRepository.class).persist(course);
		ServiceLocator.resolve(StudentRepository.class).persist(student);

		AttendanceService attendanceService = new AttendanceService();
		attendanceService.addAttendee(course.name, new Date(), student.idul);
		attendanceService.clearAttendees(course.name);

		RegistrationService registrationService = new RegistrationService();
		registrationService.addStudentToCourse(course.name, student.idul);
		registrationService.cancelCourse(course.name);

		RoomAssignationService roomAssignationService = new RoomAssignationService();
		roomAssignationService.assignRoomToCourse(1212, course.name);
	}

}
