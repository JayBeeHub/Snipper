package com.example.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.domain.PreferencesHelper;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class SharedPreferencesHelper implements PreferencesHelper {

    // access token key name
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    // user login status key name
    private static final String PREF_KEY_USER_LOGIN_STATUS = "PREF_KEY_USER_LOGIN_STATUS";

    // access token key name
    private final SharedPreferences mPrefs;
    public SharedPreferencesHelper(Context context, String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getProfilePicture() {
        return null;
    }

    @Override
    public void setProfilePicture(String profilePicture) {

    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public void setFullName(String fullName) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }
}
