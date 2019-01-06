package com.tirthal.learning.libfeatures.misc;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Java 9 added three methods to improve Optional functionality.
 * (1) ifPresentOrElse() (2) or() (3) stream()
 */
public class OptionalImprovementsDemo {

    public static void main(String[] args) {

        // Java 8 Optional - Quick refresher
        System.out.println(Optional.of("Hello World").map(String::toUpperCase));
        System.out.println(Optional.empty());

        // ---------------------
        // (1) ifPresentOrElse()
        // --------------------

        Optional<String> message = Optional.of("Hello World");

        // Java 8 way - before ifPresentOrElse()

        if(message.isPresent()) {
            System.out.println("Message: " + message.get());
        } else {
            System.out.println("Empty message!");
        }

        // Java 9 way - using ifPresentOrElse()

        message.ifPresentOrElse(m -> System.out.println("Message: " + m),
                () -> System.out.println("Empty message!"));
        Optional.empty().ifPresentOrElse(m -> System.out.println("Message: " + m),
                () -> System.out.println("Empty message!"));

        // ---------
        // (2) or()
        // ----------

        Optional<String> shortMessage = Optional.of("Hello"); // Rather try with Optional.empty();
        Optional<String> longMessage = Optional.of("Hello, How are you?"); // Rather try with Optional.empty();
        Optional<String> fallbackMessage = Optional.of("Hi"); // Rather try with Optional.empty();

        // Java 8 way - orElse() limitation
        try {
            String msg = longMessage.orElse(shortMessage.orElse(fallbackMessage.get())); // fallbackMessage.get() - BAD! - possibility of Exception
            System.out.println(msg);
        } catch(NoSuchElementException e) {
            System.out.println("***" + e);
        }

        // Java 9 way - using or()
        message = longMessage.or(() -> shortMessage).or(() -> fallbackMessage);
        System.out.println(message);

        // -----------
        // (3) stream() - interoperability between Optional and Stream
        // -----------

        Optional.of("Hello").stream()   // If a value is present, returns a sequential Stream containing only that value, otherwise returns an empty Stream
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Stream.flatMap() + Optional.stream() works greatly

        Stream<Optional<String>> messages = Stream.of(Optional.of("Hello"), Optional.empty(), Optional.of("World"));

        messages.flatMap(Optional::stream)
                .forEach(System.out::println);
    }
}
