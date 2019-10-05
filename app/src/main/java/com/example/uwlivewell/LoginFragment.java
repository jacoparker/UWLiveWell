package com.example.uwlivewell;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private DatabaseReference mDatabase;

    private TextView user;
    private TextView userPass;

    private LoginFragment.LoginFragmentListener listener;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        user = view.findViewById(R.id.et_email);
        userPass = view.findViewById(R.id.et_password);
        Button regButton = view.findViewById(R.id.btn_login);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence name = user.getText();
                CharSequence pass = userPass.getText();

                listener.onInputSent(name, pass);
            }
        });

        Button guestButton = view.findViewById(R.id.signInGuest);
        guestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onInputSent();
            }
        });

        return view;
    }


    public interface LoginFragmentListener {
        void onInputSent();
        void onInputSent(CharSequence name, CharSequence pass);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoginFragment.LoginFragmentListener) {
            listener = (LoginFragment.LoginFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement LoginFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
