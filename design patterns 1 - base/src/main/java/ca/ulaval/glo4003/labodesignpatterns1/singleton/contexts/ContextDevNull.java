package ca.ulaval.glo4003.labodesignpatterns1.singleton.contexts;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullCourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullStudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.ServiceLocator;

public class ContextDevNull {
	public static void apply() {
		ServiceLocator.register(StudentRepository.class, new DevNullStudentRepository());
		ServiceLocator.register(CourseRepository.class, new DevNullCourseRepository());
	}
}
