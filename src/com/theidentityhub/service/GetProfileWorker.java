package com.theidentityhub.service;

import javax.swing.SwingWorker;

import com.google.gson.Gson;
import com.theidentityhub.model.Profile;

/**
 * The Class GetProfileAsync executes the rest service asynchronously and
 * retrieves a {@link Profile} object.
 *
 * @author U2U Consult
 * @since 1.0
 *
 */
class GetProfileWorker extends SwingWorker<Profile, Void> {

    private final String[] params;
    private Profile        profile;

    /**
     * Main constructor
     */
    public GetProfileWorker(final String... params) {
        this.params = params;
    }

    @Override
    protected Profile doInBackground() {

        final Gson gson = new Gson();
        final String jsonResult = ApiCall.createGetApiCall(this.params[0]);
        this.profile = gson.fromJson(jsonResult, Profile.class);
        return this.profile;
    }

    @Override
    protected void done() {

        System.out.println("TIH / Result profile json:--> " + this.profile);

    }
}
