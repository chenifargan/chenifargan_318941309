package com.example.chenifargan_318941309;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import com.example.chenifargan_318941309.Model.Users;

public class RegisterActivity extends AppCompatActivity {
    private PhoneAuthProvider.ForceResendingToken forceResendingToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String mVerificationId; // will hold OPT/Verification code

    private static  final String TAG = "MAIN_TAG";
    private FirebaseAuth firebaseAuth;
    private Button RegistersentCodeButton,RegisterButton;
    private EditText InputName,InputPhoneNumber,InputPassword ,InputCode;
    private ProgressDialog loadingBar;
    private LinearLayout codeRegisterLinearLayout,acountRegisterLinearLayout;

    private TextView codeRegisterSentDescription,resendRegisterCodeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        acountRegisterLinearLayout = findViewById(R.id.acountRegisterLl);
        acountRegisterLinearLayout.setVisibility(View.VISIBLE);
        RegistersentCodeButton = findViewById(R.id.Register_sentCode_btn);
        InputName=findViewById(R.id.register_username_input);
        InputPhoneNumber=findViewById(R.id.register_phone_number_input);
        InputPassword=findViewById(R.id.register_password_input);
        loadingBar = new ProgressDialog(this);
        codeRegisterLinearLayout= findViewById(R.id.register_linearLayout);
        codeRegisterLinearLayout.setVisibility(View.GONE);
        InputCode=findViewById(R.id.register_code_input);
        RegisterButton= findViewById(R.id.register_btn);
        firebaseAuth =FirebaseAuth.getInstance();
        codeRegisterSentDescription = findViewById(R.id.codeRegisterSentDescription);
        resendRegisterCodeTv =findViewById(R.id.resendRegisterCodeTv);
        loadingBar = new ProgressDialog(this);
        loadingBar.setTitle("Please wait...");
        loadingBar.setCanceledOnTouchOutside(false);

        mCallbacks= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                loadingBar.dismiss();
                Toast.makeText(RegisterActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                super.onCodeSent(verificationId, forceResendingToken);
                Log.d(TAG,"onCodeSent:"+verificationId);
                mVerificationId = verificationId;
                forceResendingToken = token;
                loadingBar.dismiss();
                acountRegisterLinearLayout.setVisibility(View.GONE);
                codeRegisterLinearLayout.setVisibility(View.VISIBLE);//hind code layout
                Toast.makeText(RegisterActivity.this,"Verification Code Sent..",Toast.LENGTH_SHORT).show();
                codeRegisterSentDescription.setText("Please type the verification code we sent\nto"+InputPhoneNumber.getText().toString().trim());


            }

        };
        RegistersentCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = InputPhoneNumber.getText().toString().trim();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(RegisterActivity.this,"please enter phone number..",Toast.LENGTH_SHORT).show();
                }
                else{


//                    rootNode =FirebaseDatabase.getInstance();
//                    reference=rootNode.getReference("users");
//                    User u = new User().setFullName(NameRegisterEt.getText().toString()).
//                            setPhoneNumber(phoneRegisterEt.getText().toString()).
//                            setPassword(passwordRegisterEt.getText().toString());
//
//                    reference.setValue("First data strong");
                    startPhoneNumberVerification(phone);
                }
            }
        });

        resendRegisterCodeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = InputPhoneNumber.getText().toString().trim();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(RegisterActivity.this,"please enter phone number..",Toast.LENGTH_SHORT).show();
                }
                else{
                    resendVerificationCode(phone,forceResendingToken);
                }

            }
        });


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = InputCode.getText().toString().trim();
                if(TextUtils.isEmpty(code)){
                    Toast.makeText(RegisterActivity.this,"please enter verification code..",Toast.LENGTH_SHORT).show();
                }
                else{
                    verifyPhoneNumberWithCode(mVerificationId,code);
                }
            }
        });






    }

    private void CreateAccount() {
        String name = InputName.getText().toString();
        String phone = InputPhoneNumber.getText().toString();
        String password= InputPassword.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please write your name...",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phone)){
            Toast.makeText(this,"Please write your phone number...",Toast.LENGTH_SHORT).show();

        }

        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please write your password...",Toast.LENGTH_SHORT).show();

        }
        else{
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait,while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            ValidatephoneNumber(name,phone,password);

        }
    }

    private void ValidatephoneNumber(String name, String phone, String password) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(phone).exists())){
                    HashMap<String,Object> userdataMap= new HashMap<>();
                    userdataMap.put("phone",phone);
                    userdataMap.put("password",password);
                    userdataMap.put("name",name);
                    RootRef.child("Users").child(phone).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this,"Congratulations, your account has been created",Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();
                                        Intent intent= new Intent(RegisterActivity.this,HomeActivity2.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        loadingBar.dismiss();
                                        Toast.makeText(RegisterActivity.this,"Network Error: Please try again after some time...",Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                }
                else{
                    Toast.makeText(RegisterActivity.this,"This"+phone+"already exists",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(RegisterActivity.this,"Please try again using another phone number",Toast.LENGTH_SHORT).show();
                  Intent intent= new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void startPhoneNumberVerification(String phone) {

        loadingBar.setMessage("Verifying Phone Number");
        loadingBar.show();
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private void resendVerificationCode(String phone,PhoneAuthProvider.ForceResendingToken token) {
        loadingBar.setMessage("Resending Code");
        loadingBar.show();

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .setForceResendingToken(token)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }



    private void verifyPhoneNumberWithCode(String verificationId, String code) {

        loadingBar.setMessage("Verifying Code");
        loadingBar.show();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);
        signInWithPhoneAuthCredential(credential);




    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        loadingBar.setMessage("Logging IN");
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        loadingBar.dismiss();
                        String phone= firebaseAuth.getCurrentUser().getPhoneNumber();

                        Toast.makeText(RegisterActivity.this,"Logged In as"+phone,Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(RegisterActivity.this,HomeActivity2.class);
                        startActivity(intent);
                      //  finish();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loadingBar.dismiss();
                        Toast.makeText(RegisterActivity.this,"Logged In as"+e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }
}