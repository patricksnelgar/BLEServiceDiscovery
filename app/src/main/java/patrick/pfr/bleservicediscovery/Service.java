package patrick.pfr.bleservicediscovery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hrtwps on 22/08/2016.
 */
public class Service {
    private String serviceID;
    private List<String> service_data;

    public Service(String ID) {
        serviceID = ID;
        service_data = new ArrayList<>();
    }

    public Service(String ID, List<String> mData) {
        serviceID = ID;
        service_data = mData;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getData(int position) {
        return service_data.get(position);
    }
}

