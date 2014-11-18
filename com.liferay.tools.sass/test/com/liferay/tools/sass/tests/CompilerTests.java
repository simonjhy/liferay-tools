package com.liferay.tools.sass.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.liferay.tools.sass.SassCompiler;

public class CompilerTests extends LibraryTests {

	private static final String BASE_RESOURCES = "bin_test/com/liferay/tools/sass/tests/resources/";

	@Test
	public void testCompile() throws Exception {
		SassCompiler compiler = new SassCompiler();
		assertNotNull(compiler);

		String output = compiler.compile(".foo { background: white; .bar { margin-top: 10px; } }", "", "" );
		assertNotNull(output);
		assertEquals(".foo { background: white; } .foo .bar { margin-top: 10px; }", stripNewLines(output));
	}

	private String stripNewLines(String str) {
		return str.replaceAll("\\n|\\r", "").replaceAll("\\s+", " ");
	}

	@Test
	public void testCompileFile() throws Exception {
		SassCompiler compiler = new SassCompiler();
		assertNotNull(compiler);

		String output = compiler.compileFile(BASE_RESOURCES + "_asset_category_selector.scss", "", "");
		assertNotNull(output);
		assertEquals(readFileContents(BASE_RESOURCES + "_asset_category_selector.css"), output);
	}

	@Test
	public void testCompile_app_view_entry() throws Exception {
		SassCompiler compiler = new SassCompiler();
		assertNotNull(compiler);

		String output = compiler.compileFile(BASE_RESOURCES + "/compass/_app_view_entry.scss", BASE_RESOURCES + "/compass/common", "");
		assertNotNull(output);
		assertEquals(readFileContents(BASE_RESOURCES + "/compass/_app_view_entry.css"), output);
	}

}
