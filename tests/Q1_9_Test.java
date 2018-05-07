import org.junit.Test;

import static CTCI.Q1_9_StringRotate.isRotation;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q1_9_Test {

    @Test
    public void isRotationTest() {
        String[][] pairs = {{"pleap", "apple"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}, {"invalid", "valiind"}};
        int index = 0;
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            index++;
            boolean result = isRotation(word1, word2);
            if (index >= 3) {
                assertFalse(result);    //Final 2 test cases are not valid rotations
            }
            else {
                assertTrue(result);
            }
        }
    }
}
