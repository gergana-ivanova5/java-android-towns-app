package com.example.exam090921.validators;

import android.view.View;
import android.widget.EditText;

import androidx.core.view.ViewCompat;

import java.util.regex.Pattern;

public class FormatValidator implements View.OnFocusChangeListener {

    private Pattern pattern;

    public FormatValidator(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        EditText editText = (EditText) v;

        if(!pattern.matcher(editText.getText()).matches()){
            editText.setError("Invalid Format");
        }
    }
}
