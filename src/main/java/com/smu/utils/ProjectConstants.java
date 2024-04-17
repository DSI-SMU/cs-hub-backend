package com.smu.utils;

import java.util.Locale;


public final class ProjectConstants {



	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale AMERICA_LOCALE = new Locale.Builder().setLanguage("en").setRegion("US").build();

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
