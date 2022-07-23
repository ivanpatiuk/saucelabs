import org.testng.annotations.Test;

public class SimpleTest {

    @Test(priority = 1)
    public void setup(){
        System.out.println("This is setup test");
    }

    @Test(priority = 2)
    public void login(){
        System.out.println("Loggin");
    }

    @Test(priority = 3)
    public void closeBrowser(){
        System.out.println("Closing browser");
    }
}
