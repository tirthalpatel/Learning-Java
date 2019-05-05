# Big O in Action (with Java)

While recharging my proficiency on the all time favorite "Calculating Big O for Data Structures and Algorithms" topic, I produced below essential notes along with correlated java code snippets.

## Prerequisites

* Java 11
* Maven
* Choice of IDE - Intellij, Eclipse (Import project as existing Maven project)

## Content

### Big O Fundamental

In computer science, Big O notation is used to classify algorithms according to how their running time or space requirements grow as the input size grows. [See](https://en.wikipedia.org/wiki/Big_O_notation). 

In other words, performance of an algorithm is described using Big O Notation. The study of the performance of algorithms – or algorithmic complexity – falls into the field of algorithm analysis. Algorithm analysis answers the question of how many resources, such as disk space or time, an algorithm consumes. [See](https://www.baeldung.com/java-algorithm-complexity).

Big O notation example: "O(n)" in which "O" stands for order of the function or growth rate, and "n" stands for the actual mathematical function.

Big O doesn’t care about how well your algorithm does with inputs of small size. It’s concerned with large inputs (think sorting a list of one million numbers vs. sorting a list of just 5 numbers).

* [Why Big O Notation?](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N01_WhyBigO.java) - Performance of an algorithm, in terms of execution time (time complexity / speed) or space requirement (space complexity / memory), is described using Big O Notation  
* [O(N) | Order N | Linear Time Algorithms](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N02_Linear.java) -  Time to run / algorithmic complexity grows directly proportional to its input size
* [O(1) | Order 1 | Constant Time Algorithms](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N03_Constant.java) -  Takes a constant amount of time to run, irrespective of its input size
* [O(N^2) | Quadratic Time Algorithm](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N04_Quadratic.java) -  Time to run grows quadratically as its input size grows
* [Big O Calculation](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N05_BigOCalculation.java) - An naive approach to calculate Big O, and the rule book to simplify calculation of Big O complexity 
    * [Rule-1](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N05_BigOCalculationRule1.java) - Always care about worst case scenario
    * [Rule-2](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N05_BigOCalculationRule2.java) - Remove the constants
    * [Rule-3](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N05_BigOCalculationRule3.java) - Different terms for inputs
    * [Rule-4](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N05_BigOCalculationRule4.java) - Drop non dominants
* [Big O Space Complexity](https://github.com/tirthalpatel/Learning-Java/blob/master/bigo-in-action/src/main/java/com/tirthal/learning/bigo/N06_BigOSpaceComplexity.java) - All about additional space requirement within the algorithm

About Asymptotic Functions:
* Big O describes the set of all algorithms that run no worse than a certain speed (it’s an upper bound)
* Conversely, Big Ω describes the set of all algorithms that run no better than a certain speed (it’s a lower bound)
* Finally, Big Θ describes the set of all algorithms that run at a certain speed (it’s like equality)

### Big O Summary

While implementing algorithm, always think what's more important - Space or Time? Improving on time complexity may need to compromise on space complexity, and vice versa.

In below table, it degrades in performance from top (constant) to bottom (factorial).

| Name              | Big O Notation    | Example                                       
| :----------------:|:-----------------:| :---------------
| Constant          | O(1)              | no loops / any constant instruction (i.e. return true; ) 
| Logarithmic       | O(log n)          | binary search  
| Linear            | O(n)              | for or while loop                             
| Quadratic, Cubic..| O(n^2), O(n^3)..  | loop within loop / nested loops                                
| Exponential       | O(c^n)            | recursive calls over n and looping over c in the function
| Factorial         | O(n!)             | adding a loop for every element

![Big-O Complexity Chart](images/BigO_Complexity_Chart.png)
Credit: [Big-O Cheat Sheet](http://bigocheatsheet.com/)

## Also See

* [Practical Java Examples of the Big O Notation](https://www.baeldung.com/java-algorithm-complexity)
* [Big-O Cheat Sheet](http://bigocheatsheet.com/)
* [Visualising data structures and algorithms through animation](https://visualgo.net/en)
* [Algorithms Explanation](https://github.com/TheAlgorithms/Algorithms-Explanation)
* [Master the Coding Interview: Data Structures + Algorithms](https://www.udemy.com/master-the-coding-interview-data-structures-algorithms)
* [Data Structures and Algorithms in Java, 6th Edition](https://www.wiley.com/en-sg/Data+Structures+and+Algorithms+in+Java%2C+6th+Edition+International+Student+Version-p-9781118808573)