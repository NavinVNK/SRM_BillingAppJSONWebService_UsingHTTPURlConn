package com.comlu.navinsandroidtutorial.srm_billingappjsonwebservice;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView t=(TextView)findViewById(R.id.resultText);
        Bundle bundle = getIntent().getExtras();
        t.setText("" + bundle.getDouble("result"));
    }


}