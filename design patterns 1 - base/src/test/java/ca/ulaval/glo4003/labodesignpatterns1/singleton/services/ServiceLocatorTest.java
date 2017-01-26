package ca.ulaval.glo4003.labodesignpatterns1.singleton.services;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullCourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullStudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.ServiceLocator;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.exceptions.ComponentNotFoundException;

public class ServiceLocatorTest {

	@Test
	public void givenServiceLocator_whenIwantARepository_thenShouldHaveARepositoryNotNull(){
		ServiceLocator.register(CourseRepository.class, new DevNullCourseRepository());
		CourseRepository courseRepository = ServiceLocator.resolve(CourseRepository.class);
		assertNotNull(courseRepository);
	}
	
	@Test
	public void givenServiceLocator_whenIResolve_thenShouldHaveASingleton(){
		ServiceLocator.register(CourseRepository.class, new DevNullCourseRepository());
		ServiceLocator.register(CourseRepository.class, new DevNullCourseRepository());
		CourseRepository courseRepository = ServiceLocator.resolve(CourseRepository.class);
		CourseRepository courseRepository2 = ServiceLocator.resolve(CourseRepository.class);
		assertEquals(courseRepository,courseRepository2);
	}
	
	@Test
	public void givenTwoInterface_whenIResolveInterfaceTwo_thenHaveInterfaceTwo(){
		ServiceLocator.register(CourseRepository.class, new DevNullCourseRepository());
		ServiceLocator.register(StudentRepository.class, new DevNullStudentRepository());
		StudentRepository interface2 = ServiceLocator.resolve(StudentRepository.class);
		assertTrue(interface2 instanceof StudentRepository);
	}
	
	@Test (expected=ComponentNotFoundException.class)
	public void givenAWrongInterface_whenIResolve_thenThrowException(){
		ServiceLocator.register(CourseRepository.class, new DevNullCourseRepository());
		ServiceLocator.resolve(fakeRepository.class);
	}
	
	private interface fakeRepository {}
}
