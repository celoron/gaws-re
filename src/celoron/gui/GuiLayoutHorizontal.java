package celoron.gui;

public class GuiLayoutHorizontal extends GuiLayout {

	public GuiLayoutHorizontal(float x, float y) {
		super(x, y);
	}

	@Override
	public boolean draw(GuiStyle gs, String text) {
		boolean r= gs.draw(text, x, y);
		
		move(gs.width(text), 0);
		
		return r;
	}

	@Override
	public void space(float u) {
		move(u, 0);
	}

}
