package celoron.gui;

public class GuiLayoutVertical extends GuiLayout {

	public GuiLayoutVertical(float x, float y) {
		super(x, y);
	}

	@Override
	public boolean draw(GuiStyle gs, String text) {
		boolean r= gs.draw(text, x, y);
		
		move(0, gs.height(text));
		
		return r;
	}

	@Override
	public void space(float u) {
		move(0, u);
	}

}
