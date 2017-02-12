package org.kevinsalles.state_pattern.domain;

public class CommandMachine {
	
	private TypeFood typeFood;
	private boolean saltAndPepper;
	private boolean sugar;
	private boolean milk;
	
	public void commandCaffe(boolean sugar, boolean milk){
		typeFood = TypeFood.CAFFE;
		this.saltAndPepper = false;
		this.sugar = sugar;
		this.milk = milk;
	};
	
	public void commandSoup(boolean saltAndPepper){
		typeFood = TypeFood.SOUP;
		this.saltAndPepper = saltAndPepper;
		this.sugar = false;
		this.milk = false;
	};
	
	public void commandChocolate(boolean sugar){
		typeFood = TypeFood.CHOCOLATE;
		this.saltAndPepper = false;
		this.sugar = sugar;
		this.milk = false;
	}

	public TypeFood getTypeFood() {
		return typeFood;
	}

	public boolean wantSaltAndPepper() {
		return saltAndPepper;
	}

	public boolean wantSugar() {
		return sugar;
	}

	public boolean wantMilk() {
		return milk;
	};
	
	
}
