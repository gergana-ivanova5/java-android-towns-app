package com.example.exam090921.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.exam090921.R;
import com.example.exam090921.data.StorageData;
import com.example.exam090921.listeners.OnTownAddListener;
import com.example.exam090921.models.Town;
import com.example.exam090921.validators.FormatValidator;
import com.example.exam090921.validators.SizeValidator;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TownFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TownFragment extends DialogFragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Town town;
    private EditText editText;
    private Button cancel, save;
    private OnTownAddListener listener;

    public TownFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static TownFragment newInstance(Town town) {
        TownFragment fragment = new TownFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, town);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            town = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_town, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = view.findViewById(R.id.editName);
        editText.setText(town.getName());

        editText.setOnFocusChangeListener(new FormatValidator(Pattern.compile("[A-Z]{4}")));
        //editText.setOnFocusChangeListener(new SizeValidator(4));

        cancel = view.findViewById(R.id.buttonCancel);
        save = view.findViewById(R.id.buttonSave);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof OnTownAddListener){
            listener = (OnTownAddListener) context;
        }
    }

    @Override
    public void onClick(View v) {
        boolean isValid = false;
        if(v.getId() == R.id.buttonCancel){
            dismiss();
        }else if(v.getId() == R.id.buttonSave){
            if(editText.getError()==null){
                isValid = true;
            }
            if(isValid){
                town.setName(editText.getText().toString());
                town = StorageData.generateTown(town.getName());
                listener.onTownAdd(town);
                dismiss();
            }

        }
    }
}