package com.theidentityhub.service;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.theidentityhub.model.Role;

/**
 * The Class GetRolesAsync executes the rest service asynchronously and
 * retrieves a list of {@link Role} objects.
 *
 * @author U2U Consult
 * @since 1.0
 */
class GetRolesWorker extends SwingWorker<ArrayList<Role>, Void> {

    private final String[]  params;
    private ArrayList<Role> friends;

    /**
     * Main constructor
     */
    public GetRolesWorker(final String... params) {
        this.params = params;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.SwingWorker#doInBackground()
     */
    @Override
    protected ArrayList<Role> doInBackground() {

        final Gson gson = new Gson();
        final Type listType = new TypeToken<ArrayList<Role>>() {
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

        System.out.println("TIH / Result roles json:--> " + this.friends);

    }
}
