package org.kevinsalles.state_pattern.states;

import org.kevinsalles.state_pattern.domain.DistributorMachine;
import org.kevinsalles.state_pattern.domain.StateMachine;
import org.kevinsalles.state_pattern.tools.ProgressTime;

public class OptionSaltAndPepperState extends StateMachine {
	public void process(DistributorMachine distributorMachine){
		if(distributorMachine.wantSaltAndPepper()){
			System.out.println("-> Ajouter sel et poivre : opt");
			ProgressTime.start(1);
		}
		
		distributorMachine.setStateMachine(new FillWaterState());
	}
}
