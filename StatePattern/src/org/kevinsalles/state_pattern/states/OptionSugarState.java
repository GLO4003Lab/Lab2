package org.kevinsalles.state_pattern.states;

import org.kevinsalles.state_pattern.domain.DistributorMachine;
import org.kevinsalles.state_pattern.domain.StateMachine;
import org.kevinsalles.state_pattern.domain.TypeFood;
import org.kevinsalles.state_pattern.tools.ProgressTime;

public class OptionSugarState extends StateMachine {
	public void process(DistributorMachine distributorMachine){
		if(distributorMachine.wantSugar()){
			System.out.println("-> Ajouter sucre : opt");
			ProgressTime.start(1);
		}
		
		if(distributorMachine.getState() == TypeFood.CHOCOLATE)
			distributorMachine.setStateMachine(new FillMilkState());
		else
			distributorMachine.setStateMachine(new FillWaterState());
	}
}
