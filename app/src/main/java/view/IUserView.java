package view;

public interface IUserView {
    void onLoginSuccess();
    void onLoginFailed(String error);
    void onSignUpSuccess();
    void onSignUpFailed(String error);
}
