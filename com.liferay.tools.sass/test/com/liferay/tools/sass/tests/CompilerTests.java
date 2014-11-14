package com.liferay.tools.sass.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.liferay.tools.sass.SassCompiler;

public class CompilerTests extends LibraryTests {

	private static final String BASE_RESOURCES = "bin_test/com/liferay/tools/sass/tests/resources/";

	@Test
	public void testSassCompiler() throws Exception {
		SassCompiler compiler = new SassCompiler();
		assertNotNull(compiler);

		String output = compiler.compileFile(BASE_RESOURCES + "_asset_category_selector.scss", "", "");
		assertNotNull(output);
		assertEquals(readFileContents(BASE_RESOURCES + "_asset_category_selector.css"), output);
	}

}
