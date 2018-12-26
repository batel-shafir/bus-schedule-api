import java.util.List;

public class NextBusProvider2 implements INextBusProvider{

    private static NextBusProvider2 single_instance = null;
    private String query;

    private  NextBusProvider2(){
    }

    public static NextBusProvider2 getInstance(){
        if (single_instance == null)
            single_instance = new NextBusProvider2();

        return single_instance;
    }

    public List<StopEta> getLineEta(int lineId, String lineNumber){

        return null;
    }


}