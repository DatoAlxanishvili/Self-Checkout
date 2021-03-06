package geogroup.selfcheckout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by vano on 11/6/2015.
 */
public class ScanBarCode  extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
       String result = rawResult.getContents(); // Prints scan results
        Intent intent = new Intent(ScanBarCode.this,ScanActivity.class);
        intent.putExtra("barCode",result);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        this.finish();
        /*Log.v(TAG, rawResult.getBarcodeFormat().getName());*/ // Prints the scan format (qrcode, pdf417 etc.)
    }
}
