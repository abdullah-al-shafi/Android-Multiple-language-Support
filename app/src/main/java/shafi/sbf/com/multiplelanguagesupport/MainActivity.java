package shafi.sbf.com.multiplelanguagesupport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.paperdb.Paper;
import shafi.sbf.com.multiplelanguagesupport.Helper.LocaleHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtView);

        Paper.init(this);

        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));


    }

    private void updateView(String lang) {

        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        textView.setText(resources.getString(R.string.hello));
    }

    public void english(View view) {

        Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));

    }

    public void bangla(View view) {
        Paper.book().write("language","bn");
        updateView((String)Paper.book().read("language"));
    }

    public void nextPage(View view) {
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
