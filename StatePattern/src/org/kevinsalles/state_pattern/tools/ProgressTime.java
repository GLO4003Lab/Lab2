package org.kevinsalles.state_pattern.tools;


public class ProgressTime {
	private static final int STEPBAR = 20;
	private static int progressStep = 0;
	
	public static void start(double time){
		int time_second = (int) (time*5);
		progressStep = 0;
		System.out.print(" [ ");
		for(int i = 0; i<=time_second;i++){
			try {
				Thread.sleep(200);
				makeProgressBar(i,time_second);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" ]");
	}
	
	private static void makeProgressBar(int currentStep,int maxStep){
		int stepInBar = Math.abs((STEPBAR*currentStep)/maxStep);
		int loop = stepInBar - progressStep;
		progressStep = stepInBar;
		for(int i = 0; i<loop;i++){
			System.out.print("-");
		}
	}
}
