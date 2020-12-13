public class Node extends Nodebio { //Parent Class
    protected String password;
    protected int hashcode;

   public int gethash(){
       return hashcode;
   } //getter function for hashcode
   public String getPassword(){
       return password;
   } //getter function for password
   public void setPassword(String newpass){ //takes the correct password, so abc becomes abcabc. abcabc will be what gets converted using the .hashCode() method
       password = newpass;
       String concat; //concates the passwords
       concat = newpass + newpass;
       hashcode = concat.hashCode(); //converts it to hashcode
   }
   public String getpass(){
       return password;
   } //returns the password


}
