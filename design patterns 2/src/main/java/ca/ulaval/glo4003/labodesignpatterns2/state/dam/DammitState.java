package ca.ulaval.glo4003.labodesignpatterns2.state.dam;

public class DammitState extends State {

	@Override
	public State waterLevelChanged(int previousWaterLevel, int waterLevel) {
		System.err.println("Dammit which if() did I forget this time??");
		return new NormalState();
	}
}
