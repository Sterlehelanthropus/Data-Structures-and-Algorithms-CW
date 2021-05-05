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
public class ListInt extends AbsListInt{
    
    public ListInt (int capacity){
    super(capacity);}
    
    @Override
    public int getCapacity() {return capacity;}
    
    @Override
    public int getSize() {return size;}

    /**
    * @param n node to be added
    * @pre getSize() != getCapacity()
    * @post n has been appended to list
    */
    @Override
    public void append(int n){
        assert getSize() != getCapacity();
        int i = 0;
        if(!contains(n)){
            list[size++] = n;
        }
        
    }
    
     /**
     * @param x -- value to be sought
     * @pre true
     * @return true if x is in list*/
    @Override
    public boolean contains(int x){
    int i = 0;
    while(i != getSize() && list[i] != x){
    i++;}
    return i != getSize();
        }
    
}
