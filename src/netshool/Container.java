package netshool;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1,int y1,int width,int height) {
        this.x1 = x1;
        this.y1=y1;
        this.x2=x1+width;
        this.y2=y1-height;

    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
    public int getWidth(){
        return x2-x1;
    }
    public int getHeight(){
        return y1-y2;
    }
    public boolean collideas(MyBall ball){
        boolean res=false;
        float bx= ball.getX();
        float by= ball.getY();
        int br= ball.getRadius();
        if(bx+br<=x2&&bx-br>=x1){
            if (by+br<=y1&&by-br>=y2){
                res=true;
            }
        }
        else if  (by+br<=y1&&by-br>=y2){
            if(bx+br<=x2&&bx-br>=x1){
                res=true;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Container{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
