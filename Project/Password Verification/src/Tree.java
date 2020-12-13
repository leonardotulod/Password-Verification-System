/*****************************************
 ** File: Tree.java
 ** Project: Password Verification
 ** Author:  Leonardo Tulod and Rimsha Maredia
 ** Date:   11/4/2020
 ** Section: 501
 ** E-mail:  latulod@tamu.edu
 ** E-mail:  rimsha.maredia@tamu.edu
 ** This file contains the Preliminary Project Application and Description  for Project 1.

 ***********************************************/
import java.util.*;


class Tree extends Node{
    protected String left; //Uses generics because all types can be converted into strings
    protected String right; // converts all passwords to strings so you can have all integer passwords and it gets converted into string passwords


    public void setLeft(String newleft){
        left = newleft;
    } //setter function for left node

    public void setRight(String newright){
        right = newright;
    } //setter function for right node

}
