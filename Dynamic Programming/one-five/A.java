import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
interface a {
    char type = 'a';
}
public class A implements a{
    
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(new A().type);
    }
}
