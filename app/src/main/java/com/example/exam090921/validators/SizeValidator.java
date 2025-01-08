package com.example.exam090921.validators;

import android.view.View;
import android.widget.EditText;

public class SizeValidator implements View.OnFocusChangeListener{
    private int min;

    public SizeValidator(int min) {
        this.min = min;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        EditText editText = (EditText) v;

        if(editText.getText().toString().length()<min){
            editText.setError("Invalid text size!");
        }
    }
}
