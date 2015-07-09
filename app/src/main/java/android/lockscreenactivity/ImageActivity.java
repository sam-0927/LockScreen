/*
package android.lockscreenactivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("enter onCreate in ImageActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        Context context = this.getBaseContext();
        Drawable image = ImageOperations(context, "https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png", "image.png");
        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        imgView.setImageDrawable(image);
    }

    private Drawable ImageOperations(Context ctx, String url, String saveFilename) {
        try {
            System.out.println("enter ImageOperations in ImageActivity");
            URL imageUrl = new URL(url);
            InputStream is = (InputStream) imageUrl.getContent();
            Drawable d = Drawable.createFromStream(is, "src");
            return d;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
*/
