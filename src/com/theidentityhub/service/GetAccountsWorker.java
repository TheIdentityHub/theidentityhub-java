package com.theidentityhub.service;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.theidentityhub.model.AccountProvider;

/**
 * The Class GetAccountsAsync executes the rest service asynchronously and
 * retrieves a list of {@link AccountProvider} objects.
 *
 * @author U2U Consult
 * @since 1.0
 */
class GetAccountsWorker extends SwingWorker<ArrayList<AccountProvider>, Void> {

    private ArrayList<AccountProvider> accountProvider;
    private final String[]             params;

    /**
     * Main constructor
     */
    public GetAccountsWorker(final String... params) {
        this.params = params;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.SwingWorker#doInBackground()
     */
    @Override
    protected ArrayList<AccountProvider> doInBackground() {

        final Gson gson = new Gson();
        final Type listType = new TypeToken<ArrayList<AccountProvider>>() {
        }.getType();
        final String jsonResult = ApiCall.createGetApiCall(this.params[0]);
        this.accountProvider = gson.fromJson(jsonResult, listType);
        return this.accountProvider;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.SwingWorker#done()
     */
    @Override
    protected void done() {

        System.out.println("TIH / Result accounts json:--> " + this.accountProvider);

    }
}
