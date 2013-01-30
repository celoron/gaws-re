package celoron.game.dialogsystem;

import celoron.game.map.MapObject;

/**
 * Oyuncu taraf�ndan konu�ulabilcek dialoglar yani answer lar
 * bir dialog esnas�nda sadece bir kere derlenip performans art��� sa�lan�r
 * @author celoron
 *
 */
public class AnswerRendered extends Answer {
	String renderedText;
	
	/**
	 * Answer � derler ver text i kaydeder. 
	 * not: req() fonksiyonunu test etmez!
	 * @param answer derlenecek olan answer objesi
	 * @param player oyuncunun harita objesi
	 * @param other npcnin harita objesi
	 */
	public AnswerRendered(Answer answer, MapObject player, MapObject other) {
		super(answer.id, answer.did, answer.f);
		
		renderedText= super.text(player, other);
	}
	
	/**
	 * daha �nceden derlenmi� texti verir.
	 * @return
	 */
	public String text(){
		return renderedText;
	}
}
