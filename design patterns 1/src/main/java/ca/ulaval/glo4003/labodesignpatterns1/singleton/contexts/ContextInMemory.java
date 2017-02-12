package ca.ulaval.glo4003.labodesignpatterns1.singleton.contexts;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceB.InMemoryCourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceB.InMemoryStudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.ServiceLocator;

public class ContextInMemory {
	public static void apply() {
		ServiceLocator.register(StudentRepository.class, new InMemoryStudentRepository());
		ServiceLocator.register(CourseRepository.class, new InMemoryCourseRepository());
	}
}
