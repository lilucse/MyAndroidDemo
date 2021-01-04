package PrefUtil;

import android.content.SharedPreferences;
import android.content.Context;
import model.LoginParam;
public class PrefUtil {

    public static int CODE_SUCCESS = 1;
    public static int CODE_NULL = -1;
    public static int CODE_EXIST = -2;
    public static int CODE_WRONG = -3;



    public static boolean checkDataNull(LoginParam userInfo){
        if(userInfo.getUserName().isEmpty()||userInfo.getUserPwd().isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean checkDataExist(Context context,LoginParam userInfo){
        SharedPreferences sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String result = sp.getString(userInfo.getUserName(),"");
        if(userInfo.getUserName().equals(result)){
            return true;
        }
        return false;

    }
    public static boolean checkDataTrue(Context context,LoginParam userInfo){
        SharedPreferences sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String result = sp.getString(userInfo.getUserName(),"");
        if(userInfo.getUserPwd().equals(result))
        {
            return true;
        }
        return false;
    }

    public static int loginCheckData(Context context,LoginParam userInfo){
        boolean empty = checkDataNull(userInfo);
        if(empty) return CODE_NULL;
        boolean isTrue = checkDataTrue(context,userInfo);
        if(!isTrue) return CODE_WRONG;
        return CODE_SUCCESS;
    }
    public static int signUpCheckData(Context context,LoginParam userInfo){
        boolean empty = checkDataNull(userInfo);
        if(empty) return CODE_NULL;
        boolean exist = checkDataExist(context,userInfo);
        if(exist) return CODE_EXIST;
        saveData(context,userInfo);
        return CODE_SUCCESS;
    }
    public static void saveData(Context context,LoginParam userInfo){
        SharedPreferences sp = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(userInfo.getUserName(),userInfo.getUserPwd());
        editor.commit();
    }
}
