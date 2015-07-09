package android.lockscreenactivity;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Created by seyun on 2015-06-24.
 */
public class ScreenService extends Service {

    private ScreenReceiver mReceiver = null;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        System.out.println("enter the onCreate in ScreenService");
        mReceiver = new ScreenReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mReceiver,filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startld){
        super.onStartCommand(intent,flags,startld);

        System.out.println("enter the onStartCommand in ScreenService");
        if(intent != null){
            if(intent.getAction()==null){
                if(mReceiver == null) {
                    mReceiver = new ScreenReceiver();
                    IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
                    registerReceiver(mReceiver, filter);
                }
            }
        }
        return START_REDELIVER_INTENT;      //메모리가 부족해서 서비스가 종료됬을때
                                                //재생성과 onStartCommand()호출(with same indent, not null indent)
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        System.out.println("enter the onDestroy in ScreenService");
        if(mReceiver != null){
            unregisterReceiver(mReceiver);
        }
    }
}
