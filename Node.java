/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp5017;

/**
 *
 * @author Joel
 */
public class Node {
    Member data;
    Node next;
    Node left, right;

public Node(Member memb){
this.data = memb;
left = null;
right = null;
        
//this.next = null;
}

}
