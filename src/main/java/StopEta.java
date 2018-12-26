import java.util.Date;

public class StopEta {
    private int stopId;
    private Date eta;

    public StopEta(int stopId, Date eta){
        this.stopId = stopId;
        this.eta = eta;
    }
    //setters
    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }
    //getters
    public int getStopId() {
        return stopId;
    }

    public Date getEta() {
        return eta;
    }

    public void print(){
        System.out.println("Stop Id="+this.stopId+", Estimated time of arrival="+this.eta);
    }
}
