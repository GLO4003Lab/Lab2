package org.kevinsalles.state_pattern.domain;

public abstract class StateMachine {
	public void process(DistributorMachine distributorMachine){
		System.out.println("-> Fini\n\n");
		distributorMachine.hasFinish = true;
	}
}
