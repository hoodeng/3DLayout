package layout.a3d.anull.com.a3dlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Layout3D mLayout3D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout3D = findViewById(R.id.layout3d);
        findViewById(R.id.ok).setOnClickListener(this);
        init();
    }

    private void init(){
        LayoutInflater inflater = LayoutInflater.from(this);
        ImageView imageview = (ImageView) inflater.inflate(R.layout.layout_imageview,null);
        mLayout3D.initLayout(imageview);

        imageview.setImageDrawable(getResources().getDrawable(R.mipmap.test_small));

        mLayout3D.postDelayed(new Runnable() {
            @Override
            public void run() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                ImageView imageview = (ImageView) inflater.inflate(R.layout.layout_imageview,null);
                imageview.setImageDrawable(getResources().getDrawable(R.mipmap.test_small1));
                mLayout3D.addNextView(imageview);
            }
        },300);
    }


    private void flip(){
        mLayout3D.toggleFlip();
    }



    @Override
    public void onClick(View v) {
        flip();
    }
}
