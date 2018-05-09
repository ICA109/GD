import org.junit.Test;

import static CTCI.Q1_4_IsPalPerm.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q1_4_Test {

    @Test
    public void canCreatePalPermTest() {

        String[] stringsTrue = {"aaa", "bbbb", "Tact Coa","Rats live on no evil star", "A man a plan a canal panama", "A man, a plan, a canal, panama","Lleve", "Tacotac"};
        String[] stringsFalse = {"asda"};

        for (String s : stringsTrue) {
            assertTrue(canCreatePalPerm(s));
        }

        for (String s : stringsFalse) {
            assertFalse(canCreatePalPerm(s));
        }
    }
}
