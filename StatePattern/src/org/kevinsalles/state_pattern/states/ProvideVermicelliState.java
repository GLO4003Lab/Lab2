package org.kevinsalles.state_pattern.states;

import org.kevinsalles.state_pattern.domain.DistributorMachine;
import org.kevinsalles.state_pattern.domain.StateMachine;
import org.kevinsalles.state_pattern.tools.ProgressTime;

public class ProvideVermicelliState extends StateMachine {
	public void process(DistributorMachine distributorMachine){
		System.out.println("-> Remplir vermicelle déshydraté");
		ProgressTime.start(2);
		distributorMachine.setStateMachine(new OptionSaltAndPepperState());
	}
}
