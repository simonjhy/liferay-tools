package com.liferay.tools.sass.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.liferay.tools.sass.SassCompiler;

public class MultiThreadedCompilerTests extends LibraryTests {

	private static final String BASE_RESOURCES = "bin_test/com/liferay/tools/sass/tests/resources/";

	@Test
	public void testMultiThreadedMultiCompiler() throws Exception
	{
		Thread[] threads = new Thread[100];

		for( int i = 0; i < threads.length; i++ )
		{
			threads[i] = new Thread()
			{
				@Override
				public void run()
				{
					try
					{
						sleep(100);

						SassCompiler compiler = new SassCompiler();
						assertNotNull(compiler);

						String output = compiler.compileFile(BASE_RESOURCES + "/compass/_app_view_entry.scss", "", "");
						assertNotNull(output);
						assertEquals(readFileContents(BASE_RESOURCES + "/compass/_app_view_entry.css"), output);
					}
					catch (Exception e)
					{
					}
				}
			};

			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
			threads[i] = null;
		}

		for( int i = 0; i < threads.length; i++)
		{
			assertNull( threads[i] );
		}
	}

	@Test
	public void testMultiThreadedSharedCompiler() throws Exception
	{
		Thread[] threads = new Thread[100];

		for( int i = 0; i < threads.length; i++ )
		{
			final SassCompiler compiler = new SassCompiler();

			threads[i] = new Thread()
			{
				@Override
				public void run()
				{
					try
					{
						sleep(100);

						String output = compiler.compileFile(BASE_RESOURCES + "/compass/_app_view_entry.scss", "", "");
						assertNotNull(output);
						assertEquals(readFileContents(BASE_RESOURCES + "/compass/_app_view_entry.css"), output);
					}
					catch (Exception e)
					{
					}
				}
			};

			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
			threads[i] = null;
		}

		for( int i = 0; i < threads.length; i++)
		{
			assertNull( threads[i] );
		}
	}

}
