package design_patterns.singleton;

/**
 * Created by gorobec on 05.06.16.
 */
public class Singleton {

    public static volatile Singleton INSTANCE;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
