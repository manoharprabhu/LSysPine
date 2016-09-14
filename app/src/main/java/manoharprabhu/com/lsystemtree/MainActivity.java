package manoharprabhu.com.lsystemtree;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String start = "X";
        Map<String, String> rules = new HashMap<>();
        rules.put("X", "F-[[X]+X]+F[+FX]-X");
        rules.put("F", "FF");
        final LSystemGenerator generator = new LSystemGenerator(start, rules);
        setContentView(new FractalTreeView(this, generator, 7));
    }
}
