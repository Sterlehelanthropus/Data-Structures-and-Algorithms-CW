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
public class QueueInt extends AbsQueueInt {
    int front, back;
    public QueueInt(int capacity){
    super(capacity);
    }
    
    @Override
    public int getCapacity() {return capacity;}
    
    @Override
    public int getSize() {return size;}

    /**
     * @param n node to be added
     * @pre getSize() != getCapacity()
     * @post n has been added to back of queue
     */
    @Override
    public void addToBack(int n){
    assert getSize() != getCapacity();
    queue[back] = n;
    size++;
    back = (back + 1) % capacity;
    

    }

    /**
     * @pre getSize() != 0
     * @post element at front of queue has been removed
     * @return value that has been removed */
    @Override
    public int removefromFront(){
    assert getSize() != 0;
    int result = queue[front];
    size--;
    front = front + 1 % capacity;
    return result;
    
    }
    
}
