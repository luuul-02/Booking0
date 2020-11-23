package yu.ac.kr.booking0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    public static User loginUser;

    Button loginButton, goSignUpButton;
    EditText idGoEditText, pwGoEditText;
    //private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.loginButton);
        goSignUpButton = (Button)findViewById(R.id.goSignUpButton);
        idGoEditText = (EditText)findViewById(R.id.idGoEditText);
        pwGoEditText = (EditText)findViewById(R.id.pwGoEditText);
        //mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        goSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, signUpActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {

        final String id = idGoEditText.getText().toString();
        final String password = pwGoEditText.getText().toString();


        if(id.length() > 0 && password.length() > 0){
                /*mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("로그인 성공!");

                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivityForResult(intent,1001);

                                } else {
                                    startToast(task.getException().toString());
                                }
                            }
                        });*/
            mDatabase.child("User").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.getValue(User.class);

                    if(user == null){
                        startToast("아이디/비밀번호가 정확하지 않음!");
                    }
                    else if(user.getPassword().equals(password)){
                        startToast("로그인 성공!");
                        loginUser = user;
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
        else{
            Toast.makeText(this, "비밀번호가 일치하지 않음!", Toast.LENGTH_SHORT).show();
        }
    }

    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}