package yu.ac.kr.booking0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signUpActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    Button signUpButton;
    EditText idEditText, pwEditText, pwCheckEditText, nameEditText, pnEditText;
    CheckBox business;
    //private FirebaseAuth mAuth;
    //private static final String TAG = "SignUpActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = (Button)findViewById(R.id.signUpButton);
        idEditText = (EditText)findViewById(R.id.idEditText);
        pwEditText = (EditText)findViewById(R.id.pwEditText);
        pwCheckEditText = (EditText)findViewById(R.id.pwCheckEditText);
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        pnEditText = (EditText)findViewById(R.id.pnEditText);
        business = (CheckBox)findViewById(R.id.isBusiness);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //mAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void signUp() {

        String email = idEditText.getText().toString();
        String password = pwEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String phoneNumber = pnEditText.getText().toString();
        String passwordCheck = pwCheckEditText.getText().toString();
        Boolean isBusiness = business.isChecked();

        User user = new User(email, password, name, phoneNumber, isBusiness);

        if(email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0){
            if(password.equals(passwordCheck)){
                /*mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("회원가입 성공!");
                                } else {
                                    startToast(task.getException().toString());
                                }
                            }
                        });*/

                mDatabase.child("User").child(email).setValue(user);
                startToast("회원가입 성공!");
                onBackPressed();
            } else{
                Toast.makeText(this, "비밀번호가 일치하지 않음!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}