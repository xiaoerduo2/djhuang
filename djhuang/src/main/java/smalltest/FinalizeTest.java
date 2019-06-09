package smalltest;

public class FinalizeTest {
    public static  FinalizeTest ft = null;

    public void info(){
        System.out.println("info");
    }
    public  static  void main(String[] args){
        new FinalizeTest();
        System.gc();
        //System.runFinalization();
        ft.info();
    }

    @Override
    protected void finalize() throws Throwable {
        ft = this;
    }
}
