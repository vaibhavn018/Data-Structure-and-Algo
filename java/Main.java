import java.io.*;
import java.net.*;

class Main {
    public static void main(String args[])
            throws Exception {

        // Create server Socket
        ServerSocket ss = new ServerSocket(888);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream ps = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        // to read data from the keyboard
        

        // server executes continuously

        String str, str1;

        // repeat as long as the client
        // does not send a null string

        // read from client
        while ((str = br.readLine()) != null) {
            if(isPalindrome(str)) {
                System.out.println("It is palindrome");
            } else {
                System.out.println("It is not palindrome");
            }
        }

        // close connection
        ps.close();
        br.close();
        
        ss.close();
        s.close();

        // terminate application
        System.exit(0);

    } // end of while

    private static boolean isPalindrome(String str, int i) {
        return true;
    }
}

class A {
    static int count;
    int totalObj;

    A() {
        count = count + 1;
        this.totalObj = count;

    }
}
