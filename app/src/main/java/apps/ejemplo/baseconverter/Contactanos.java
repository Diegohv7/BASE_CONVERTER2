package apps.ejemplo.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import apps.ejemplo.baseconverter.R;

public class Contactanos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        TextView email = (TextView)findViewById(R.id.textVieweEmail);
        email.setText(Html.fromHtml("<a href=\"mailto:solutionapps2020@gmail.com\">Email: solutionapps@gmail.com</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
