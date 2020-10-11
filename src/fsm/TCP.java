package fsm;

import java.util.HashMap;
import java.util.Map;

public class TCP {

	public static String traverseStates(String[] events) {
		String state = "CLOSED";

		Map<String, String> stateMap = new HashMap<>() {
			{
				put("CLOSED: APP_PASSIVE_OPEN", "LISTEN");
				put("CLOSED: APP_PASSIVE_OPEN", "LISTEN");
				put("CLOSED: APP_ACTIVE_OPEN", "SYN_SENT");
				put("LISTEN: RCV_SYN", "SYN_RCVD");
				put("LISTEN: APP_SEND", "SYN_SENT");
				put("LISTEN: APP_CLOSE", "CLOSED");
				put("SYN_RCVD: APP_CLOSE", "FIN_WAIT_1");
				put("SYN_RCVD: RCV_ACK", "ESTABLISHED");
				put("SYN_SENT: RCV_SYN", "SYN_RCVD");
				put("SYN_SENT: RCV_SYN_ACK", "ESTABLISHED");
				put("SYN_SENT: APP_CLOSE", "CLOSED");
				put("ESTABLISHED: APP_CLOSE", "FIN_WAIT_1");
				put("ESTABLISHED: RCV_FIN", "CLOSE_WAIT");
				put("FIN_WAIT_1: RCV_FIN", "CLOSING");
				put("FIN_WAIT_1: RCV_FIN_ACK", "TIME_WAIT");
				put("FIN_WAIT_1: RCV_ACK", "FIN_WAIT_2");
				put("CLOSING: RCV_ACK", "TIME_WAIT");
				put("FIN_WAIT_2: RCV_FIN", "TIME_WAIT");
				put("TIME_WAIT: APP_TIMEOUT", "CLOSED");
				put("CLOSE_WAIT: APP_CLOSE", "LAST_ACK");
				put("LAST_ACK: RCV_ACK", "CLOSED");
			}
		};
		
		for (String event: events) {
			String trans = state +": "+event;
			if (stateMap.containsKey(trans))
				state = stateMap.get(trans);
			else
				return "ERROR";
		}

		return state;
	}
}
