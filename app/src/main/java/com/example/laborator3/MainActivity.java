package com.example.laborator3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPre, btnNext, btnDet;
    public FrameLayout frameLayout;
    public static String frg="fragment1";

    public Fragment1 fragment1;
    public Fragment2 fragment2;
    public Fragment3 fragment3;
    public Fragment4 fragment4;
    public Fragment5 fragment5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPre = findViewById(R.id.pre);
        btnPre.setEnabled(false);
        btnNext = findViewById(R.id.next);
        frameLayout = findViewById(R.id.frameLayout);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        replaceFragment(fragment1);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentFragment() instanceof Fragment1) {
                    replaceFragment(fragment2);
                    btnPre.setEnabled(true);
                   // frg="fragment2";
                } else if (currentFragment() instanceof Fragment2) {
                    replaceFragment(fragment3);
                   // frg="fragment3";
                } else if (currentFragment() instanceof Fragment3) {
                    replaceFragment(fragment4);
                   // frg="fragment4";
                } else if (currentFragment() instanceof Fragment4) {
                    replaceFragment(fragment5);
                   // frg="fragment5";
                    btnNext.setEnabled(false);
                }
//                else if (currentFragment() instanceof Fragment5){
//                    btnNext.setEnabled(false);
//                }
            }
        });

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentFragment() instanceof Fragment1) {
                } else if (currentFragment() instanceof Fragment2) {
                    replaceFragment(fragment1);
                    btnPre.setEnabled(false);
                   // frg="fragment1";
                } else if (currentFragment() instanceof Fragment3) {
                    replaceFragment(fragment2);
                    //frg="fragment2";
                } else if (currentFragment() instanceof Fragment4) {
                    replaceFragment(fragment3);
                    //frg="fragment3";
                } else if (currentFragment() instanceof Fragment5) {
                    replaceFragment(fragment4);
                   // frg="fragment4";
                    btnNext.setEnabled(true);
                }
            }
        });
    }

    public void onClickDetail(View view) {
        Intent intent_2;
        intent_2 = new Intent(this, MainActivity2.class);
        Toast.makeText(getApplicationContext(), "Opening details...", Toast.LENGTH_LONG).show();
        intent_2.putExtra("fragment",String.valueOf(currentFragment()).trim().substring(0,9));


        startActivity(intent_2);

    }

    public Fragment currentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.frameLayout);
    }

    private void replaceFragment(Fragment frag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, frag);
        fragmentTransaction.commit();

    }
}