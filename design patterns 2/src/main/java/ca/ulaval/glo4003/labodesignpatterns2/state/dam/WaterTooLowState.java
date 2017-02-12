package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public class WaterTooLowState extends State{

	@Override
	public State waterLevelChanged(int previousWaterLevel, int waterLevel) {
		State state = new DammitState();
		
		if (previousWaterLevel < LOW_THRESHOLD && waterLevel < LOW_THRESHOLD) {
			System.out.println("Turbine is still slow, waiting for water levels to increase");
			state = this;
		} 
		else if (previousWaterLevel < LOW_THRESHOLD && waterLevel >= LOW_THRESHOLD) {
			System.out.println("Water level is back to normal, turbine is back to full speed");
			state = new NormalState();
		}
		
		return state;
	}
}
