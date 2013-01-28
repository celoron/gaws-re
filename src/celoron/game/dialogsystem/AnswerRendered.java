package celoron.game.dialogsystem;

import celoron.game.map.MapObject;

public class AnswerRendered extends Answer {
	String renderedText;
	
	public AnswerRendered(Answer answer, MapObject player, MapObject other) {
		super(answer.id, answer.did, answer.f);
		
		renderedText= super.text(player, other);
	}
	
	public String text(){
		return renderedText;
	}
}
