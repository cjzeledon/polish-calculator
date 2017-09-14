package com.theironyard.charlotte;

/**
 * Test Driven Development (TDD)
 * Write your tests first and watch them fail.
 * Then write the algorithm and watch the tests pass.
 */
public class Main {
    public static void main(String[] args) {
        // the keyword called "new" creates new instances
        ReversePolishCalc rpc = new ReversePolishCalc();

        // This sets the numbers and operators as string
        String rpnExpression = "2.5,4.8,+";
        // This is the expected result that is a double
        double expectedResult = 7.3;
        // rpc is an object and not a class (you would know if it was a cap R and not r)
        // rpc is a non-staic because it runs on the instance
        double actualResult = rpc.calculate(rpnExpression);
        // Runs the variables within a method
        // Checks to see if we're right
        checkResult(rpnExpression, expectedResult, actualResult);

        // Write tests for the other operators (-, *, /)

        // Uncomment this test which has many operators
        rpnExpression = "5,1,2,+,4,*,+,3,-";
        expectedResult = 14.0;
        actualResult = rpc.calculate(rpnExpression);
        checkResult(rpnExpression, expectedResult, actualResult);
    }

    private static void checkResult(String expression, double expected, double actual) {
        if (expected == actual) {
            System.out.println("SUCCESS: " + expression + " is " + expected);
        } else {
            System.out.println("ERROR: " + expression + " expected " + expected + " actual " + actual);
        }
    }
}