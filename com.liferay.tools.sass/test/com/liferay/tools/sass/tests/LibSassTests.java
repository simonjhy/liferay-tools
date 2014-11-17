package com.liferay.tools.sass.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import sass.SassLibrary;
import sass.sass_context;

public class LibSassTests extends LibraryTests {

	@Test
	public void testSharedLibraryLoading() throws Exception {
		assertNotNull(SassLibrary.INSTANCE);
		sass_context ctx = SassLibrary.INSTANCE.sass_new_context();
		ctx.setAutoRead(true);
		assertEquals(true, ctx.getAutoRead());
		ctx.setAutoRead(false);
		assertEquals(false, ctx.getAutoRead());
	}
}
