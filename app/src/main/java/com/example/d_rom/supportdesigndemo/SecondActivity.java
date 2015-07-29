package com.example.d_rom.supportdesigndemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout mFieldOneLayout;
    private EditText mFieldOneEdit;
    private TextInputLayout mCustomLayout;
    private EditText mCustomEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mCustomLayout = (TextInputLayout) findViewById(R.id.tilCustom);
        mCustomEdit = (EditText) findViewById(R.id.etCustom);

        mFieldOneLayout = (TextInputLayout) findViewById(R.id.tilFieldOne);
        mFieldOneEdit = (EditText) findViewById(R.id.etFieldOne);

        EditText etFieldThree = (EditText) findViewById(R.id.etFieldThree);
        etFieldThree.setHint("Dynamic EditText Hint");

        TextInputLayout tilFieldFour = (TextInputLayout) findViewById(R.id.tilFieldFour);
        tilFieldFour.setHint("Dynamic TextInputLayout Hint");

        findViewById(R.id.cardViewButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(mFieldOneEdit.getText().toString())) {
            mFieldOneLayout.setError("Type some text");
        }else {
            mFieldOneLayout.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(mCustomEdit.getText().toString())) {
            mCustomLayout.setError("Type some text");
        }else {
            mCustomLayout.setErrorEnabled(false);
        }
    }
}
