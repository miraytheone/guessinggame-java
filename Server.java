import java.net.*;
import java.io.*;
import java.util.Random;

public class Server {
     

    public static void main(String args[]) throws IOException
    {
        int answer,guess;
        final int MAX=10;
        boolean correctanswer = false;
        int counter=0;  
         try (ServerSocket ss = new ServerSocket(5000)) {
             Socket s = ss.accept();
             Random  randomnumber = new Random();//basically creating random num with rand function
             answer = randomnumber.nextInt(MAX) + 1;
             System.out.println("SERVER: Random number is " +answer);
             int result;
             while(!correctanswer)
             {
                 InputStreamReader in = new InputStreamReader(s.getInputStream());
                 BufferedReader bf = new BufferedReader(in);
                 
                 guess =Integer.parseInt( bf.readLine());;
                 System.out.println("SERVER: Your Guess is = " +guess);
                 
                 if(counter == 2 && guess != answer)
                 {
                     result=1;
                     System.out.println("SERVER: You lost! Answer was " +answer);
                     PrintWriter Responsive_Result = new PrintWriter(s.getOutputStream(),true);
                     Responsive_Result.println(result);
                     correctanswer = true;
                     break;
                 }
                 
                 if(guess == answer)
                 {
                     result=2;
                     System.out.println("SERVER: You won!");
                     PrintWriter Responsive_Result = new PrintWriter(s.getOutputStream(),true);
                     Responsive_Result.println(result);
                     correctanswer = true;
                     counter++;
                 }
                 else if(guess > answer)
                 {
                     result =3;
                     System.out.println("SERVER: LOWER");
                     PrintWriter Responsive_Result = new PrintWriter(s.getOutputStream(),true);
                     Responsive_Result.println(result);
                     counter++;
                 }
                 else if(guess < answer)
                 {
                     result =4;
                     System.out.println("SERVER: HIGHER");
                     PrintWriter Responsive_Result = new PrintWriter(s.getOutputStream(),true);
                     Responsive_Result.println(result);
                     counter++;
                 }
                 
             }}
    }
}
