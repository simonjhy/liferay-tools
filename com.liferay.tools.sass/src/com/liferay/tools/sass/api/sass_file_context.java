package com.liferay.tools.sass.api;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * <i>native declaration : line 24</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class sass_file_context extends Structure {
	/// C type : char*
	public Pointer input_path;
	/// C type : char*
	public Pointer output_path;
	/// C type : char*
	public Pointer output_string;
	public Pointer source_map_string;
	public Pointer source_map_file;
	/// C type : sass_options
	public sass_options options;
	public int error_status;
	/// C type : char*
	public Pointer error_message;
	
	public sass_file_context() {
	}
	/**
	 * @param input_path C type : char*<br>
	 * @param output_string C type : char*<br>
	 * @param options C type : sass_options<br>
	 * @param error_message C type : char*
	 */
	public sass_file_context(Pointer input_path, Pointer output_string, sass_options options, int error_status, Pointer error_message) {
		super();
		this.input_path = input_path;
		this.output_string = output_string;
		this.options = options;
		this.error_status = error_status;
		this.error_message = error_message;
	}
	@Override
	protected List getFieldOrder() {
		return Arrays.asList("input_path", "output_path", "output_string","source_map_string","source_map_file", "options", "error_status", "error_message");
	}
}