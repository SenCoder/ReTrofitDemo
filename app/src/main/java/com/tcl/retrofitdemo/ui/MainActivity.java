package com.tcl.retrofitdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tcl.retrofitdemo.R;
import com.tcl.retrofitdemo.model.GitModel;

public class MainActivity extends AppCompatActivity {

    private GitModel mGitModel;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_result);

        mGitModel = new GitModel(mTextView);

        mGitModel.getUser("basil2style");
        mGitModel.getWeather("4ea58de8a7573377cec0046f5e2469d5");

    }
}
