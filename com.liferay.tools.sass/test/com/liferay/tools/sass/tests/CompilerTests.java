package com.liferay.tools.sass.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.liferay.tools.sass.SassCompiler;

public class CompilerTests extends LibraryTests {

	@Test
	public void testSharedLibraryLoading() throws Exception {
		SassCompiler compiler = new SassCompiler();
		//String output = compiler.compileFile("", "", "");
		assertNotNull(compiler);
	}
}
