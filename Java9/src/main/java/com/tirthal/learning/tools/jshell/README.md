# JShell Tool

Oracle Corp has introduced a new tool called “jshell” in JDK 9. It stands for Java Shell and also known as REPL (Read Evaluate Print Loop). It is used to execute and test any Java Constructs like class, interface, enum, object, statements etc. very easily.

## Get your hands dirty with JShell

For more detail, see [Java Shell User’s Guide](https://docs.oracle.com/javase/9/jshell/JSHEL.pdf).

### JShell Usage

* Open JShell: `jshell`

* See JShell help and use supported commands: `jshell> /help`
    * Set jshell configuration: `jshell> /set feedback verbose`
    * List the imported items: `jshell> /imports`
    * ...

* Tab Completion for Snippets: `When you enter snippets, use the Tab key to automatically complete the item`
    * `jshell> System.out` + <Press-Tab>
    * `jshell> "Hello World!".startsWith(` + <Press-Tab>  

* Try few java code snippets of variable, method and class 

* Import additional libraries and use those APIs (e.g. javax.swing.JFrame):
    * Create JFrame object gives error (cannot find symbol error): `jshell> new JFrame("Demo")`
    * Check all imported items list (not having javax.swing.JFrame): `jshell> /imports`
    * Import new item in jshell: `jshell> import javax.swing.JFrame`
    * Check all imported items list again (should see javax.swing.JFrame): `jshell> /imports`
    * Create JFrame object successfully: `jshell> JFrame frame = new JFrame("Demo")`
    * List declared variables and their values: `jshell> /vars`

* Exit JShell: `jshell> /exit`

### JShell Scripts

A JShell script is a sequence of snippets and JShell commands in a file, one snippet or command per line.

* Open java class in JShell: `jshell> /open Person.java`
* Create object: `jshell> Person p1 = new Person(1, "Tirthal")`
* Call method of the object: `jshell> p1.toString()`
* Save it as script: `jshell> /save person.jsh`
* Exit JShell: `jshell> /exit`
* Open JShell by load the previously saved script: `jshell person.jsh`
* Check vars: `jshell> /vars` | `jshell> /list`
* Call method of the previously saved object: `jshell> p1.getName()` | `jshell> p1.toString()`