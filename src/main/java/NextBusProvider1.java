

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.*;

public class NextBusProvider1 implements INextBusProvider{
    private static NextBusProvider1 single_instance = null;
    private String query = "http://chilp.it/6976f71"; //+{lineId}

    //singleton design pattern
    private NextBusProvider1(){
    }

   public static NextBusProvider1 getInstance(){
        if (single_instance == null) {
            single_instance = new NextBusProvider1();
        }

        return single_instance;
    }

    public void setQuery(String query) { //needed?
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public List<StopEta> getLineEta (int lineId, String lineNumber) throws Exception {
        List<StopEta> stopsEtaList;
        //create an http request handler that sends an http request to the API with the lineId http://ag1.com/query/{lineId}
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this.query); // +{/line id} needs to be added
        String response = requestHandler.run();
        stopsEtaList = jsonStringToObj(response);

        return stopsEtaList;
    }

    //parses Json String to StopEta Objects.
    private List<StopEta>  jsonStringToObj(String jsonString){
        JsonObject obj = new JsonParser().parse(jsonString).getAsJsonObject();
        List<StopEta> stopsEtaList = new ArrayList<StopEta>();

        JsonArray arrivals = obj.getAsJsonArray("arrivals");
        System.out.println("======== Parsing =========");
          for(int i = 0 ; i<arrivals.size() ; i++){
             String id = ((JsonObject)(arrivals.get(i))).get("stopId").toString();
             String eta = ((JsonObject)(arrivals.get(i))).get("eta").toString();
             Date time = new Date(Integer.parseInt(eta));
             StopEta stopEta = new StopEta(Integer.parseInt(id),time);
             System.out.print("StopEta "+(i+1) + ": ");stopEta.print();
             stopsEtaList.add(stopEta);
            }

          return stopsEtaList;
    }


}
