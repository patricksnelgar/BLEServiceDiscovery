package patrick.pfr.bleservicediscovery;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hrtwps on 22/08/2016.
 */
public class DevicesFragment extends Fragment {

    private MainActivity mParent;
    private Button mScanButton;
    private ArrayList<DiscoveredDevice> mDiscoveredDevices;
    private DeviceAdapter mDeviceAdapter;
    final ScanCallback mScanCallback = new ScanCallback() {
        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            Log.e("DevicesFragment", "Scan failed: " + errorCode);
        }

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            //super.onScanResult(callbackType, result);
            BluetoothDevice mScannedDevice = result.getDevice();
            if (mDiscoveredDevices == null) {
                mDiscoveredDevices = new ArrayList<>();
            }
            mDiscoveredDevices.add(
                    new DiscoveredDevice(
                            mScannedDevice.getName(), false, "", mScannedDevice.getAddress(), mScannedDevice));
            mDeviceAdapter.notifyDataSetChanged();
        }
    };
    final View.OnClickListener mScanForDevicesButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // SCAN
            Log.i("DeviceFragment", "You clicked a button!");
            BluetoothManager mBtManager = (BluetoothManager) getActivity().getSystemService(Context.BLUETOOTH_SERVICE);
            BluetoothAdapter mBtAdapter = mBtManager.getAdapter();
            BluetoothLeScanner mBtScanner = mBtAdapter.getBluetoothLeScanner();
            mBtScanner.startScan(mScanCallback);
        }
    };
    private ListView mDiscoveredDevicesListView;

    public DevicesFragment() {
        super();
    }

    public static DevicesFragment newInstance(MainActivity m) {
        DevicesFragment d = new DevicesFragment();
        d.mParent = m;
        Bundle args = new Bundle();
        d.setArguments(args);
        return d;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_devices, container, false);
        mScanButton = (Button) rootView.findViewById(R.id.button_scan);
        mScanButton.setOnClickListener(mScanForDevicesButton);
        mDeviceAdapter = new DeviceAdapter(getContext(), mDiscoveredDevices);
        mDiscoveredDevicesListView = (ListView) rootView.findViewById(R.id.list_devices);
        mDiscoveredDevicesListView.setAdapter(mDeviceAdapter);
        return rootView;
    }
}
