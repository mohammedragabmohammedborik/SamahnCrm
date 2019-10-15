package com.ismart.samahncrm.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.ismart.samahncrm.GeneralModel;
import com.ismart.samahncrm.R;
import com.ismart.samahncrm.UtilityHelper;
import com.ismart.samahncrm.crmhome.CrmHoneActivity;
import com.ismart.samahncrm.databinding.FragmentLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private FragmentLoginBinding fragmentLoginBinding;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentLoginBinding = DataBindingUtil.setContentView(this, R.layout.fragment_login);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        fragmentLoginBinding.lgnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UtilityHelper.getConnectionType(LoginActivity.this)!=0) {
                    login();

                }else {
                    UtilityHelper.showErrorSnackbar(LoginActivity.this,"You are not connect with internet");
                }
            }
        });

    }
    public void login(){
        if (validate(fragmentLoginBinding.mobileRegister.getText().toString().trim()
                , fragmentLoginBinding.passwordRegisterId.getText().toString().trim())){
            loginViewModel.fetchModel(fragmentLoginBinding.mobileRegister.getText().toString().trim()
                    , fragmentLoginBinding.passwordRegisterId.getText().toString().trim(),
                    null, null, "ar").observe(this, new Observer<GeneralModel>() {
                @Override
                public void onChanged(GeneralModel generalModel) {
                    if (generalModel != null) {
                    } else {
                        startActivity(new Intent(LoginActivity.this, CrmHoneActivity.class));
                    }
                }
            });

        }
    }

    private  boolean validate(String mobile,String password) {
        if (TextUtils.isEmpty(mobile)) {

            fragmentLoginBinding.mobileRegister.setError(getString(R.string.fill_field));
            return false;
        } else if (TextUtils.isEmpty(password)) {
            fragmentLoginBinding.mobileRegister.setError(getString(R.string.fill_field));
            return false;

        }
        return  true;
    }
}
