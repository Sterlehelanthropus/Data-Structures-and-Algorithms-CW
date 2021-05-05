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
public class MemberHashTable implements IMemberDB {

    private Node[] table;
    final int tableSize = 550;
    private int entries;
    private int loadFactor;

    public MemberHashTable() {
        table = new Node[tableSize];
        entries = 0;
        System.out.println("Hash Table");

    }

    private int hashFunc(String name) {
        int hashVal = ((name.charAt(0) + name.charAt(1)) * 5) % tableSize;
        return hashVal;

    }

    @Override
    public void clearDB() {
        assert table.length > 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    @Override
    public boolean containsName(String name) {
        assert table != null && !(name.isEmpty());
        boolean found = false;
        int index = hashFunc(name);
        Node current = table[index];
        while (!name.equals(current.data.getName())) {
            current = current.next;
        }
        //name.equals(current.data.getName())
            if (current.data.getName().equals(name)) {
                found = true;
            }

        
        return found;
    }

    @Override
    public Member get(String name) {
        assert !(name.isEmpty());
        Member memb = null;
        int index = hashFunc(name);
        Node current = table[index];
        while (current != null && !name.equals(current.data.getName())) {
            current = current.next;
        }
        //current == null || name.equals(current.data.getName())    
        if (name.equals(current.data.getName())) {
                memb = current.data;
            }
    loadFactor = entries / tableSize;
    System.out.println(memb.getName());
    System.out.println(index);
    System.out.println(loadFactor);
    System.out.println(entries);
        return memb;
    }

    @Override
    public int size() {
        return entries;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = false;
        if (table.length <= 0) {
            empty = true;
        }
        return empty;
    }

    @Override
    public Member put(Member member) {
        assert member != null && !member.name.isEmpty();
        String membName = member.name;
        Member prevMemb = null;
        int index = hashFunc(member.name);
        Node current = table[index];
        while (current != null && !membName.equals(current.data.getName())) {
            current = current.next;
        }
        //current == null || membName.equals(current.data.getName()))
        if (current == null) {
            Node newNode = new Node(member);
            newNode.next = table[index];
            table[index] = newNode;
            entries++;
        } else {
            prevMemb = current.data;
            current.data = member;
        }
    loadFactor = entries / tableSize;
    System.out.println(member.getName());
    System.out.println(index);
    System.out.println(loadFactor);
    System.out.println(entries);
        return prevMemb;
    }

    @Override
    public Member remove(String name) {
        assert !name.isEmpty() && !name.equals("");
        Member memb = null;
        int index = hashFunc(name);
        Node current = table[index];
        while (current != null && !name.equals(current.data.getName())) {
            current = current.next;
        }
        
        //current == null || name.equals(current.data.getName())
            if (current.data.getName().equals(name)) {
                memb = current.data;
                current.data = null;
            }
        
    loadFactor = entries / tableSize;
    System.out.println(memb.getName());
    System.out.println(index);
    System.out.println(loadFactor);
    System.out.println(entries);
    return memb;
    }

    @Override
    public void displayDB() {
        //use quick sort from slides
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println(table[i].data);
            }
        }
//        Arrays.sort(table);
//        System.out.println(Arrays.toString(table));
    }
}
