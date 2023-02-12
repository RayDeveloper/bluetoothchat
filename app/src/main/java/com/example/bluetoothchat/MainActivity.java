package com.example.bluetoothchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBluetooth();
    }

    private void initBluetooth() {//check if device has bluetooth capabilities
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "No Bluetooth Found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("MissingPermission")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_search_devices:
                Toast.makeText(this, "Search Devices", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_enable_bluetooth:

                if (bluetoothAdapter.isEnabled()) {

                    Toast.makeText(this, "Bluetooth already enabled", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Turning on Bluetooth", Toast.LENGTH_SHORT).show();
                    bluetoothAdapter.enable();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }

}