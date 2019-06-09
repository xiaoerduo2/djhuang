package reflecttest;

public class A {
    private int anInt;

    public A(){}
    public A(int anInt){
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    private void info(){
        System.out.println("A类的info方法：anInt值是"+anInt);
    }

    @Override
    public String toString() {
        return "A[anInt="+anInt+"]";
    }
}
