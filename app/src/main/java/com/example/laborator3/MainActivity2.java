package com.example.laborator3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    String fragment;
    FragmentText1 fragmentText1 = new FragmentText1();
    FragmentText2 fragmentText2 = new FragmentText2();
    FragmentText3 fragmentText3 = new FragmentText3();
    FragmentText4 fragmentText4 = new FragmentText4();
    FragmentText5 fragmentText5 = new FragmentText5();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        fragment = intent.getStringExtra("fragment");
        System.out.println(fragment);

        if (fragment.equals("Fragment1")) {
            replaceFragment(fragmentText1);
        } else if (fragment.equals("Fragment2")) {
            replaceFragment(fragmentText2);
        } else if (fragment.equals("Fragment3")) {
            replaceFragment(fragmentText3);
        } else if (fragment.equals("Fragment4")) {
            replaceFragment(fragmentText4);
        } else if (fragment.equals("Fragment5")) {
            replaceFragment(fragmentText5);
        }
    }

    public void onClickBack(View v){
        Intent intent_1 = new Intent(this,MainActivity.class);
        Toast.makeText(getApplicationContext(),"Return...",Toast.LENGTH_LONG).show();

        startActivity(intent_1);
    }

    private void replaceFragment(Fragment frag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2, frag);
        fragmentTransaction.commit();

    }
}