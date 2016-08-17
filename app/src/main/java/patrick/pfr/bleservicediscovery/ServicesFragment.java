package patrick.pfr.bleservicediscovery;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hrtwps on 17/08/2016.
 */
public class ServicesFragment extends android.support.v4.app.Fragment {

    private List<String> mListServices;
    private MainActivity mParentActivity;

    public ServicesFragment() {
        super();
    }

    public static ServicesFragment newInstance(MainActivity mParent) {
        ServicesFragment sFrag = new ServicesFragment();
        sFrag.mParentActivity = mParent;
        Bundle args= new Bundle();
        sFrag.setArguments(args);
        return sFrag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_services,container, false);
        return rootView;
    }
}
