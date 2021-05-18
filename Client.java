import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client_17290093 {
    
     
    public static void main(String[] args) throws IOException {
        
        boolean check=false;
        int control;
        Scanner guess;
        Scanner s1;
         try (Socket s = new Socket("127.0.0.1",5000)) {
             guess = new Scanner(System.in);
             s1 = new Scanner (s.getInputStream());
             int number;
             while(!check)
             {
                 System.out.println("Enter a number between 1-10");
                 number = guess.nextInt();
                 PrintWriter user_input = new PrintWriter(s.getOutputStream(),true);
                 user_input.println(number);
                 
                 InputStream in=s.getInputStream();
                 BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                 control=Integer.parseInt( bf.readLine());
                 
                 
                 if(control==1){
                     System.out.println("CLIENT: You lost! Answer was: " + number);
                      check = true;
                      break;
                 }
                 else if(control==2){
                     System.out.println("CLIENT: You won!");
                         check= true;
                         break;
                 }
                 else if(control==3){
                     System.out.println("CLIENT: LOWER!");
                    
                 }
                 else if(control==4){
                      System.out.println("CLIENT: HIGHER!!");
                       
                 }
                 
             }
         }
        s1.close();
        guess.close();
    }
}