package com.dogs.pet.mylocation;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity implements OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadLoginFragment();

    }

    private void loadLoginFragment(){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,new LoginFragment());
        fragmentTransaction.commit();
    }

    private void loadSignUpFragment(){
        replaceFragment(new SignupFragment());
    }

    private void loadMapFragment(){
        replaceFragment(MapFragment.newInstance(this));
    }

    private void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    @Override
    public void onButtonClick(View v) {

        switch (v.getId()){
            case R.id.btn_login:
                loadMapFragment();
                break;
            case R.id.btn_signup:
                break;
            case R.id.txt_signup:
                loadSignUpFragment();
                break;
        }

    }
}
