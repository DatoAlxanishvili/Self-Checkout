package geogroup.selfcheckout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vano on 11/6/2015.
 */
public class ScanActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_layout);

        Bundle bundle = getIntent().getExtras();
        String barCode = bundle.getString("barCode");

         TextView textView = (TextView) findViewById(R.id.sumText);
        textView.setText(barCode);



        ArrayList<ProductObj> productObjs = new ArrayList<>();

        for (int i = 0; i < Product.name.length;i++) {
            ProductObj productObj = new ProductObj(Product.name[i],Product.price[i]);
            productObjs.add(productObj);
        }




        final ListView listview = (ListView) findViewById(R.id.productList);
        ListAdapter listAdapter = new ListAdapter(ScanActivity.this,productObjs);
        listview.setAdapter(listAdapter);








        Button button = (Button) findViewById(R.id.scanButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScanActivity.this,ScanBarCode.class);
                startActivity(intent);
            }
        });



    }
}
