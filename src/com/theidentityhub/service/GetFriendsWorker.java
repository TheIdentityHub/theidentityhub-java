package com.theidentityhub.service;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.theidentityhub.model.Friend;

/**
 * The Class GetFriendsAsync executes the rest service asynchronously and
 * retrieves a list of {@link Friend} objects.
 *
 * @author U2U Consult
 * @since 1.0
 */
class GetFriendsWorker extends SwingWorker<ArrayList<Friend>, Void> {

    private final String[]    params;
    private ArrayList<Friend> friends;

    /**
     *
     */
    public GetFriendsWorker(final String... params) {
        this.params = params;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.SwingWorker#doInBackground()
     */
    @Override
    protected ArrayList<Friend> doInBackground() {

        final Gson gson = new Gson();
        final Type listType = new TypeToken<ArrayList<Friend>>() {
        }.getType();
        final String jsonResult = ApiCall.createGetApiCall(this.params[0]);
        this.friends = gson.fromJson(jsonResult, listType);
        return this.friends;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.SwingWorker#done()
     */
    @Override
    protected void done() {

        System.out.println("TIH / Result friends json:--> " + this.friends);

    }
}
