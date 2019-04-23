package in.co.ankitarora.leakcanaryexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_cause_leak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runTask();
            }
        });
    }

    private void runTask() {
        Runnable work = new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(20000);
            }
        };
        new Thread(work).start();
    }

}
