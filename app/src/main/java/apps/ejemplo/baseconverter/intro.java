package apps.ejemplo.baseconverter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import apps.ejemplo.baseconverter.R;

public class intro extends Activity  {

    private final int DURACION_SPLASH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(intro .this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);

    }
}
