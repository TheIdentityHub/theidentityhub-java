package com.theidentityhub.service;

import javax.swing.SwingWorker;

import com.google.gson.Gson;
import com.theidentityhub.model.VerifyResult;

/**
 * The class verifies the token that the user is using for authentication.
 *
 * @author U2U Consult
 * @since 1.0
 */
class VerifyAccessTokenWorker extends SwingWorker<Boolean, Void> {

    private final String[] params;
    private Boolean        result;

    /**
     * Main constructor
     */
    public VerifyAccessTokenWorker(final String... params) {
        this.params = params;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.SwingWorker#doInBackground()
     */
    @Override
    protected Boolean doInBackground() {
        final Gson gson = new Gson();
        final String jsonString = ApiCall.createGetApiCall(this.params[0]);
        final VerifyResult verifyResult = gson.fromJson(jsonString, VerifyResult.class);
        if ((verifyResult.getExpiresIn() > 0) && (verifyResult.getError() == null)) {
            this.result = true;
        } else {
            this.result = false;
        }

        return this.result;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.SwingWorker#done()
     */
    @Override
    protected void done() {
        System.out.println("TIH / Result is verified boolean:--> " + this.result);

    }
}
