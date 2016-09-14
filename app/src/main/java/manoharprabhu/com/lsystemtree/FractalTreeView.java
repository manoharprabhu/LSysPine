package manoharprabhu.com.lsystemtree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manoharprabhu on 14/9/16.
 */
public class FractalTreeView extends View {
    Paint paint = new Paint();
    LSystemGenerator lSystemGenerator;
    int iterations = 0;
    int segmentLength = 2;
    int controlAngle = 25;

    public FractalTreeView(Context context, LSystemGenerator generator, int iterations) {
        super(context);
        paint.setColor(Color.rgb(0, 100, 0));
        this.lSystemGenerator = generator;
        this.iterations = iterations;
    }

    @Override
    public void onDraw(Canvas canvas) {
        //canvas.drawLine(0, 0, 20, 20, paint);
        paint.setAntiAlias(true);
        paint.setDither(false);
        String state = this.lSystemGenerator.getStateAtIteration(iterations);
        Deque<PositionAngle> stack = new ArrayDeque<>();
        PositionAngle currentPosition = new PositionAngle(250, 750, 0);
        for(char current : state.toCharArray()) {
            if(current == 'F') {
                currentPosition = this.drawLine(currentPosition, canvas);
            } else if(current == '-') {
                currentPosition = new PositionAngle(currentPosition.getX(), currentPosition.getY(), currentPosition.getAngle() - controlAngle);
            } else if(current == '+') {
                currentPosition = new PositionAngle(currentPosition.getX(), currentPosition.getY(), currentPosition.getAngle() + controlAngle);
            } else if(current == '[') {
                stack.push(currentPosition);
            } else if(current == ']') {
                currentPosition = stack.pop();
            }
        }
    }

    private PositionAngle drawLine(PositionAngle startPosition, Canvas canvas) {
        float x1= startPosition.getX();
        float y1 = startPosition.getY();
        int angle = startPosition.getAngle();
        float x2 = (float)(-1*this.segmentLength * Math.sin(Math.toRadians(-1*angle)) + x1);
        float y2 = (float)(-1*this.segmentLength * Math.cos(Math.toRadians(-1*angle)) + y1);
        canvas.drawLine(x1, y1, x2, y2, this.paint);
        return new PositionAngle(x2, y2, angle);
    }
}
