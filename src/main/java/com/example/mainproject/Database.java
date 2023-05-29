package com.example.mainproject;

public abstract class Database {
    abstract void editData();
    abstract void updateData();
    abstract void Connect();
    abstract void deleteData();
}

class Login extends Database{

    @Override
    void Connect() {
        // TODO Auto-generated method stub
        
    }

    @Override
    void deleteData() {
        // TODO Auto-generated method stub
        
    }

    @Override
    void editData() {
        // TODO Auto-generated method stub
        
    }

    @Override
    void updateData() {
        // TODO Auto-generated method stub
        
    }
}
