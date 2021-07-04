package com.example.tranquangvinh_android43_buoi5;

public class LoginPresenter {
    ILogin ilogin;

    public LoginPresenter(ILogin ilogin) {
        this.ilogin = ilogin;
    }

    public void onLogin(String username, String pass) {
        if (username.equals("") && pass.equals("")) {
            ilogin.OnLoginSuccessfull("Dang nhap thanh cong");
            ilogin.changeActivity(Order.class);
        } else
            ilogin.OnLoginError("Dang nhap khong thanh cong");

    }

}
