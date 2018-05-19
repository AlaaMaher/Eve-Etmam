package com.alaaetmam.eve.SharedPreferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.content.res.Configuration;

import com.alaaetmam.eve.View.Activities.LoginOrReg;

import java.util.Locale;

public class SherdLanguageClass  extends Application {
    public static final String LOCALE_PREFRENCE = "locale_prefrence";
    public static final String LOCALE_KEYVALUE = "Saved_locale";
    public static SharedPreferences mSharedPreferences;
    public static SharedPreferences.Editor editor;
    public static Locale mLocale;
    public Context context;
    private LoginOrReg loginOrReg;


    public SherdLanguageClass(Context ctx) {
        this.context = ctx;
        mSharedPreferences = context.getSharedPreferences(LOCALE_PREFRENCE, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putString("key","value");
        editor.apply();



        loginOrReg=new LoginOrReg();
    }
    public void changeLang(final String lang) {

        Handler mainHandler = new Handler(Looper.getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {


                if (lang.equalsIgnoreCase(""))
                    return;
                mLocale = new Locale(lang);
                saveLocale(lang);
                Locale.setDefault(mLocale);
                Configuration config = new Configuration();
                config.locale = mLocale;
                context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

               LoginOrReg.updateTexts();
         //       chooseLanguage.spinnerItem();


            } // This is your code
        };
        mainHandler.post(myRunnable);


    }

    private void saveLocale(String lang) {
        editor.putString(LOCALE_KEYVALUE, lang);
        editor.commit();

    }

    public String loadLocale() {
        String language = mSharedPreferences.getString(LOCALE_KEYVALUE, "");
        changeLang(language);
        return language;
    }

}
