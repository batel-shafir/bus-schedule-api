import java.util.List;

public class NextBusManager implements  INextBusManager {
    //singleton design pattern
    private static NextBusManager single_instance = null;

    private NextBusManager(){
    }

    public static NextBusManager getInstance(){
        if (single_instance == null)
            single_instance = new NextBusManager();

        return single_instance;
    }
    public List<StopEta> getLineEta(int agencyId, int lineId, String lineNumber) throws Exception {
        INextBusProvider provider = null;
        /* We need to match the provider to the agencyId.
        I was asked - How can we keep the agencies of the providers?- I thought about it and maybe we can create for each provider a hash map
        and by contains(agencyId) - time complexity of O(1)*k providers we can know which provider to use.*/
        switch(agencyId){
            case 1 :
            case 2 :
            case 3 :
                {
                provider = NextBusProvider1.getInstance();
                break;

            }
            case 4:
            case 5 :
            case 6 :{
                provider = NextBusProvider2.getInstance();
                break;
            }
            default:
                System.out.println("Invalid agency.");
                break;
        }


        List<StopEta> stopsEtaList = provider.getLineEta(lineId, lineNumber);

        System.out.println("=====  stopsEtas List =====");
        System.out.println(stopsEtaList.toString());

        return stopsEtaList;
    }
}