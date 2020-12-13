/*****************************************
 ** File: Compare.java
 ** Project: Password Verification
 ** Author:  Leonardo Tulod and Rimsha Maredia
 ** Date:    11/4/2020
 ** Section: 501
 ** E-mail:  latulod@tamu.edu
 ** E-mail:  rimsha.maredia@tamu.edu
 ** This file contains the Preliminary Project Application and Description  for Project 1.

 ***********************************************/
import java.util.*;

public class Compare extends Tree{ //Compare class inherits from Node class and Tree class to compare the hash codes generated from the node and trees.
    private int combinedHash;


    //function for printing the result
    public void printResult(Compare comp, Node node){
        if(comp.getCombinedHash()== node.gethash()){ // check if user password and correct password hashes are equal.
            System.out.println("Passwords are same");
        }else{
            System.out.println("Passwords are not same");
        }


    }
    //setter function for combined hash
    public void setCombinedHash(Tree leaf1, Tree leaf2){
    String concate = leaf1.left+leaf2.right; //concates new password with the original one to compare the hashcode
    combinedHash=concate.hashCode(); //converts the new string to hashcode
    }
    public int getCombinedHash(){
        return combinedHash;
    } //returns hashcode of the password


}
