import java.io.IOException;
import java.util.List;

public interface INextBusManager {
    List<StopEta> getLineEta(int agencyId, int lineId, String lineNumber) throws Exception;

}
