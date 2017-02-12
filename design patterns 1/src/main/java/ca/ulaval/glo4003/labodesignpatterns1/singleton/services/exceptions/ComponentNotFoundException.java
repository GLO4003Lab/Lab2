package ca.ulaval.glo4003.labodesignpatterns1.singleton.services.exceptions;

public class ComponentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ComponentNotFoundException(){
		super("Component not found. The interface not implement.");
	}
}
