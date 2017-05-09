package br.com.andre.appindexexample.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by andre on 07/05/17.
 */

public class AppIndexService extends IntentService {

    private final Uri BASE_URL = Uri.parse("https://www.indexable.com/indexables/");

    public AppIndexService() {
        super(AppIndexService.class.getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ArrayList<Indexable> indexables = new ArrayList<>();

        for(String text : getMockIndexables()) {
            final String url = BASE_URL.buildUpon().appendPath(text).build().toString();
            Indexable mockIndexable = Indexables.noteDigitalDocumentBuilder()
                    .setUrl(url)
                    .setName("Indexable List")
                    .build();

            indexables.add(mockIndexable);
        }

        Indexable[] indexableArray = new Indexable[indexables.size()];
        indexableArray = indexables.toArray(indexableArray);

        FirebaseAppIndex.getInstance().update(indexableArray);
    }

    private ArrayList<String> getMockIndexables(){
        ArrayList<String> indexables = new ArrayList<>();

        for(int count = 0; count < 10; count++){
            indexables.add("index" + count);
        }

        return indexables;
    }
}
