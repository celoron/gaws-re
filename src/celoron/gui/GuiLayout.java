package celoron.gui;

public abstract class GuiLayout {
	protected float x;
	protected float y;
	
	public GuiLayout(float x, float y) {
		this.x=x; 
		this.y=y;
	}
	
	protected void move(float x, float y){
		this.x+=x;
		this.y+=y;
	}
	
	public abstract boolean draw(GuiStyle gs, String text);
}
