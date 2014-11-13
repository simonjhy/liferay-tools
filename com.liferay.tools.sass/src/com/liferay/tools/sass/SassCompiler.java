package com.liferay.tools.sass;

import java.io.File;

import com.liferay.tools.sass.api.LibSass;
import com.liferay.tools.sass.api.OutputStyle;
import com.liferay.tools.sass.api.SourceComments;
import com.liferay.tools.sass.api.sass_file_context;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class SassCompiler {
	static LibSass libsass = (LibSass) Native.loadLibrary("sass", LibSass.class); //LibSassDll.INSTANCE;

	public String compileFile(String inputFile, String includePath, String imgPath) throws SassCompilationException {
		sass_file_context ctx = null;
		try{
			ctx = libsass.sass_new_file_context();

			ctx.input_path = str(inputFile);
			ctx.output_path = str("");

			String includePaths = includePath+File.pathSeparator+new File(inputFile).getParent();

			ctx.options.include_paths = str(includePaths);
			ctx.options.image_path = str(imgPath);
			ctx.options.source_comments=SourceComments.NONE.value();
			ctx.source_map_file=str("");
			ctx.options.output_style = OutputStyle.EXPANDED.value();

			libsass.sass_compile_file(ctx);

			if (ctx.error_status != 0)
				throw new SassCompilationException(ctx.error_message.getString(0));

			if (ctx.output_string == null || ctx.output_string.getString(0) == null)
				throw new SassCompilationException("libsass returned null");


			String output = ctx.output_string.getString(0);


			return output;
		} finally {
			try{
				if (ctx != null)
					libsass.sass_free_file_context(ctx);
			} catch(Throwable t){
				throw new SassCompilationException(t);
			}
		}
	}

	/**
	 * converts a string to a pointer
	 * @param string
	 * @return
	 */
	private Pointer str(String string){
		Memory mem = new Memory(string.length() +1);
		mem.setString(0, string);
		return mem;
	}


}