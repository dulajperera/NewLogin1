package com.example.dulajp.newlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

import com.facebook.FacebookException;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;



import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;



public class MainActivity extends AppCompatActivity {


    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AccessTokenTracker fbTracker;
    Button continue_to_app_button;
    Button fb_custom_login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("id", "name", "email", "birthday", "gender"));


        //LoginButton loginButton = (LoginButton)findViewById(R.id.usersettings_fragment_login_button);
        fb_custom_login_button = (Button) findViewById(R.id.fb_custom_login_button);
        fb_custom_login_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                disableButtons();
                loginButton.performClick();
            }
        });


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
              //  new ProcessFacebook().execute(loginResult);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    private void enableButtons(){
        continue_to_app_button.setEnabled(true);
        fb_custom_login_button.setEnabled(true);

        fb_custom_login_button.setBackgroundResource(R.drawable.fb_color);
    }

    private void disableButtons(){
        continue_to_app_button.setEnabled(false);
        fb_custom_login_button.setEnabled(false);

        fb_custom_login_button.setBackgroundResource(R.drawable.fb_gray);
    }
}
