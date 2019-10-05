package com.example.uwlivewell;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.os.Bundle;

public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    private AccountManager am;
    private Account[] accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.am = AccountManager.get(this); // "this" references the current Context
        this.accounts = am.getAccountsByType(this.getPackageName());
        setContentView(R.layout.activity_authenticator);
    }

    private void register(String user, String email, String userPassword) {
        final Account account = new Account(user, "User");

        this.am.addAccountExplicitly(account, userPassword, null);
    }

    private void validate(String user, String userPassword) {

    }
}
