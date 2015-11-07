package geogroup.selfcheckout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vano on 11/6/2015.
 */
public class ScanActivity extends AppCompatActivity{
    static ArrayList<ProductObj> productObjs = new ArrayList<>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_layout);

       listview = (ListView) findViewById(R.id.productList);

        String barCode=null;

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
        barCode = bundle.getString("barCode");
        getIntent().removeExtra("barCode");}
        if(barCode != null)
        {
            ProductObj productObjs1 = new ProductObj(barCode,2);
            productObjs.add(productObjs1);

            ListAdapter listAdapter = new ListAdapter(ScanActivity.this,productObjs);
            listview.setAdapter(listAdapter);

            listAdapter.notifyDataSetChanged();
        }



  /*  if(!productObjs.isEmpty())
    {
        listAdapter = new ListAdapter(ScanActivity.this,productObjs);
        listview.setAdapter(listAdapter);

    }*/

      /*  for (int i = 0; i < Product.name.length;i++) {
            ProductObj productObj = new ProductObj(Product.name[i],Product.price[i]);
            productObjs.add(productObj);
        }*/


        Button button = (Button) findViewById(R.id.scanButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScanActivity.this, ScanBarCode.class);

                startActivity(intent);
            }
        });


    }

    //back knopkis gadatvirtva

     public void onBackPressed()
    {
       super.onBackPressed();
        Intent intent = new Intent(ScanActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        productObjs.clear();
        startActivity(intent);
        this.finish();
    }

}
