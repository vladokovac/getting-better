package hr.mogh.tests;

import hr.mogh.datastructures.queue.SuperQueue;
import hr.mogh.datastructures.queue.SuperStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests that ensure that Stack and Queue implementations work properly.<br/>
 * Created by vlado on 28.8.2016.
 */
public class QueueTests {

    @Test
    public void stack_pushPop() {
        SuperStack stack = new SuperStack();
        Character value1 = 'A';
        Character value2 = 'B';
        Character value3 = 'C';
        stack.push(value1);
        stack.push(value2);
        stack.push(value3);
        Assert.assertEquals(3, stack.getSize());
        Assert.assertEquals('C', stack.pop());
        Assert.assertEquals(2, stack.getSize());
    }

    @Test
    public void queue_enqueueDequeue() {
        SuperQueue queue = new SuperQueue(3);
        Character value1 = 'A';
        Character value2 = 'B';
        Character value3 = 'C';
        queue.enqueue(value1);
        queue.enqueue(value2);
        queue.enqueue(value3);
        Assert.assertEquals(3, queue.getSize());
        Assert.assertEquals('A', queue.dequeue());
        Assert.assertEquals(2, queue.getSize());
    }
}
