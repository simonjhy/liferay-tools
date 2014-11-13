package com.liferay.tools.sass.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.liferay.tools.sass.api.LibSass;
import com.liferay.tools.sass.api.sass_context;
import com.sun.jna.Native;

public class LibSassTests extends LibraryTests {

	@Test
	public void testSharedLibraryLoading() throws Exception {
		LibSass libsass = (LibSass) Native.loadLibrary("sass", LibSass.class); //LibSassDll.INSTANCE;
		assertNotNull(libsass);
		sass_context ctx = libsass.sass_new_context();
		ctx.setAutoRead(true);
		assertEquals(true, ctx.getAutoRead());
		ctx.setAutoRead(false);
		assertEquals(false, ctx.getAutoRead());
	}
}
