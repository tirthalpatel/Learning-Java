//==================================================================================
//"Hello.java" file is calling greetFromJS() method and passing name input parameter
//==================================================================================
var greetFromJS = function(name) {
 
	print('Printing in JavaScript code --- Hello ' + name);
 
	// Java classes can be referenced from javascript via the Java.type API extension, something like importing classes in java code
	var LocalDate = Java.type("java.time.LocalDate");
 
	return "Greeting date is " + LocalDate.now(); // now() is static method, so can be called directly without creating instance of LocalDate class
}