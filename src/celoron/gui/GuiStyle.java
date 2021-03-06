package celoron.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

/**
 * Gui �izimi yapan s�n�f.
 * @author celoron
 *
 */
public class GuiStyle {
	Image image;
	Image hover;
	int []b= new int[4]; //left right up down
	int []p= new int[4]; //paddings
	int []m= new int[4]; //margins
	
	int minWidth, minHeight;
	int maxWidth= Integer.MAX_VALUE, maxHeight= Integer.MAX_VALUE;
	
	UnicodeFont font;
	
	/**
	 * Arkaplan resmi verilerek cont. edilir
	 * not:muhtemelen de�i�ecek
	 * @param image
	 */
	public GuiStyle(Image image){
		setImage(image);
		
		setBorders(0,0,0,0);
		setPaddings(0,0,0,0);
		setMargins(0,0,0,0);
	}
	
	public void setImage(Image image){
		this.image= image;
	}
	
	/**
	 * Objenin �zerine gelindi�inde ge�ilecek olan arkaplan resmi
	 * @param image
	 */
	public void setHoverImage(Image image){
		this.hover= image;
	}
	
	/**
	 * Kenar uzunluklar� (Resmin geni�letilmeyecek yerleri)
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public void setBorders(int left, int right, int up, int down){
		b[0]=left;
		b[1]=right;
		b[2]=up;
		b[3]=down;
	}
	
	/**
	 * Objenin kendi i�inde b�rak�lacak bo�luklar. (Text ile arkaplan aras�nda)
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public void setPaddings(int left, int right, int up, int down){
		p[0]=left;
		p[1]=right;
		p[2]=up;
		p[3]=down;
	}
	
	/**
	 * Objenin di�er gui objeleri ile aralar�nda b�rak�lcak bo�luk
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public void setMargins(int left, int right, int up, int down){
		m[0]=left;
		m[1]=right;
		m[2]=up;
		m[3]=down;
	}
	
	public void setMinWidth(int width){
		minWidth=width;
	}
	
	public void setMaxWidth(int width){
		maxWidth=width;
	}
	
	public void setMinHeight(int height){
		minHeight=height;
	}
	
	public void setMaxHeight(int height){
		maxHeight=height;
	}
	
	@SuppressWarnings("unchecked")
	public void setFont(String path, int size) {
		try {
			font = new UnicodeFont(path, size, false, false);
			font.addAsciiGlyphs();
			font.getEffects().add(new ColorEffect());  // Create a default white color effect
			font.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verilen text ile olu�acak objenin geni�li�ini verir
	 * @param text
	 * @return
	 */
	public int width(String text){
		return font.getWidth(text) + p[0] + p[1] + m[0] + m[1];
	}

	/**
	 * Verilen text ile olu�acak objenin uzunlu�unu verir
	 * @param text
	 * @return
	 */
	public int height(String text){
		return font.getHeight(text) + p[2] + p[3] + m[2] + m[3];
	}
	
	/**
	 * �izim yapma
	 * @param text ��erik
	 * @param x Pozisyon.x
	 * @param y Pozisyon.y
	 * @return
	 */
	public boolean draw(String text, float x, float y){
		return draw(text, x,y, false);
	}

	/**
	 * �izim yapma
	 * @param text ��erik
	 * @param x Pozisyon.x
	 * @param y Pozisyon.y
	 * @param centered Verilen posizyon objenin tam ortas�m�? di�er durumda sol �st
	 * @return
	 */
	public boolean draw(String text, float x, float y, boolean centered){
		/* sub image positions
		 * 0|1|2
		 * 3|4|5
		 * 6|7|8
		 */
		
		boolean clicked=false;
		
		Image i=image;
		
		int width = font.getWidth(text) + p[0] + p[1];
		int height= font.getHeight(text) + p[2] + p[3];
		
		if(width < minWidth)width= minWidth;
		if(width > maxWidth)width= maxWidth;
		
		if(height < minHeight)height= minHeight;
		if(height > maxHeight)height= maxHeight;
		
		if(centered){
			x-= width/2;
			y-= height/2;
		}
		
		int mx = Gui.input.getMouseX();
        int my = Gui.input.getMouseY();
        if(mx > x && mx < x+width && my > y && my < y+height){
        	
        	if(hover!=null)i= hover;
        	
        	if ( Gui.input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ){
        		clicked=true;
        	}
        }
		
		int sw= i.getWidth(); // source width
		int sh= i.getHeight();// source height
		
		i.draw(
				x, y, 
				x+b[0], y+b[2], 
				0,0, 
				b[0], b[2]
						);
		i.draw(
				x+b[0], y, 
				x+width-b[1], y+b[2],
				b[0],0, 
				sw-b[1], b[2]
						);
		i.draw(
				x+width-b[1], y, 
				x+width, y+b[2],
				sw-b[1],0, 
				sw, b[2]
						);
		
		//2
		i.draw(
				x, y+b[2],
				x+b[0], y+ height-b[3], 
				0,b[2], 
				b[0], sh-b[3]
						);
		i.draw(
				x+b[0], y+b[2], 
				x+width-b[1], y+ height-b[3],
				b[0],b[2], 
				sw-b[1], sh-b[3]
						);
		i.draw(
				x+width-b[1], y+b[2], 
				x+width, y+ height-b[3],
				sw-b[1],b[2], 
				sw, sh-b[3]
						);
		
		//3
		i.draw(
				x, y+ height-b[3],
				x+b[0], y+ height, 
				0,sh-b[3], 
				b[0], sh
						);
		i.draw(
				x+b[0], y+ height-b[3],
				x+width-b[1], y+ height, 
				b[0],sh-b[3], 
				sw-b[1],  sh
						);
		i.draw(
				x+width-b[1], y+ height-b[3],
				x+width,  y+ height, 
				sw-b[1],sh-b[3], 
				sw,  sh
						);
		
		font.drawString(x+p[0], y+p[2], text);
		
		return clicked;
	}
}
