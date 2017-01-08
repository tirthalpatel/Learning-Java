package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * A custom Spliterator implementation
 * 
 * @author tirthalp
 */
public class Ex07_BookSpliterator implements Spliterator<Ex07_Book> {

	private final Spliterator<String> lineSpliterator;
	private String name;
	private String author;
	private int totalPages;
	private double price;

	public Ex07_BookSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}
	
	@Override
	public boolean tryAdvance(Consumer<? super Ex07_Book> action) {
		
		if(this.lineSpliterator.tryAdvance(line -> this.name = line) &&
		   this.lineSpliterator.tryAdvance(line -> this.author = line) &&
		   this.lineSpliterator.tryAdvance(line -> this.totalPages = Integer.parseInt(line)) &&
		   this.lineSpliterator.tryAdvance(line -> this.price = Double.parseDouble(line)) &&
		   this.lineSpliterator.tryAdvance(line -> new String(line))) {
			   
			   	Ex07_Book book = new Ex07_Book(name, author, totalPages, price);
				action.accept(book);
				
				return true;			   
		} else {
			return false;
		}
	}

	@Override
	public Spliterator<Ex07_Book> trySplit() {		
		return null; // Implement, if need to support a parallel stream
	}

	@Override
	public long estimateSize() {		
		return lineSpliterator.estimateSize() / 5; // Each book has 5 lines of data in Ex06_Books.txt
	}

	@Override
	public int characteristics() {		
		return lineSpliterator.characteristics();
	}

}
