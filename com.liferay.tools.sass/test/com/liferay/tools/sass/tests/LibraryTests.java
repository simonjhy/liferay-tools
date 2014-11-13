package com.liferay.tools.sass.tests;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.Before;

import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;

public class LibraryTests {

	@Before
	public void extendSearchPath() throws Exception {
		Method prefix = Platform.class.getDeclaredMethod("getNativeLibraryResourcePrefix");
		prefix.setAccessible(true);
		String prefixPath = (String)prefix.invoke(null);
		String path = new File("resources/" + prefixPath).getCanonicalPath();
		NativeLibrary.addSearchPath("sass", path);
	}

}
