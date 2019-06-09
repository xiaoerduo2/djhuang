package reflecttest;

public class B {
    private String string;

    public B(){}

    public B(String s){
        this.string = s;
    }

    public String getString() {
        return string;
    }


    public void setString(String string) {
        this.string = string;
    }

    public void info(){
        System.out.println("B类的info方法，string="+string);
    }

    @Override
    public String toString() {
        return "B[string="+string+"]";
    }

    public static void main(String args[]){
       System.out.println(B.class.getName());
    }
}
