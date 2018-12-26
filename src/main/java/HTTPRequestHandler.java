import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public class HTTPRequestHandler {

    private String query;

    public HTTPRequestHandler(String query) {
        this.query = query;
    }

    public void setUrl(String query) {
        this.query = query;
    }
    public String getQuery(){
        return this.query;
    }


    public String run() throws Exception {

        String url = this.query;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        System.out.println("\n======== Request ========");
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        int responseCode = con.getResponseCode();
        System.out.println("Sending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String

        System.out.println("The returned Json object is : " +response.toString());
        return response.toString();

    }
}



