/*****************************************
 ** File: Driver.java
 ** Project: Password Verification
 ** Author:  Leonardo Tulod and Rimsha Maredia
 ** Date:   11/4/2020
 ** Section: 501
 ** E-mail:  latulod@tamu.edu
 ** E-mail:  rimsha.maredia@tamu.edu
 ** Description: My partner and I implemented a 4 node Merkle tree that acts as a password verification service for individual users.
 *               Each user has their own 4 node Merkle tree.
 *              The two leaf nodes will include strings that include the correct password on the left and the user-entered password on the right.
 *              The root will have the resulting hash of the concatenated string of the two nodes and the top node will have the concatenated hash of the correct password.
 *              We gave users access to a hash value that could be checked by any IT department head for safe and efficient storage and transfer of passwords.
 *              The resulting hash instantly changes when a user enters a new password and the root node has a hash of the two leaf nodes that store data.
 ** This file contains the Preliminary Project Application and Description  for Project 1.

 ***********************************************/

import java.util.*;
import java.io.*;

public class Driver {

public static void main(String [] args){
    Node n1 = new Node(); //create node object
    Compare c = new Compare(); //create compare object
    String Password = null;
    System.out.println("Enter the filename that has correct password");
    Scanner newobj = new Scanner(System.in);// we grab user input for our correct password
    Scanner filename = new Scanner(System.in);
    File myObj = new File(filename.next());
    ArrayList<String> store = new ArrayList<>();
    try {
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()){
            store.add(myReader.nextLine());
            Password =store.get(0);
        }
        myReader.close();

        System.out.println("Enter the password to check");
        store.add(newobj.nextLine());
        String Password2 = store.get(1);
        Tree righty = new Tree();
        righty.setRight(Password2); // sets Right password, which holds the half the user entered
            Tree lefty = new Tree();
            lefty.left = Password;
            n1.setPassword(Password);
            c.setCombinedHash(lefty, righty); //gets combined hash of correct half and user half
            System.out.println();
            if (n1.gethash() == c.getCombinedHash()) { //getCombinedhash() uses the collections interface method to get the hash of the password
                System.out.println("Password are the same. You entered the correct password");
                System.out.println("The correct hash : " + n1.gethash()); //gethash() uses the collections interface method to get the hash of the password

            } else {
                try {
                    System.out.println("Passwords are different. Please reach out to the IT department for resetting the password");
                    String temp = new String(String.valueOf(n1.gethash()));
                    FileWriter writer = new FileWriter(temp+".txt");
                    writer.write("Hash of correct password");
                    System.out.println("Hash of the correct password: "+n1.gethash());

                    writer.write(" ");
                    writer.write(temp);
                    writer.write("\n");
                    writer.write("Correct password: ");
                    writer.write(store.get(0));
                    writer.write("\n");
                    System.out.println("Hash of the user entered/incorrect password: "+ c.getCombinedHash());


                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}

}
