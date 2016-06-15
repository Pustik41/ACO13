package design_patterns.singleton;

/**
 * Created by gorobec on 05.06.16.
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
    }
}
