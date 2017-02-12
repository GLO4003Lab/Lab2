package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public class Dam {

	private static final int A_NORMAL_LEVEL = 15;
	private static final int LOW_THRESHOLD = 5;
	private static final int HIGH_TRESHOLD = 20;

	private int previousWaterLevel;

	private State state;

	public Dam() {
		this.previousWaterLevel = A_NORMAL_LEVEL;
		state = new NormalState();
	}

	public void waterLevelChanged(int waterLevel) {
		state = state.waterLevelChanged(previousWaterLevel, waterLevel);
		previousWaterLevel = waterLevel;
	}
}
