package SingleTon;
public class EagerSingleton {
    String Name="Afzal";
    private static final EagerSingleton EagerObject = new EagerSingleton();
    //private constructor to avoid client applications to use constructor
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return EagerObject;
    }
}
