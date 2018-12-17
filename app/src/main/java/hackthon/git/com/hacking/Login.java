package hackthon.git.com.hacking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginBtn = findViewById(R.id.login_btn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login.this, Home.class);
                startActivity(intent);
//                Toast.makeText(Login.this,"toast",Toast.LENGTH_SHORT).show();
            }
        });
    }


    class LoginLsr implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            TODO login button
            Intent intent = new Intent();
            intent.setClass(Login.this, Home.class);
            startService(intent);
        }
    }
}
