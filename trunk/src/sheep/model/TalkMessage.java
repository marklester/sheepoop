package sheep.model;

import sheep.model.entities.Character;

public class TalkMessage implements model.ObservationType {

	public TalkMessage(model.Character talker, model.Character listener, String msg) {
		throw new UnsupportedOperationException();
	}

	public model.Character getTalker() {
		throw new UnsupportedOperationException();
	}

	public model.Character getListener() {
		throw new UnsupportedOperationException();
	}

	public String getMessage() {
		throw new UnsupportedOperationException();
	}
}