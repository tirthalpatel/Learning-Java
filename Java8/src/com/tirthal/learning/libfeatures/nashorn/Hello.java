package com.tirthal.learning.libfeatures.nashorn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Hello.java file --- calling JavaScript function form Java code...
// Import script APIs
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Hello {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		
		//==============================================
		// Invoking Javascript Functions from Java
		//==============================================
		
		// Create instance of JavaScript ScriptEngine
		ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Invoke "greetFromJS" function of "hello1.js" file
		nashorn.eval(Files.newBufferedReader(Paths.get("src/com/tirthal/learning/libfeatures/nashorn/hello1.js")));		
		Object greetingDate = ((Invocable) nashorn).invokeFunction("greetFromJS", "Tirthal"); 

		// Print output returned from "greetFromJS" function of "hello1.js" file
		System.out.println("Printing in Java code --- " + greetingDate);
	}
	
	//==============================================================================
	// "hello2.js" file is calling greetFromJava() and passing name input parameter
	//==============================================================================
	public String greetFromJava(String name) {
		System.out.println("Printing in Java code --- Hello World " + name);
		
		return "Hello World " + name;
	}
}