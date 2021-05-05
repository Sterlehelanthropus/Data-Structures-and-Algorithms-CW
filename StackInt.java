/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMP5017CW2;

/**
 *
 * @author Joel
 */
public class StackInt extends AbsStackInt {
    
    public StackInt(int capacity){
    super(capacity);
    }
    
    @Override
    public int getCapacity() {return capacity;}
    
    @Override
    public int getSize() {return size;}

    /**
     * @param n node to be added
     * @pre getSize() != getCapacity()
     * @post n has been pushed on to top of stack
     */
    @Override
    public void push(int n){
    assert getSize() != getCapacity();
    
    stack[size] = n;
    size++;}

     /**
     * @pre getSize() != 0
     * @post element on top of stack has been removed
     * @return value that has been removed */
    @Override
    public int pop(){
    assert getSize() != 0;
    size--;
    return stack[size];}

    /**
     * @pre getSize() != 0
     * @return value on top of stack */
    @Override
    public int peek(){
    assert getSize() != 0;
    return stack[size - 1];}

    
}
