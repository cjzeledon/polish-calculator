package com.theironyard.charlotte;


public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    int stackTop;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {
        // 1. Use the String split method to split the string into tokens at the commas
        // This will spilt the array into three elements because it will find the comma in between
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        // Creates a "new" constructor
        // It will take on the new length of an array which is the three elements
        stack = new String[ tokens.length ];

        // 3. write the algorithm
        //
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            String currentToken = tokens[i];

            // convert the current token to a number
            // The big "Double" has methods that is avaialble to use and that's why we use null which is avaialble
            Double num = null;

            try {
                // "Double.parseDouble" will turn the index string into a number
                // If it cannot turn it into a number, then it will run the catch block
                num = Double.parseDouble(currentToken);
            } catch (NumberFormatException ex) {
                // eat it.
            }

            // when we're here, either num has a value
            // or it is null. if it's null, that means
            // we just encountered an operator
            // If num is not equal to num
            // If it's a number, it is allowed to be pushed into a new array
            // It will run the push method which is private void push(double d) instead of private void push (String push)
            // Why? Because it detects that it's a double and not a string, which is why it will run the first method as stated in
            // previous line
            if (num != null) {
                push(num);
            } else if (currentToken.equals("+")) {
                double value1 = pop();
                double value2 = pop();
                push(value2 + value1);
            } else if (currentToken.equals(("-"))) {
                double value1 = pop();
                double value2 = pop();
                push(value2 - value1);
            } else if (currentToken.equals("/")){
                double value1 = pop();
                double value2 = pop();
                push(value2 / value1);
            } else {
                double value1 = pop();
                double value2 = pop();
                push(value2 * value1);
            }

            // TODO: implement the rest of the operators

        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        // TODO: write this code that pushes onto the stack

        stack [stackTop] = number;
        stackTop++;

    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        // in literal sense, it pushes the number into a string push("2.5")
        push(Double.toString(d));
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        // step 1: move the top of the stack back by 1
        stackTop--;

        // step 2: retrieve the value of the stack at the current element;
        String value = stack[stackTop];

        // step 3: reset the value in the stack to null
        stack[stackTop] = null;

        // step 4: return the double version of this string
        return Double.parseDouble(value);
    }
}