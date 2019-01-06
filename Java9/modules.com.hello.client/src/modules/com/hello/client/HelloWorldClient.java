package modules.com.hello.client;

import modules.com.hello.*;

public class HelloWorldClient {

    public static void main (String arg[]) {
        try {
            HelloWorld hello = new HelloWorldImpl();
            System.out.println(hello.sayHelloWorld());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
