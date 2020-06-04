package shafi.sbf.com.multiplelanguagesupport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import io.paperdb.Paper;
import shafi.sbf.com.multiplelanguagesupport.Helper.LocaleHelper;

public class Main2Activity extends AppCompatActivity {

    TextView secound_language;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        secound_language = findViewById(R.id.secound_language);

        String lang = (String) Paper.book().read("language");

        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        secound_language.setText(resources.getString(R.string.about));


    }
}
