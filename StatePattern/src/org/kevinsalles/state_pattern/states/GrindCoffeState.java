package org.kevinsalles.state_pattern.states;

import org.kevinsalles.state_pattern.domain.DistributorMachine;
import org.kevinsalles.state_pattern.domain.StateMachine;
import org.kevinsalles.state_pattern.tools.ProgressTime;

public class GrindCoffeState extends StateMachine {
	public void process(DistributorMachine distributorMachine){
		System.out.println("-> Moudre caf�");
		ProgressTime.start(3);
		distributorMachine.setStateMachine(new ProvideCaffeState());
	}
}
