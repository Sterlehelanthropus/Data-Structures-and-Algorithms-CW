/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp5017;

import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Joel
 */
public class MemberBST implements IMemberDB {

    private int entries;
    private Node root;
    private Member previous;
    

    public MemberBST() {
        root = null;
        previous = null;
        entries = 0;
        System.out.println("Binary Search Tree");

    }

    private Node insert(Node tree, Member m) {
        if (tree == null) {
            tree = new Node(m);
            entries++;
        } else {
            int compare = m.getName().compareTo(tree.data.getName());
            if (compare < 0) { // name < tree.data.name
                tree.left = insert(tree.left, m);
            } else if (compare > 0) { // name > tree.data.name
                tree.right = insert(tree.right, m);
            } else /* compare == 0 override*/ {
                previous = tree.data;
                tree.data = m;
            }

        }
        return tree;
    }

    /**
     * Empties the database.
     *
     * @pre true
     */
    @Override
    public void clearDB() {
        assert entries > 0;
//        while(root.left != null && root.right != null){
//        root.left = root.left.next;
//        root.right = root.right.next;
//        root.right = null;
//        root.left = null;
//        root = null;}
    }

    /**
     * Determines whether a member's name exists as a key inside the database
     *
     * @pre name is not null and not empty string
     * @param name the member name (key) to locate
     * @return true if the name exists as a key in the database
     */
    @Override
    public boolean containsName(String name) {
        assert !name.isEmpty() && !name.equals("");
        try {
            return get(name) != null;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * Returns a Member object mapped to the supplied name.
     *
     * @pre name not null and not empty string
     * @param name The Member name (key) to locate
     * @return the Member object mapped to the key name if the name exists as
     * key in the database, otherwise null
     */
    @Override
    public Member get(String name) {
        assert !name.isEmpty() && !name.equals("");
        Node current = root;
        String nodeName;
        while (current != null && !name.equals(current.data.getName())) {
            int compare = name.compareTo(current.data.getName());
            if (compare < 0) {
                current = current.left;
                nodeName = current.toString();
                logWrite(nodeName);
            } else if (compare > 0) {
                current = current.right;
                nodeName = current.toString();
                logWrite(nodeName);
            }
        }
        if (current == null) {
            return null;
        } else {
            return current.data;
        }
    }

    /**
     * Returns the number of members in the database
     *
     * @pre true
     * @return number of members in the database.
     */
    @Override
    public int size() {
        return entries;
    }

    /**
     * Determines if the database is empty or not.
     *
     * @pre true
     * @return true if the database is empty
     */
    @Override
    public boolean isEmpty() {
        return entries != 0;
    }

    /**
     * Inserts a Member object into the database, with the key of the supplied
     * member's name.Note: If the name already exists as a key, then then the
     * original entry is overwritten.This method must return the previous
     * associated value if one exists, otherwise null
     *
     * @param member
     * @return
     * @pre member not null and member name not empty string
     */
    @Override
    public Member put(Member member) {
        previous = null;
        root = insert(root, member);
        Member logGetMemb = get(member.name);
        logWrite(logGetMemb.getName());
        
                return previous;
        
        
    }

    /**
     * Removes and returns a member from the database, with the key the supplied
     * name.
     *
     * @param name The name (key) to remove.
     * @pre name not null and name not empty string
     * @return the removed member object mapped to the name, or null if the name
     * does not exist.
     */
    @Override
    public Member remove(String name) {
        // based on Object-Oriented Programming in Oberon-2
        // Hanspeter Mössenböck Springer-Verlag 1993, page 78
        // transcribed into Java by David Lightfoot

        assert !name.isEmpty() && !name.equals("");

        Node parent = null, del, p = null, q = null;
        Member result;
        del = root;
        while (del != null && !del.data.getName().equals(name)) {
            parent = del;
            if (name.compareTo(del.data.getName()) < 0) {
                del = del.left;
            } else {
                del = del.right;
            }
        }// del == null || del.data.getName().equals(name))

        if (del != null) { // del.data.getName().equals(name)
            // find the pointer p to the node to replace del 
            if (del.right == null) {
                p = del.left;
            } else if (del.right.left == null) {
                p = del.right;
                p.left = del.left;
            } else {
                p = del.right;
                while (p.left != null) {
                    q = p;
                    p = p.left;
                }
                q.left = p.right;
                p.left = del.left;
                p.right = del.right;
            }
            if (del == root) {
                root = p;
            } else if (del.data.getName().compareTo(parent.data.getName()) < 0) {
                parent.left = p;
            } else {
                parent.right = p;
            }
            // reduce size of tree by one
            entries--;
            result = del.data;
        } else {
            result = null;
        }

        return result;
    }

    public void inOrderTraversal(Node tree) {
        if(tree != null){
        inOrderTraversal(tree.left);
        System.out.println(tree.data);
        inOrderTraversal(tree.right);}
        }
    

    /**
     * Prints the names and affiliations of all the members in the database in
     * alphabetic order.
     *
     * @pre true
     */
    @Override
    public void displayDB() {
        //inOrderTraversal : 5 lines (+/-)
        inOrderTraversal(root);

    }
    
    public void logWrite(String val){
    try{
        FileWriter log = new FileWriter("log.txt", true);
        log.write(val);
        log.write("\r\n" + "" + "\r\n");
        log.close();
        
    }
    
    catch (IOException e){
    }
    }

}
