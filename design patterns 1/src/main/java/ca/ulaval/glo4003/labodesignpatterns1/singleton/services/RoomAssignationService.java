package ca.ulaval.glo4003.labodesignpatterns1.singleton.services;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;

public class RoomAssignationService {

	public void assignRoomToCourse(int roomNumber, String courseName) {

		CourseRepository courseRepository = ServiceLocator.resolve(CourseRepository.class);

		Course course = courseRepository.findByName(courseName);

		course.assignRoomNumber(roomNumber);

		courseRepository.persist(course);
	}

}
