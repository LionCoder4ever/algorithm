package com.al.MakeQueueWithTwoStack;

import java.util.ArrayDeque;

/**
 * lc offer #09
 *
 *    8
 *    7 (delete head)
 *  stack a         stack b
 *
 *                      7    (pop)
 *                      8
 *  stack a         stack b
 */
public class CQueue {
    ArrayDeque<Integer> a =  new ArrayDeque<>();
    ArrayDeque<Integer> b =  new ArrayDeque<>();
    public CQueue() {

    }

    /**
     *
     * @param value
     */
    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (b.isEmpty()) {
            return -1;
        } else {
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.isEmpty() ? -1 : b.pop();
    }
}
