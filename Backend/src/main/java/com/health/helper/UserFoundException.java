package com.health.helper;

public class UserFoundException  extends  Exception{

    public UserFoundException() {
        super("User with this Username is already there in DB !! try with another one");
    }

    public UserFoundException(String msg)
    {
        super(msg);
    }
}