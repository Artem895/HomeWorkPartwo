package netshool;
public class HomePartTwo {


    public static void main(String[] args){
        MyPolinomial myPolinomial =new MyPolinomial(4,2,3);
        MyPolinomial myPolinomial2 =new MyPolinomial(2,2,4);
        System.out.println(myPolinomial);
        System.out.println(myPolinomial2);
        System.out.println(myPolinomial.mult(myPolinomial2));
        /*MyBall ball= new MyBall(2,-3,1,2,45);
        Container cont=new Container(0,0,10,12);
        System.out.println(ball);
        System.out.println(cont);
        System.out.println(cont.collideas(ball));
        ball.move();
        System.out.println(cont.collideas(ball));
        System.out.println(ball);*/
    }
}
