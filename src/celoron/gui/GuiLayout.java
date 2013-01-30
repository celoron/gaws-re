package celoron.gui;

/**
 * �izilecek olan gui nesnelerini belli bir d�zende �izer
 * @author celoron
 *
 */
public abstract class GuiLayout {
	protected float x;
	protected float y;
	
	/**
	 * Layoutun ba�lat�laca�� yer
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
	 * �izim yapma
	 * @param gs �izilmesi istenilen gui stili
	 * @param text ��erik
	 * @return T�klan�p t�klanmad���
	 */
	public abstract boolean draw(GuiStyle gs, String text);
	
	/**
	 * Bo�luk b�rakma
	 * @param u Ne kadar bo�luk b�rak�lacak
	 */
	public abstract void space(float u);
}
