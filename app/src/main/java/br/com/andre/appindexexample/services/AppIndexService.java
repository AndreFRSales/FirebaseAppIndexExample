package br.com.andre.appindexexample.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.firebase.appindexing.Indexable;

import java.util.ArrayList;

/**
 * Created by andre on 07/05/17.
 */

public class AppIndexService extends IntentService {

    public AppIndexService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ArrayList<Indexable> indexables = new ArrayList<>();
    }
}
