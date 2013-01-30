package celoron.game.dialogsystem;

import celoron.game.map.MapObject;

/**
 * Oyuncu tarafýndan konuþulabilcek dialoglar yani answer lar
 * bir dialog esnasýnda sadece bir kere derlenip performans artýþý saðlanýr
 * @author celoron
 *
 */
public class AnswerRendered extends Answer {
	String renderedText;
	
	/**
	 * Answer ý derler ver text i kaydeder. 
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
	 * daha önceden derlenmiþ texti verir.
	 * @return
	 */
	public String text(){
		return renderedText;
	}
}
