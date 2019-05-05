package com.tirthal.learning.libfeatures;

/**
 * Code snippet of Java11 methods added in String such as isBlank, repeat, strip, etc.
 */
public class NewMethodsInStringDemo {

    public static void main(String[] args) {

        // ======== isBlank() =========
        // Returns a true (boolean value), if blank string (i.e. empty Strings or Strings with only white spaces)
        System.out.println("".isBlank());                           // true
        System.out.println("    ".isBlank());                       // true
        System.out.println("this-is-not-blank-string".isBlank());   // false

        // ======== repeat() ==========
        // Repeats the string that many numbers of times as mentioned
        System.out.println("Hello...".repeat(3));

        // ======== strip() ===========
        // Removes the white space from both, beginning and the end of string
        // strip() is “unicode-aware” evolution of trim()
        var msg = "      Hello World!      ";
        System.out.println("---"+ msg.strip() +"---");
        System.out.println("---"+ msg.stripLeading() +"---");
        System.out.println("---"+ msg.stripTrailing() +"---");
    }
}
