package manoharprabhu.com.lsystemtree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class LSystemGeneratorTest {

    @Test
    public void testFractalPlantGenerator() throws Exception {
        String start = "X";
        Map<String, String> rules = new HashMap<>();
        rules.put("X", "F-[[X]+X]+F[+FX]-X");
        rules.put("F", "FF");
        LSystemGenerator generator = new LSystemGenerator(start, rules);
        assertEquals(generator.getStateAtIteration(0), "X");
        assertEquals(generator.getStateAtIteration(1), "F-[[X]+X]+F[+FX]-X");
        assertEquals(generator.getStateAtIteration(2), "FF-[[F-[[X]+X]+F[+FX]-X]+F-[[X]+X]+F[+FX]-X]+FF[+FFF-[[X]+X]+F[+FX]-X]-F-[[X]+X]+F[+FX]-X");
    }
}