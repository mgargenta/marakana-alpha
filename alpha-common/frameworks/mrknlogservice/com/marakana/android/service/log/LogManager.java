package com.marakana.android.service.log;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class LogManager {
    private static final String TAG = "LogManager";
    private static final String REMOTE_SERVICE_NAME = ILogService.class.getName();
    private final ILogService service;
    
    public static LogManager getInstance() {
        return new LogManager();
    }
        
    private LogManager() {
        Log.d(TAG, "Connecting to ILogService by name [" + REMOTE_SERVICE_NAME + "]");
        this.service = ILogService.Stub.asInterface(ServiceManager.getService(REMOTE_SERVICE_NAME));
        if (this.service == null) {
	        throw new IllegalStateException("Failed to find ILogService by name [" + REMOTE_SERVICE_NAME + "]");
        }
    }   
    
    public void flushLog() {
        try {
            Log.d(TAG, "Flushing logs");
            this.service.flushLog();
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to flush log", e);
        }
    }
    
    public int getTotalLogSize() {
        try {
            Log.d(TAG, "Getting total log size");
            return this.service.getTotalLogSize();
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to get total log size", e);
        }
    }
    
    public synchronized int getUsedLogSize() {
        try {
            Log.d(TAG, "Getting used log size");
            return this.service.getUsedLogSize();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get used log size", e);
        }
    }
}
