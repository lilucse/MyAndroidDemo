package presenter;

import com.example.userlogin.LoginActivity;


import model.LoginParam;
import view.IUserView;
import PrefUtil.PrefUtil;
import android.content.Context;

public class UserPresenter {

    private final LoginActivity activity;
    public UserPresenter(LoginActivity activity) {
        this.activity = activity;
    }


    public void signUp(Context context,String userName,String password){

        LoginParam userInfo;
        userInfo=new LoginParam(userName,password);
        int code = PrefUtil.signUpCheckData(context,userInfo);
        if(code==PrefUtil.CODE_SUCCESS){
            activity.setResult("sign up success");
        }
        if(code==PrefUtil.CODE_NULL){
            activity.setResult("empty");
        }
        if(code==PrefUtil.CODE_EXIST){
            activity.setResult("exist");
        }
    }
    public void login(Context context,String userName,String password){
        LoginParam userInfo;
        userInfo=new LoginParam(userName,password);
        int code = PrefUtil.loginCheckData(context,userInfo);
        if(code==PrefUtil.CODE_SUCCESS){
            activity.setResult("login success");
        }
        if(code==PrefUtil.CODE_WRONG){
            activity.setResult("wrong");
        }
        if(code==PrefUtil.CODE_NULL){
            activity.setResult("empty");
        }
    }



}
