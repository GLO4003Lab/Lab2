package org.kevinsalles.state_pattern.domain;

import org.kevinsalles.state_pattern.states.FinishState;
import org.kevinsalles.state_pattern.states.GrindCoffeState;
import org.kevinsalles.state_pattern.states.ProvideChocolateState;
import org.kevinsalles.state_pattern.states.ProvideSoupState;

public class DistributorMachine {
	
	private CommandMachine commandMachine;
	private StateMachine stateMachine;
	
	public boolean hasFinish = true;
	
	public DistributorMachine(){
		this.stateMachine = new FinishState();
	};
	
	public void process(CommandMachine commandMachine){
		this.commandMachine = commandMachine;
		chooseState(commandMachine);
		hasFinish = false;
		while(!hasFinish){
			stateMachine.process(this);
		}
	}
	
	public boolean wantSugar() {
		return commandMachine.wantSugar();
	}
	
	public boolean wantMilk() {
		return commandMachine.wantMilk();
	}
	
	public boolean wantSaltAndPepper() {
		return commandMachine.wantSaltAndPepper();
	}

	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	
	public TypeFood getState(){
		return commandMachine.getTypeFood();
	}
	
	private void chooseState(CommandMachine commandMachine){
		switch(commandMachine.getTypeFood()){
		case CAFFE: 
			this.stateMachine = new GrindCoffeState();
			break;
		case CHOCOLATE: 
			this.stateMachine = new ProvideChocolateState();
			break;
		case SOUP:
			this.stateMachine = new ProvideSoupState();
			break;
		default:
			this.stateMachine = new FinishState();
			break;
		}
	}
}
