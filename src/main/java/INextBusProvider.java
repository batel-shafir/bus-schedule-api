import java.io.IOException;
import java.util.List;

public interface INextBusProvider {

     List<StopEta> getLineEta( int lineId, String lineNumber) throws Exception;

}
