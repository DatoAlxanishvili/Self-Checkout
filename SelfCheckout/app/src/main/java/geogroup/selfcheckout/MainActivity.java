package geogroup.selfcheckout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void sendName(String st)
    { Intent intent = new Intent(MainActivity.this,ScanActivity.class);
        intent.putExtra("marketName", st);
        startActivity(intent);
    }


    public void onClick(View v) {
        String marketName = "";
            switch (v.getId()) {
                case R.id.smart:
                    marketName = "smart";
                    sendName(marketName);
                    break;

                case R.id.gudvili:
                    marketName = "gudvili";
                    sendName(marketName);
                    break;

                case R.id.ioli:
                    marketName = "ioli";
                    sendName(marketName);
                    break;

                case R.id.nugeshi:

                    break;

                case R.id.oriNabiji:

                    break;

                case R.id.karfuri:

                    break;

            }
        }

    }

