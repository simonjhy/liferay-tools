package com.liferay.tools.sourceformatter.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.liferay.tools.sourceformatter.JavaSourceProcessor;

public class LocalSourceFormatter {

	public static void main(String[] args) {
		try {
			JavaSourceProcessor javaProcessor = new JavaSourceProcessor();

			File[] parents = new File[] { new File("../com.liferay.tools.sass/src/com"), new File("../com.liferay.tools.sass/test/com") };

			for( File parent : parents )
			{
				List<File> files = getFiles( parent, new ArrayList<File>() );

				for( File file : files )
				{
					String result = javaProcessor.format(file.getCanonicalPath(), false, true, true);
//					FileUtil.write(file, result.getBytes());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<File> getFiles(File dir, List<File> filesToCollect) {
		File[] files = dir.listFiles();

		for( File file : files )
		{
			if(file.isDirectory())
			{
				getFiles( file, filesToCollect );
			}

			if( file.getName().endsWith(".java") )
			{
				filesToCollect.add( file );
			}
		}

		return filesToCollect;
	}

}
