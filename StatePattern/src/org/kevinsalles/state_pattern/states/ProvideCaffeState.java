package org.kevinsalles.state_pattern.states;

import org.kevinsalles.state_pattern.domain.DistributorMachine;
import org.kevinsalles.state_pattern.domain.StateMachine;
import org.kevinsalles.state_pattern.tools.ProgressTime;

public class ProvideCaffeState extends StateMachine {
	public void process(DistributorMachine distributorMachine){
		System.out.println("-> Remplir café");
		ProgressTime.start(1);
		distributorMachine.setStateMachine(new OptionSugarState());
	}
}
