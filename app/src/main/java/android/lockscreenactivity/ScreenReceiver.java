package android.lockscreenactivity;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by seyun on 2015-06-24.
 */
public class ScreenReceiver extends BroadcastReceiver {

    private KeyguardManager km = null;
    private KeyguardManager.KeyguardLock keyLock = null;
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("enter the onReceive in ScreenReceiver");
        //Intent.ACTION_SCREEN_OFF : broadcast가 수신됬을때 = 화면이 꺼졌을때 = 화면이 꺼지고 안드로이드 순정
        //락스크린이 걸린 상태 위에 LockScreenActivity가 호출되어 있을 듯
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            System.out.println("enter the onCreate in ScreenReceiver");
            if(km == null)
                km = (KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);

            if(keyLock == null)
                keyLock = km.newKeyguardLock(Context.KEYGUARD_SERVICE);

            disableKeyguard();      //순정 락스크린 해제
            Intent i = new Intent(context,WebImageActivity.class);    //LockScreenActivity를 호출하는 intent생성
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);            //activity가 stack에 쌓이는걸 방지
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);              //예시:로그인하고 뒤로가기 누르면 다시 로그인 화면뜨는거
        //    i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            context.startActivity(i);                                    //LockScreenActivity를 호출
        }
    }
    public void reenableKeyguard(){
        keyLock.reenableKeyguard();
    }

    public void disableKeyguard(){
        keyLock.disableKeyguard();
    }
}
