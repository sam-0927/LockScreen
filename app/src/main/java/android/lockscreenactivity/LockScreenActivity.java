package android.lockscreenactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class LockScreenActivity extends Activity {

    private Button onBtn, offBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED   //lock화면 위로 실행
                            //DISMISS_KEYGUARD,KEEP_SCREEN_ON는 같이 사용해야됨
                            | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD  //keyguard해지
                            | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);  //screen을 켜진상태로 유지
        System.out.println("enter the onCreate in LockScreenActivity");


        onBtn = (Button)findViewById(R.id.btn1);
        offBtn = (Button)findViewById(R.id.btn2);
        onBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("enter the Start");
                Intent intent;
                intent = new Intent(LockScreenActivity.this , ScreenService.class);
                startService(intent);
            }
        });
        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("enter the Stop");
                Intent intent = new Intent(LockScreenActivity.this, ScreenService.class);
                stopService(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
