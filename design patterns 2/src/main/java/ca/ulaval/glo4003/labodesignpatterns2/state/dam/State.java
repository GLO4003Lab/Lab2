package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public abstract class State {
	protected static final int A_NORMAL_LEVEL = 15;
	protected static final int LOW_THRESHOLD = 5;
	protected static final int HIGH_TRESHOLD = 20;
	
	public abstract State waterLevelChanged(int previousWaterLevel, int waterLevel);
}
