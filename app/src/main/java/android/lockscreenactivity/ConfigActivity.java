package android.lockscreenactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by seyun on 2015-06-24.
 */
public class ConfigActivity extends Activity {

    private Button onBtn, offBtn;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        onBtn = (Button)findViewById(R.id.btn1);
        offBtn = (Button)findViewById(R.id.btn2);

        System.out.println("enter the onCreate in ConfigActivity");
        onBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("enter the Start");
                Intent intent;
                intent = new Intent(ConfigActivity.this , ScreenService.class);
                startService(intent);
            }
        });
        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("enter the Stop");
                Intent intent = new Intent(ConfigActivity.this , ScreenService.class);
                stopService(intent);
            }
        });
    }
}
