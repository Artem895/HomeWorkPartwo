package netshool;


import java.util.Arrays;

public class MyPolinomial {
    private double[] coeffs=new double[100];
    private int[] grad=new int[100];

    public MyPolinomial(double ...coeffs) {
        this.coeffs=coeffs;
        for(int i=0;i<=coeffs.length-1;i++){
            this.grad[i]=i;
        }
    }

    public void getCoeffs() {
        for (int i=0; i<=coeffs.length-1; i++){
            System.out.println(coeffs[i]);
        }
        for (int i=0; i<=coeffs.length-1; i++) System.out.println(grad[i]);
    }
    public int getDegree(){
        return this.coeffs.length-1;
    }
    public MyPolinomial addto(MyPolinomial right){
        MyPolinomial newpolim =new MyPolinomial();
        if(this.coeffs.length>=right.coeffs.length){
            newpolim.coeffs=this.coeffs;
            for (int i=right.coeffs.length-1;i>=0;i--){
                newpolim.coeffs[i]+=right.coeffs[i];
            }
        }
        else {
            newpolim.coeffs=right.coeffs;
            for (int i=this.coeffs.length-1;i>=0;i--){
                newpolim.coeffs[i]+=this.coeffs[i];
            }
        }
        return newpolim;
    }
    public MyPolinomial mult(MyPolinomial right){
        MyPolinomial newpolim= new MyPolinomial();
        newpolim.coeffs= new  double[(this.coeffs.length)*(right.coeffs.length)];
        MyPolinomial resalt= new MyPolinomial();
        int k=0;
        for(int i=0;i<=this.coeffs.length-1;i++) {
            for (int j = 0; j <= right.coeffs.length-1; j++) {
                newpolim.coeffs[k] = this.coeffs[i] * right.coeffs[j];
                newpolim.grad[k] = i + j;
                k++;
            }
            //k++;
        }
        for(int i=0;i<=newpolim.coeffs.length-1;i++){
            for(int j=0;j<=k-1;j++){
                if(newpolim.grad[i]==newpolim.grad[j]&&i!=j&&newpolim.grad[i]!=99999){
                    newpolim.coeffs[i]+=newpolim.coeffs[j];
                    newpolim.coeffs[j]=0;
                    newpolim.grad[j]=99999;
                    k--;
              }
          }
        }
        resalt.coeffs=new double[k];
        int v=-1;
        for(int i=0;i<=newpolim.coeffs.length-1;i++){
            if(!this.isEqual(newpolim.coeffs[i],0)){
                v++;
                resalt.coeffs[v]=newpolim.coeffs[i];
                resalt.grad[v]=newpolim.grad[i];

            }
            else {
                continue;
            }
        }
        return resalt;
    }
    private boolean isEqual(double x,double y){
        double eps=0.0000001;
        return Math.abs(x-y) < eps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolinomial that = (MyPolinomial) o;
        return Arrays.equals(this.coeffs, that.coeffs) && Arrays.equals(this.grad, that.grad);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(coeffs);
        result = 31 * result + Arrays.hashCode(grad);
        return result;
    }

    @Override
    public String toString() {
        int n =this.coeffs.length-1;
        String res=String.format("%.2f*x^(%d)",coeffs[n],grad[n]);
        for(int i= coeffs.length-2;i>=0;i--,n--){
            if(i==0){
                res+=String.format("+%.2f",coeffs[i]);
            }
            else if(i==1){
                res+=String.format("+%.2f*x",coeffs[i]);

            }
            else {
            res+=String.format("+%.2f*x^(%d)",coeffs[i],grad[n-1]);
            }
        }
        return res;
    }
}



