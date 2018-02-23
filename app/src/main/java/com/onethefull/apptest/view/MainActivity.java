package com.onethefull.apptest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.onethefull.apptest.R;


public class MainActivity extends AppCompatActivity {

    FragmentApp fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new FragmentApp();
        Bundle bundle = new Bundle();
        bundle.putString("key", "value");
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.bottomFragment, fragment).commit();

        Button popBtn = (Button) findViewById(R.id.popBtn);
        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.onCategory(1);
                Toast.makeText(getApplicationContext(), "인기 앱 확인", Toast.LENGTH_LONG).show();
                Log.v("popFragment","ok");
            }
        });

        Button freeBtn = (Button) findViewById(R.id.freeBtn);
        freeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.onCategory(2);
                Toast.makeText(getApplicationContext(), "무료 앱 확인", Toast.LENGTH_LONG).show();
                Log.v("freeFragment","ok");
            }
        });

        Button paidBtn = (Button) findViewById(R.id.paidBtn);
        paidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.onCategory(3);
                Toast.makeText(getApplicationContext(), "유료 앱 확인", Toast.LENGTH_LONG).show();
                Log.v("paidFragment","ok");
            }
        });


    }
}
