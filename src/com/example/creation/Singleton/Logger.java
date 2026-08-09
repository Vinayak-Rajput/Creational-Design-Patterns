package com.example.creation.Singleton;

public class Logger {
    private static volatile Logger INSTANCE;

    private Logger(){
        System.out.println("Initializing Logger Instance");
    }

    public static Logger getInstance(){
        if(INSTANCE == null){
            synchronized (Logger.class){
                if(INSTANCE == null){
                    INSTANCE = new Logger();
                }
            }
        }
        return INSTANCE;
    }

}
