package sheep.model.entities;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public class TalkMessage implements Serializable {

	private final Character talker;
	private final Character listener;
	private final String msg;
	private final boolean isQuestion;
	
	public TalkMessage(Character talker, Character listener, String msg, boolean isQuestion) {
		this.talker = talker;
		this.listener = listener;
		this.msg = msg;
		this.isQuestion = isQuestion;
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
	
	public boolean isQuestion() {
		return isQuestion;
	}
	
	public String toString() {
		return talker.getID() + " said \"" + msg + "\"";
	}
}