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
public class SetInt extends AbsSetInt {
    
    public SetInt(int capacity){
    super(capacity);
    }
    
    @Override
    public int getCapacity() {return capacity;}
    
    @Override
    public int getSize() {return size;}
   
    /**
     * @param x -- value to be sought
     * @pre true
     * @return true iff x is in list*/
    @Override
    public boolean contains(int x){
    int i = 0;
    while (i != getSize() && i != set[x]){
    i++;}
    // i = getSize() || i = set[i]
    return i != getSize();
    }
        
    /**
     * @param n node to be added
     * @pre contains(n) || getSize() != getCapacity()
     * @post contains(n)
     */
    @Override
    public void include(int n){
    assert contains(n) || getSize() != getCapacity();
    
    if(!contains(n)){
    set[size++] = n;
    }
    }

     /**
     * @param n node to be removed
     * @pre true
     * @post !contains(n)
     */
    @Override
    public void exclude(int n){
    int i = 0;
    while(i != getSize() && set[i] != n){
    i++;}
    
    if(contains(n)){
    set[i] = set[size - 1];
    }
    size--;
    
    }
    
}
