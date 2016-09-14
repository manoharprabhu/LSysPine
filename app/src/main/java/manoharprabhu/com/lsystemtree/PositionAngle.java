package manoharprabhu.com.lsystemtree;

/**
 * Created by manoharprabhu on 14/9/16.
 */
public class PositionAngle {
    private float x;
    private float y;
    private int angle;

    public PositionAngle(float x, float y, int angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
