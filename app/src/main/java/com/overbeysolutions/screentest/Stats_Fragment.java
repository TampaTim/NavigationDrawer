package com.overbeysolutions.screentest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

/**
 * Created by Tim on 3/26/2016.
 */
public class Stats_Fragment extends Fragment implements OnClickListener{

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_stats,container,false);


        Button buttonOne,buttonTwo;
        buttonOne = (Button) rootView.findViewById(R.id.button1);
        buttonTwo = (Button) rootView.findViewById(R.id.button2);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);


        return rootView;


    }

    public void onClick(View v) { // Parameter v stands for the view that was clicked.

        Fragment fragmentCurrentChallenge = new Current_Fragment();
        Fragment fragmentHistory = new History_Fragment();

// Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getFragmentManager();



        // getId() returns this view's identifier.
        if(v.getId() == R.id.button1){
//            // setText() sets the string value of the TextView
//            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "button1", Toast.LENGTH_SHORT);
//            toast.show();
            //mIsMainActivityShown = false;
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragmentCurrentChallenge)
                    .addToBackStack("Current")
                    .commit();

        }else if(v.getId() == R.id.button2){
//            //changingTextView.setText("You clicked Second");
//            Toast toast = Toast.makeText(getActivity().getApplicationContext()  , "button2", Toast.LENGTH_SHORT);
//            toast.show();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragmentHistory)
                    .addToBackStack("History")
                    .commit();
        }
    }



}
