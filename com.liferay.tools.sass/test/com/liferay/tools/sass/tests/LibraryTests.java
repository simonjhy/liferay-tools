package com.liferay.tools.sass.tests;

import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.lang.reflect.Method;

import org.junit.Before;

/**
 * @author Gregory Amerson
 */
public class LibraryTests {

	@Before
	public void extendSearchPath() throws Exception {
		Method prefix = Platform.class
			.getDeclaredMethod("getNativeLibraryResourcePrefix");
		prefix.setAccessible(true);
		String prefixPath = (String)prefix.invoke(null);
		String path = new File("resources/" + prefixPath).getCanonicalPath();
		NativeLibrary.addSearchPath("sass", path);
	}

	protected String readFileContents(String filename) throws Exception {
		return readStreamToString(new FileInputStream(new File(filename)))
			.replaceAll("\\r", "");
	}

	protected String readStreamToString(InputStream contents) throws Exception {
		if (contents == null) {
			return null;
		}

		final char[] buffer = new char[0x10000];

		StringBuilder out = new StringBuilder();

		Reader in = new InputStreamReader(contents, "UTF-8"); //$NON-NLS-1$

		int read;
		do {
			read = in.read(buffer, 0, buffer.length);

			if (read > 0) {
				out.append(buffer, 0, read);
			}
		} while (read >= 0);

		contents.close();

		return out.toString();
	}

}