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
public class Member implements IMember{
    public String name;
    public String affiliation;
    
    public Member (String name, String affiliation){
    this.name = name;
    this.affiliation = affiliation;
    
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public String getAffiliation(){
        return this.affiliation;
    }
    
    @Override
    public String toString(){
        return this.name + " " + this.affiliation;
        
    }
    
    
    

    
    
}
