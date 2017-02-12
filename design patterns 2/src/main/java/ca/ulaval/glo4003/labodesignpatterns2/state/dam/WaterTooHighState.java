package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public class WaterTooHighState extends State {

	@Override
	public State waterLevelChanged(int previousWaterLevel, int waterLevel) {
		
		State state = new DammitState();
		
		if (previousWaterLevel <= HIGH_TRESHOLD && waterLevel >= HIGH_TRESHOLD) {
			System.out.println("Water level is too high, opening flood door");
			state = this;
		} 
		else if (previousWaterLevel >= HIGH_TRESHOLD && waterLevel >= HIGH_TRESHOLD) {
			System.out.println("Water level is still too high, keeping doors open");
			state = this;
		}
		else if (previousWaterLevel > HIGH_TRESHOLD && waterLevel <= HIGH_TRESHOLD) {
			System.out.println("Water level is back to normal, closing flood door");
			state = new NormalState();
		} 
			
		return state;
	}
}
