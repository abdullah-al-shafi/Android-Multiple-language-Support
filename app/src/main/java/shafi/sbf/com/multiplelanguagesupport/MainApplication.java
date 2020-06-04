package shafi.sbf.com.multiplelanguagesupport;

import android.app.Application;
import android.content.Context;

import shafi.sbf.com.multiplelanguagesupport.Helper.LocaleHelper;

public class MainApplication extends Application {

    //press Ctrl+O


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
