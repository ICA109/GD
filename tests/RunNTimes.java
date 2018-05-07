import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RunNTimes {
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0];
    }

    public RunNTimes() {
    }

    @Test
    public void runsTenTimes() {
        System.out.println("run");
    }

}
