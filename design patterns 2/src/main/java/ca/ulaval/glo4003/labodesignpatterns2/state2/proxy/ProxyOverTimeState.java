package ca.ulaval.glo4003.labodesignpatterns2.state2.proxy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ca.ulaval.glo4003.labodesignpatterns2.state.dam.State;

public class ProxyOverTimeState implements ProxyState {

	private final static int FREEZE_PERIOD_IN_SECONDS = 5;
	
	private LocalDateTime freezeTime;
	
	public ProxyOverTimeState() {
		freezeTime = LocalDateTime.now();
	}
	
	@Override
	public String callUrl(RequestProxy requestProxy, String url) {
		if(freezePeriodIsOver()){
			ProxyNormalState state = new ProxyNormalState();
			requestProxy.setState(state);
			return state.callUrl(requestProxy, url);
		}
		
		throw new TooManyRequestsException("Refused the call to "+url);
	}
	
	private boolean freezePeriodIsOver(){
		LocalDateTime now = LocalDateTime.now();
		long diffInSeconds = ChronoUnit.SECONDS.between(freezeTime, now);
		return diffInSeconds > FREEZE_PERIOD_IN_SECONDS;
	}

}
