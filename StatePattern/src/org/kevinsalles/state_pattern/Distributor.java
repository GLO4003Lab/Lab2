package org.kevinsalles.state_pattern;

import org.kevinsalles.state_pattern.domain.CommandMachine;
import org.kevinsalles.state_pattern.domain.DistributorMachine;

public class Distributor {

	public static void main(String[] args) {
		CommandMachine commandMachine = new CommandMachine();
		commandMachine.commandCaffe(false, true);
		
		DistributorMachine distributorMachine = new DistributorMachine();
	
		distributorMachine.process(commandMachine);
		
		commandMachine.commandChocolate(true);
		distributorMachine.process(commandMachine);
		
		commandMachine.commandSoup(true);
		distributorMachine.process(commandMachine);
	}

}
