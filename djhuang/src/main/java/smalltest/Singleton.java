package smalltest;

public class Singleton {
    private static final Singleton singleInstance = new Singleton();

    public static Singleton getSingleInstance() {
        return singleInstance;
    }

    private Singleton(){
    }
}
