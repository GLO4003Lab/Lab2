package ca.ulaval.glo4003.labodesignpatterns2.state2.proxy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ca.ulaval.glo4003.labodesignpatterns2.state.dam.State;

public class ProxyNormalState implements ProxyState {
	
	private final static int LIMIT_TIME_IN_SECONDS = 5;
	private final static int LIMIT_CALL = 3;
	
	
	private LocalDateTime timeFirstCall = null;
	private int callsSinceTheBegin = 0;

	@Override
	public String callUrl(RequestProxy requestProxy, String url) {
		resetTime();
		if(isACallBeforeEndTime())
			callsSinceTheBegin += 1;
		else
			callsSinceTheBegin = 0;
		
		if(hasLimitCallBeforeEndTime()) {
			ProxyOverTimeState state = new ProxyOverTimeState();
			requestProxy.setState(state);
			return state.callUrl(requestProxy, url);
		}
			
		
		return "Request : "+url+" sended.";
	}
	
	private boolean isACallBeforeEndTime(){
		LocalDateTime now = LocalDateTime.now();
		long diffInSeconds = ChronoUnit.SECONDS.between(timeFirstCall, now);
		return diffInSeconds <= LIMIT_TIME_IN_SECONDS;
	}
	
	private void resetTime(){
		if(callsSinceTheBegin == 0)
			timeFirstCall = LocalDateTime.now();
	}
	
	private boolean hasLimitCallBeforeEndTime(){
		return callsSinceTheBegin >= LIMIT_CALL;
	}

}
