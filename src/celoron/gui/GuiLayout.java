package celoron.gui;

/**
 * Çizilecek olan gui nesnelerini belli bir düzende çizer
 * @author celoron
 *
 */
public abstract class GuiLayout {
	protected float x;
	protected float y;
	
	/**
	 * Layoutun baþlatýlacaðý yer
	 * @param x
	 * @param y
	 */
	public GuiLayout(float x, float y) {
		this.x=x; 
		this.y=y;
	}
	
	protected void move(float x, float y){
		this.x+=x;
		this.y+=y;
	}
	
	/**
	 * Çizim yapma
	 * @param gs Çizilmesi istenilen gui stili
	 * @param text Ýçerik
	 * @return Týklanýp týklanmadýðý
	 */
	public abstract boolean draw(GuiStyle gs, String text);
	
	/**
	 * Boþluk býrakma
	 * @param u Ne kadar boþluk býrakýlacak
	 */
	public abstract void space(float u);
}
