package com.G12.core;

import package com.G12.core.fx.Image;
import package com.G12.core.Sound;

import java.util.HashMap;
import java.util.Map;

public class Loader {

	public static Loader loader = null;
	private Map<String, Image> images = new HashMap<String, Image>();
	private Map<String, Sound> sounds = new HashMap<String, Sound>();

	protected Loader() {
	}

	public static Loader getInstance() {
		if (loader == null) {
			loader = new Loader();
		}
		return loader;
	}

	/* returns and image, 
	 * if the image doesnt exist in the map,
	 *  make a new image*/
	public Image getImage(String path) {
		if(path.isEmpty())		
			return null;
		if (images.containsKey(path)) {
			return images.get(path);
		} else {
			Image image = new Image(path);
			images.put(path, image);
			return image;
		}
	}

	public Sound getSound(String path) {
		if (sounds.containsKey(path)) {
			return sounds.get(path);
		} else {
			Sound sound = new Sound(path);
			sounds.put(path, sound);
			return sound;
		}
	}
}
