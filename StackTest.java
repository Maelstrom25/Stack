package qm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;

    @Before public void setup() {
        stack = new Stack(3);
    }
    @Test public void isEmptyTest() {
        // check if stack is empty
        Assert.assertTrue(stack.isEmpty());
        stack.push(1);
        // check if stack is not empty
        Assert.assertFalse(stack.isEmpty());
    }
    @Test(expected=IllegalArgumentException.class) public void testPushNegative() {
        // check if pushing negative element throws expected exception
        stack.push(-1);
    }
    @Test(expected=StackOverflowError.class) public void testPushOverflow() {
        //  check if pushing element to full stack throws expected error
        for (int i = 1; i < 5; i++) {
            stack.push(i);
        }
        // this also validates the stack.pos variable
    }
    @Test public void testPop() {
        // test pushing elements
        for (int i = 1; i < 4; i++) {
            stack.push(i);
        }
        // test popping all elements
        for (int i = 3; i > 0; i--) {
            Assert.assertEquals(stack.pop(), i);
        }
        // test popping from empty stack
        Assert.assertEquals(stack.pop(), -1);
    }
    @Test public void testSize() {
        // check size of empty stack
        Assert.assertEquals(stack.size(), 0);
        // check other sizes
        for (int i = 1; i < 4; i++) {
            stack.push(i);
            Assert.assertEquals(stack.size(), i);
        }
    }
    @Test public void testTop() {
        // check for empty stack
        Assert.assertEquals(stack.top(), -1);
        // check for stacks of all sizes
        for (int i = 1; i < 4; i++) {
            stack.push(i);
            Assert.assertEquals(stack.top(), i);
        }
    }

    // i used for loops as the stack size is very small, this is not efficient for bigger stacks
}
