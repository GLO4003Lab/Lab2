package org.kevinsalles.state_pattern.states;

import org.kevinsalles.state_pattern.domain.DistributorMachine;
import org.kevinsalles.state_pattern.domain.StateMachine;
import org.kevinsalles.state_pattern.tools.ProgressTime;

public class OptionMilkState  extends StateMachine {
	public void process(DistributorMachine distributorMachine){
		if(distributorMachine.wantMilk()){
			System.out.println("-> Ajouter lait : opt");
			ProgressTime.start(1);
		}
		
		distributorMachine.setStateMachine(new FinishState());
	}
}
