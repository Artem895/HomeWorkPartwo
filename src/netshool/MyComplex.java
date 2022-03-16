package netshool;

import java.util.Objects;

public class MyComplex {
    private double real=0.0;
    private double image=0.0;

    public MyComplex() {
    }

    public MyComplex(double real,double image) {
        this.real = real;
        this.image=image;
    }

    public double getReal() {
        return real;
    }

    public double getImage() {
        return image;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImage(double image) {
        this.image = image;
    }
    public void setValue(double real,double image){
        this.real = real;
        this.image = image;
    }
    public boolean IsImage(){
        return image != 0.0;
    }
    public boolean IsReal(){
        return !(this.IsImage());
    }
    public double magnitude(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(image,2));
    }
    public double argument(){
        return Math.atan(image/real);
    }
    public MyComplex add(MyComplex right){
        this.real+=right.real;
        this.image+=right.image;
        return this;
    }
    public MyComplex addNew(MyComplex right){
        MyComplex newmycomplex= new MyComplex();
        newmycomplex.real=this.real+right.real;
        newmycomplex.image=this.image+right.image;
        return newmycomplex;
    }
    public  MyComplex substract(MyComplex right){
        this.real-=right.real;
        this.image-=right.image;
        return this;
    }
    public MyComplex substractNew(MyComplex right){
        MyComplex newmycomplex= new MyComplex();
        newmycomplex.real=this.real-right.real;
        newmycomplex.image=this.image-right.image;
        return newmycomplex;
    }
    public MyComplex divided(MyComplex right){
        this.real/=right.real;
        this.image/=right.image;
        return this;
    }
    public MyComplex multiply(MyComplex right){
        this.real*=right.real;
        this.image*=right.image;
        return this;
    }
    public MyComplex conjugate(){
        this.image=0-this.image;
        return this;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj== null) return false;
        if ( getClass() != obj.getClass()) return false;
        MyComplex complex= (MyComplex) obj;
        return image==complex.image && real==complex.real;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real,image);
    }

    @Override
    public String toString() {
        if(image>=0){
        return String.format("(%.2f + %.2fi)",real,image);
        }
        else return String.format("(%.2f - %.2fi)",real,Math.abs(image));
    }
}
