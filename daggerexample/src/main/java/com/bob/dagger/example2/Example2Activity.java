package com.bob.dagger.example2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.dagger.R;
import com.bob.dagger.example2.di.AppModule;
import com.bob.dagger.example2.di.DaggerExample2Component;
import com.bob.dagger.example2.di.Example2Component;

/**
 * \@Inject + @Component + @Module使用
 */
public class Example2Activity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();

//    @Inject
//    View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);
        TextView textView = findViewById(R.id.text);
        textView.setText("Example2");

        Example2Component example2Component = DaggerExample2Component.builder().appModule(new AppModule(this)).build();
//        example2Component.inject(this);
        View mView = example2Component.getView();

        if (mView != null) {
            Log.w(tag, "mView=" + mView);
        } else {
            Log.w(tag, "mView is null");
        }
    }
}