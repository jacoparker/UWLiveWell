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
public class RegisterFragment extends Fragment {

    private DatabaseReference mDatabase;

    public RegisterFragment() {
        // Required empty public constructor
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private RegisterFragmentListener listener;

    public interface RegisterFragmentListener {
        void onInputSent(CharSequence name, CharSequence email, CharSequence pass, CharSequence repass);
    }

    private TextView userName;
    private TextView userEmail;
    private TextView userPass;
    private TextView userRePass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        userName = view.findViewById(R.id.et_name);
        userEmail = view.findViewById(R.id.et_email);
        userPass = view.findViewById(R.id.et_password);
        userRePass = view.findViewById(R.id.et_repassword);
        Button regButton = view.findViewById(R.id.btn_register);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence name = userName.getText();
                CharSequence email = userEmail.getText();
                CharSequence pass = userPass.getText();
                CharSequence repass = userRePass.getText();

                listener.onInputSent(name, email, pass, repass);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RegisterFragmentListener) {
            listener = (RegisterFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement RegisterFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
