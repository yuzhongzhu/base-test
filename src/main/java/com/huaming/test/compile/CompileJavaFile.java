package com.huaming.test.compile;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class CompileJavaFile {
	/**
	 * 编译生成.class文件
	 * @param fileName
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void complier(String fileName) throws IOException{
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, Charset.defaultCharset());
		@SuppressWarnings("rawtypes")
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask cTask = compiler.getTask(null, fileMgr, null, null, null, units);
		cTask.call();
		fileMgr.close();
		
	}
}
