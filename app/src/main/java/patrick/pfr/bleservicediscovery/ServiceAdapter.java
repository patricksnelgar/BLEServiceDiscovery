package patrick.pfr.bleservicediscovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hrtwps on 22/08/2016.
 */
public class ServiceAdapter extends ArrayAdapter<Service> {


    public ServiceAdapter(Context context, ArrayList<Service> mServices) {
        super(context, 0, mServices);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Service s = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_view, parent, false);
        }

        TextView mMain = (TextView) convertView.findViewById(R.id.service_id);
        TextView mData = (TextView) convertView.findViewById(R.id.service_data);

        mMain.setText(s.getServiceID());
        mData.setText(s.getData(0));

        return convertView;

    }
}