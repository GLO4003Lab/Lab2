package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public class NormalState extends State {

	@Override
	public State waterLevelChanged(int previousWaterLevel, int waterLevel) {
		State state = new DammitState();
		
		if (previousWaterLevel >= LOW_THRESHOLD && previousWaterLevel <= HIGH_TRESHOLD && waterLevel >= LOW_THRESHOLD && waterLevel <= HIGH_TRESHOLD) {
			System.out.println("Everything is normal");	
			state = this;
		}

		if (previousWaterLevel >= LOW_THRESHOLD && waterLevel < LOW_THRESHOLD) {
			System.out.println("Water level is too low, slowing down turbine");
			state = new WaterTooLowState();
		}
		
		if (previousWaterLevel <= HIGH_TRESHOLD && waterLevel >= HIGH_TRESHOLD) {
			System.out.println("Water level is too high, opening flood door");
			state = new WaterTooHighState();
		}
		
		return state;
	}
}
