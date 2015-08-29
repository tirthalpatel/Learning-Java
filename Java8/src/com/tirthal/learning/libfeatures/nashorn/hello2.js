//=======================================
// Invoking Java Methods from Javascript
//========================================
var Hello = Java.type("com.tirthal.learning.libfeatures.nashorn.Hello");

// The greetFromJava(name) is not static method, so below line throws this exception --- TypeError: [JavaClass com.tirthal.learning.libfeatures.nashorn.Hello] has no such function "greetFromJava"
// Hello.greetFromJava('Mr. Patel');

// Create instance of Hello class, so that its greetFromJava(name) method can be called

// Syntax 1
var hello1 = new Hello();
print("Printing in JavaScript code --- " + hello1.greetFromJava('Mr. Patel'));

// Syntax 2
var hello2 = new com.tirthal.learning.libfeatures.nashorn.Hello();
print("Printing in JavaScript code --- " + hello2.greetFromJava('Mr. Patel'));

