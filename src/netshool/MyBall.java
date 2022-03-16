package netshool;

public class MyBall {
    private float x;
    private float y;
    private int radius;
    private float xdelt;
    private float ydelt;

    public MyBall(float x,float y,int radius,int speed,int direction) {
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.xdelt= (float) (speed*Math.cos(direction));
        this.ydelt= (float) (-speed*Math.sin(direction));

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public float getXdelt() {
        return xdelt;
    }

    public float getYdelt() {
        return ydelt;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setXdelt(float xdelt) {
        this.xdelt = xdelt;
    }

    public void setYdelt(float ydelt) {
        this.ydelt = ydelt;
    }
    public  void move(){
        this.x+=this.xdelt;
        this.y+=this.ydelt;
    }
    public void reflectHorizontal(){
        this.xdelt=-this.xdelt;
    }
    public void reflectVertical(){
        this.ydelt=-this.ydelt;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "(" + x +
                "," + y +
                "), speed=(" + xdelt +
                "," + ydelt +
                ")}";
    }
}
