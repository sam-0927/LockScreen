package android.lockscreenactivity;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class WebImageActivity extends Activity {

    // 이미지를 불러와서 화면에 보여주는 객체 선언
    ImageView image;
    String uri="http://i.ytimg.com/vi/ZkHfHKaGxYo/hqdefault.jpg";
    Bitmap bit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("enter webImage");
        super.onCreate(savedInstanceState);
        // 화면에 타이틀바가 실행되지 않게 선언
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.image);
        image = (ImageView) findViewById(R.id.image);

        new WebGetImage().execute();
    }
   /* protected void onResume(){
        super.onResume();
       *//* new WebGetImage().execute();
        image.setImageBitmap(bit);*//*
        System.out.println("enter onResume");
        task.execute();

    }*/

    //버튼을 누르면 자동으로 실행되는 콜백메소드
  /*  public void getImage(View v) {
        new WebGetImage().execute();
        image.setImageBitmap(bit);
    }*/

    // 네트워크에 접속하여 이미지를 가져오는 클래스 선언
    private  class WebGetImage extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... params) {
            // 네트워크에 접속해서 데이터를 가져옴
            System.out.println("enter doInBackground");
            //int flag=0;
            try {
                URL Url = new URL(uri);                                                                     //웹사이트에 접속 (사진이 있는 주소로 접근)
                URLConnection urlcon = Url.openConnection();                                                // 웹사이트에 접속 설정
                urlcon.connect();   // 연결하시오
                int imagelength = urlcon.getContentLength();                                                // 이미지 길이 불러옴
                BufferedInputStream bis = new BufferedInputStream(urlcon.getInputStream(), imagelength);    // 스트림 클래스를 이용하여 이미지를 불러옴
                bit = BitmapFactory.decodeStream(bis);                                                      // 스트림을 통하여 저장된 이미지를 이미지 객체에 넣어줌
                bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end of background");
            return bit;
        }
        @Override
        protected void onPostExecute(Bitmap bit){
            super.onPostExecute(bit);
            System.out.println("enter onPostExecute");
            image.setImageBitmap(bit);
        }
    }


}