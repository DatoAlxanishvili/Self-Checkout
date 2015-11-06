package geogroup.selfcheckout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vano on 11/6/2015.
 */
public class ScanActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_layout);

        Bundle bundle = getIntent().getExtras();
        String marketName = bundle.getString("marketName");



       /* TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(marketName);*/

    }
}
