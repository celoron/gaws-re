package celoron.game.basics;

import java.util.HashMap;
import java.util.Map;

/**
 * Gameobject, oyun içinde kullanýlcak olan deðerleri tutar.
 * @author celoron
 */
public class GameObject {
	Map<String, Object> values;

	public GameObject() {
		values = new HashMap<String, Object>();
	}

	/**
	 * istenilen deðeri döndürür.
	 * @param name: deðiþkenin ismi
	 * @return deðiþkenin o anki deðeri
	 */
	public Object value(String name) {
		return values.get(name);
	}

	/**
	 * istenilen deðeri string olarak döndürür. varsayýlan "" (boþ string) dýr.
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
	 * istenilen deðeri integer olarak döndürür. varsayýlan 0 dýr.
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
	 * istenilen deðeri float olarak döndürür. varsayýlan 0 dýr.
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
	 * istenilen deðeri boolean olarak döndürür. varsayýlan false tur.
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
	 * deðerin bu objede olup olmadýðýnýn sorgusu
	 * @param name
	 * @return
	 */
	public boolean have(String name) {
		return values.containsKey(name);
	}

	/**
	 * deðer atama. varsa üstüne yazýlýr, yoksa yeni oluþturulur
	 * @param name
	 * @param value
	 */
	public void value(String name, Object value) {
		values.put(name, value);
	}
}
