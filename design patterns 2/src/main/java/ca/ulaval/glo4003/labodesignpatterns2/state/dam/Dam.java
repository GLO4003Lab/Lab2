package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public class Dam {

	private static final int A_NORMAL_LEVEL = 15;
	private static final int LOW_THRESHOLD = 5;
	private static final int HIGH_TRESHOLD = 20;

	private int previousWaterLevel;

	public Dam() {
		this.previousWaterLevel = A_NORMAL_LEVEL;
	}

	public void waterLevelChanged(int waterLevel) {
		if (previousWaterLevel >= LOW_THRESHOLD && waterLevel < LOW_THRESHOLD) {
			System.out.println("Water level is too low, slowing down turbine");
		} else if (previousWaterLevel < LOW_THRESHOLD && waterLevel < LOW_THRESHOLD) {
			System.out.println("Turbine is still slow, waiting for water levels to increase");
		} else if (previousWaterLevel < LOW_THRESHOLD && waterLevel >= LOW_THRESHOLD) {
			System.out.println("Water level is back to normal, turbine is back to full speed");
		} else if (previousWaterLevel >= LOW_THRESHOLD && previousWaterLevel <= HIGH_TRESHOLD && waterLevel >= LOW_THRESHOLD && waterLevel <= HIGH_TRESHOLD) {
			System.out.println("Everything is normal");
		} else if (previousWaterLevel <= HIGH_TRESHOLD && waterLevel >= HIGH_TRESHOLD) {
			System.out.println("Water level is too high, opening flood door");
		} else if (previousWaterLevel >= HIGH_TRESHOLD && waterLevel >= HIGH_TRESHOLD) {
			System.out.println("Water level is still too high, keeping doors open");
		} else if (previousWaterLevel > HIGH_TRESHOLD && waterLevel <= HIGH_TRESHOLD) {
			System.out.println("Water level is back to normal, closing flood door");
		} else {
			System.err.println("Dammit which if() did I forget this time??");
		}

		previousWaterLevel = waterLevel;
	}

}
