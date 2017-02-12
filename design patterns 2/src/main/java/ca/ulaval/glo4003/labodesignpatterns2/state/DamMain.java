package ca.ulaval.glo4003.labodesignpatterns2.state;

import ca.ulaval.glo4003.labodesignpatterns2.state.dam.Dam;

public class DamMain {
	public static void main(String[] args) {
		Dam dam = new Dam();

		dam.waterLevelChanged(16); // Normal
		dam.waterLevelChanged(22); // Too high
		dam.waterLevelChanged(39); // Still high
		dam.waterLevelChanged(12); // Back to normal
		dam.waterLevelChanged(8); // Still normal
		dam.waterLevelChanged(4); // Too low
		dam.waterLevelChanged(2); // Still low
		dam.waterLevelChanged(11); // Back to normal
		dam.waterLevelChanged(18); // Still normal
	}
}
