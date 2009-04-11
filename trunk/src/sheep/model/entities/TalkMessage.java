package sheep.model.entities;

import sheep.model.ObservationType;

public class TalkMessage implements ObservationType {

	private final Character talker;
	private final Character listener;
	private final String msg;
	
	public TalkMessage(Character talker, Character listener, String msg) {
		this.talker = talker;
		this.listener = listener;
		this.msg = msg;
	}

	public Character getTalker() {
		return talker;
	}

	public Character getListener() {
		return listener;
	}

	public String getMessage() {
		return msg;
	}
}