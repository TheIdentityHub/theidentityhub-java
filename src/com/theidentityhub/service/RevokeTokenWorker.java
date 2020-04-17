package com.theidentityhub.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * The class revokes the token that the user is using for authentication. After
 * token is revoked it is not valid anymore for further usage.
 *
 * @author U2U Consult
 * @since 1.0
 */
class RevokeTokenWorker extends SwingWorker<Void, Void> {

    private final String[] params;
    private HttpClient httpclient;

    /**
     *
     */
    public RevokeTokenWorker(final String... params) {
        this.params = params;
    }

    @Override
    protected Void doInBackground() {
        final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        nameValuePairs.add(new BasicNameValuePair("token", IdentityConfig.ACCESS_TOKEN));
        nameValuePairs.add(new BasicNameValuePair("client_id", IdentityConfig.CLIENT_ID));

        httpclient = new DefaultHttpClient();
        final HttpPost httppost = new HttpPost(this.params[0]);
        httppost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");

        try {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Execute HTTP Post Request
        try {
            final HttpResponse response = httpclient.execute(httppost);
            System.out.println("Response / Code--->>" + response.getStatusLine().getStatusCode());
        } catch (final IOException e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
