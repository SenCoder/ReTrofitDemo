package com.tcl.retrofitdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tcl.retrofitdemo.R;
import com.tcl.retrofitdemo.model.GitModel;

public class MainActivity extends AppCompatActivity {

    private GitModel mGitModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGitModel = new GitModel();
        mGitModel.getUser("basil2style");

    }
}
