package celoron.game.basics;

import java.util.HashMap;
import java.util.Map;

/**
 * Gameobject, oyun i�inde kullan�lcak olan de�erleri tutar.
 * @author celoron
 */
public class GameObject {
	Map<String, Object> values;

	public GameObject() {
		values = new HashMap<String, Object>();
	}

	/**
	 * istenilen de�eri d�nd�r�r.
	 * @param name: de�i�kenin ismi
	 * @return de�i�kenin o anki de�eri
	 */
	public Object value(String name) {
		return values.get(name);
	}

	/**
	 * istenilen de�eri string olarak d�nd�r�r. varsay�lan "" (bo� string) d�r.
	 * @param name
	 * @return
	 */
	public String valueStr(String name) {
		if (!have(name))
			return "";
		// TODO: script debugging
		return values.get(name).toString();
	}

	/**
	 * istenilen de�eri integer olarak d�nd�r�r. varsay�lan 0 d�r.
	 * @param name
	 * @return
	 */
	public int valueInt(String name) {
		if (!have(name))
			return 0;
		// TODO: script debugging
		return (int) valueFloat(name);
	}

	/**
	 * istenilen de�eri float olarak d�nd�r�r. varsay�lan 0 d�r.
	 * @param name
	 * @return
	 */
	public float valueFloat(String name) {
		if (!have(name))
			return 0;
		// TODO: script debugging
		return Float.parseFloat(valueStr(name));
	}

	/**
	 * istenilen de�eri boolean olarak d�nd�r�r. varsay�lan false tur.
	 * @param name
	 * @return
	 */
	public boolean valueBool(String name) {
		if (!have(name))
			return false;
		// TODO: script debugging
		return valueStr(name).equals("true");
	}

	/**
	 * de�erin bu objede olup olmad���n�n sorgusu
	 * @param name
	 * @return
	 */
	public boolean have(String name) {
		return values.containsKey(name);
	}

	/**
	 * de�er atama. varsa �st�ne yaz�l�r, yoksa yeni olu�turulur
	 * @param name
	 * @param value
	 */
	public void value(String name, Object value) {
		values.put(name, value);
	}
}
