package com.tirthal.learning.langfeatures;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// ---------------------------------------
// --- STEP 00 - WHAT IS ANNOTATIONS? 
//---------------------------------------

///*
// * Java 1.5 - Language feature - Annotations (metadata) = Annotations allow programmers to decorate Java code with their own attributes. These
// * attributes can be used for code documentation, code generation, and, even during runtime, for providing special services such as enhanced
// * business-level security or special business logic. 
// *
// * Java's built-in annotations are: @Override, @Deprecated, @SuppressWarning, @Retension, @Target, @Inherited, @Documented, etc.
// * For more detail, please refer - http://docs.oracle.com/javase/tutorial/java/annotations/predefined.html
// */

//---------------------------------------
//--- STEP 01 - HOW TO DEFINE CUSTOM ANNOTATION? 
//--- (1) @interface is used to define custom annotation
//--- (2) @Retention is java's built-in annotation - used to specify the retention policy, which can be SOURCE, CLASS, or RUNTIME
//--- (3) @Target is java's built-in annotation - used to indicate the type of program element (such as a class, method, or field) to which the declared annotation is applicable. 
//---------------------------------------

/**
 * Let's define custom annotation @AuthoringInfo. Ideally this should be separate "AuthoringInfo.java" file with public declaration.
 * 
 * @author tirthalp
 * 
 */
// Specifying runtime retention policy
@Retention(RetentionPolicy.RUNTIME)
@interface AuthoringInfo {
	String author() default "[Tirthal]"; // you may assign default value of annotation member
	String date(); // annotation member
}

/**
 * Let's define custom annotation @Copyright. Ideally this should be separate "Copyright.java" file with public declaration.
 * 
 * @author tirthalp
 * 
 */
// Let's set to retain in the source file and discards it during compilation
@Retention(RetentionPolicy.SOURCE)
// Setting TYPE element type in Target = the custom annotation can be applicable to only class, interface or enum
@Target(ElementType.TYPE)
// custom defined annotation can be applied to itself also
@Copyright("Tirthal Patel")
@interface Copyright { // @interface is used to define custom annotation with name "Copyright"
	String value(); // In annotations with a single element, the element should be named value
}

// ---------------------------------------
// --- STEP 02 - HOW TO USE CUSTOM ANNOTATIONS IN PROGRAMMING?
// ---------------------------------------

/**
 * Test class for Annotations - @Copyright and @AuthoringInfo are custom annotation defined in the same file
 * 
 * @author tirthalp
 * 
 */
// @Copyright & @AuthoringInfo are custom defined annotations
@Copyright("Tirthal Patel")
@AuthoringInfo(author = "tirthalp", date = "09-Sep-2012")
public class Annotations_TestDrive {
	
	// The @SuppressWarnings annotation makes the compiler suppress warnings for a given method. For instance, if a method calls a deprecated method,
	// or makes an insecure type cast, the compiler may generate a warning. You can suppress these warnings by annotating the method containing the
	// code with the @SuppressWarnings annotation.
	@SuppressWarnings({"unchecked", "rawtypes"})
	@AuthoringInfo(author = "tpatel", date = "10-Sep-2012")
	// @Copyright // If you uncomment this line, you would see compile time error as it is applicable for Type (class, interface, enum) only
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException {

		/*
		 * @Copyright - RetentionPolicy is set as SOURCE. Let's confirm using reflection, it is not available at RUNTIME. If you change
		 * RetentionPolicy from SOURCE to RUNTIME, it would be printed in console when you run program.
		 * 
		 * @AuthoringInfo - RetentionPolicy is set as RUNTIME, hence it would be printed in console when you run program.
		 */
		Class cref = Class.forName("com.tirthal.learning.langfeatures.Annotations_TestDrive"); // // Getting Class reference

		// Getting class level annotations
		for (Annotation a : cref.getAnnotations()) {
			System.out.println(a);
		}

		// Getting Copyright annotation at class level
		Copyright copyrightAnnotation = (Copyright) cref.getAnnotation(Copyright.class);
		if (copyrightAnnotation == null)
			System.out.println("Copyright annotation is not available at runtime");
		else
			System.out.println("Copyright annotation is available at runtime");

		// Getting @AuthoringInfo annotation at class level and displaying annotation members information
		AuthoringInfo authoringInfoAnnotation1 = (AuthoringInfo) cref.getAnnotation(AuthoringInfo.class);
		if (authoringInfoAnnotation1 != null)
			System.out.println("Annotations_TestDrive class is created by '" + authoringInfoAnnotation1.author() + "' on '" + authoringInfoAnnotation1.date() + "'");

		// Getting @AuthoringInfo annotation at method level and displaying annotation members information
		Method mref = cref.getMethod("main", String[].class); // Getting Method reference

		System.out.println("Is AuthoringInfo annotation applied to main() method - " + mref.isAnnotationPresent(AuthoringInfo.class));

		AuthoringInfo authoringInfoAnnotation2 = (AuthoringInfo) mref.getAnnotation(AuthoringInfo.class);
		if (authoringInfoAnnotation2 != null)
			System.out.println("main() method is created by '" + authoringInfoAnnotation2.author() + "' on '" + authoringInfoAnnotation2.date() + "'");
	}
}
