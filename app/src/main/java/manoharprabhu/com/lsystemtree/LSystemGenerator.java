package manoharprabhu.com.lsystemtree;

import java.io.BufferedReader;
import java.util.Map;

/**
 * Created by manoharprabhu on 14/9/16.
 */
public class LSystemGenerator {
    private String start;
    private Map<String, String> rules;

    public LSystemGenerator(String start, Map<String, String> rules) {
        this.start = start;
        this.rules = rules;
    }

    public String getStateAtIteration(int n) {
        String current = this.start;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            builder.setLength(0);
            for(int index = 0; index < current.length(); index++) {
                if(this.rules.containsKey(String.valueOf(current.charAt(index)))) {
                    builder.append(this.rules.get(String.valueOf(current.charAt(index))));
                } else {
                    builder.append(current.charAt(index));
                }
            }
            current = builder.toString();
        }
        return current;
    }
}
