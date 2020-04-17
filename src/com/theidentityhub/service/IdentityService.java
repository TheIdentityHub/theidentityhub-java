package com.theidentityhub.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.theidentityhub.model.AccountProvider;
import com.theidentityhub.model.Friend;
import com.theidentityhub.model.Profile;
import com.theidentityhub.model.Role;
import com.theidentityhub.model.Token;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.web.WebEngine;

/**
 * The Class IdentityService contains all methods for authentication,
 * verification, or loading data about each identity i.e provides methods to
 * query an identity's profile.
 *
 * @author U2U Consult
 * @since 1.0
 */
public class IdentityService {

    /** The client identifier. */
    private final String clientId;

    /** The base url. */
    private final String baseUrl;

    /** The is authenticated flag. */
    boolean              isAuthenticated;

    /**
     * Initializes a new instance of the
     * com.theidentityhub.model.IdentityService class.
     *
     * @param clientId
     *            the client id
     * @param baseUrl
     *            the base url
     */
    public IdentityService(final String clientId, final String baseUrl) {
        super();
        this.clientId = clientId;
        this.baseUrl = baseUrl;
        IdentityConfig.config(clientId, baseUrl);
    }

    /**
     * Gets the client identifier.
     *
     * @return the client identifier
     */
    public String getClientIdentifier() {
        return this.getClientId();
    }

    /**
     * Gets the base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return this.baseUrl;
    }

    /**
     * Checks if is authenticated.
     *
     * @return true, if is authenticated
     */
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    /**
     * Sets the authenticated.
     *
     * @param isAuthenticated
     *            the new authenticated
     */
    public void setAuthenticated(final boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    /**
     * Returns the accounts data for the currently authenticated user.
     *
     * @return the accounts
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public ArrayList<AccountProvider> getAccounts() throws InterruptedException, ExecutionException {
        return getAccounts(null);
    }

    /**
     * Returns the accounts data for the currently authenticated user, for
     * specific identity ID parameter.
     *
     * @param identityId
     *            the identity id
     * @return the accounts
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public ArrayList<AccountProvider> getAccounts(final String identityId)
                    throws InterruptedException, ExecutionException {
        if (identityId == null) {
            return new GetAccountsWorker(Urls.ACCOUNTS_URI).get();
        } else {
            Urls.ACCOUNTS_URI_WITH_ID = this.baseUrl + Urls.API_ENDPOINT + "/" + identityId + Urls.ACCOUNTS +
                            Urls.ACCESS_TOKEN_PARAM;
            return new GetAccountsWorker(Urls.ACCOUNTS_URI_WITH_ID).get();
        }
    }

    /**
     * Returns the friends data for the currently authenticated user.
     *
     * @return the friends
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public ArrayList<Friend> getFriends() throws InterruptedException, ExecutionException {
        return getFriends(null);
    }

    /**
     * Returns the friends data for the currently authenticated user, for
     * specific identity ID parameter.
     *
     * @param identityId
     *            the identity id
     * @return the friends
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public ArrayList<Friend> getFriends(final String identityId) throws InterruptedException, ExecutionException {
        if (identityId == null) {
            return new GetFriendsWorker(Urls.FRIENDS_URI).get();
        } else {
            Urls.FRIENDS_URI_WITH_ID = this.baseUrl + Urls.API_ENDPOINT + "/" + identityId + Urls.FRIENDS +
                            Urls.ACCESS_TOKEN_PARAM + Urls.OFFSET_PARAM + Urls.LIMIT_PARAM;
            return new GetFriendsWorker(Urls.FRIENDS_URI_WITH_ID).get();
        }
    }

    /**
     * Returns the profile data for the currently authenticated user.
     *
     * @return the profile
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public Profile getProfile() throws InterruptedException, ExecutionException {
        return getProfile(null);
    }

    /**
     * Returns the profile data for the currently authenticated user, for
     * specific identity ID parameter.
     *
     * @param identityId
     *            the identity id
     * @return the profile
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public Profile getProfile(final String identityId) throws InterruptedException, ExecutionException {
        if (identityId == null) {
            return new GetProfileWorker(Urls.IDENTITY_URI).get();
        } else {
            Urls.IDENTITY_URI_WITH_ID = this.baseUrl + Urls.API_ENDPOINT + "/" + identityId + Urls.ACCESS_TOKEN_PARAM;
            return new GetProfileWorker(Urls.IDENTITY_URI_WITH_ID).get();
        }
    }

    /**
     * Returns the roles data for the currently authenticated user.
     *
     * @return the roles
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public ArrayList<Role> getRoles() throws InterruptedException, ExecutionException {
        return getRoles(null);
    }

    /**
     * Returns the roles data for the currently authenticated user, for specific
     * identity ID parameter.
     *
     * @param identityId
     *            the identity id
     * @return the roles
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public ArrayList<Role> getRoles(final String identityId) throws InterruptedException, ExecutionException {
        if (identityId == null) {
            return new GetRolesWorker(Urls.ROLES_URI).get();
        } else {
            Urls.ROLES_URI_WITH_ID =
                            this.baseUrl + Urls.API_ENDPOINT + "/" + identityId + Urls.ROLES + Urls.ACCESS_TOKEN_PARAM;
            return new GetRolesWorker(Urls.ROLES_URI).get();
        }
    }

    /**
     * This method revokes the token, and after this method is called the token
     * is not valid anymore. To get new valid token the user must authenticate
     * again by signing in ({@link #tryAuthenticate(Context)} or
     * {@link #tryAuthenticate(Context, String)}).
     */
    public void signOut() {
        new RevokeTokenWorker(Urls.REVOKE_URI);
    }

    /**
     * This method tries to authenticate the user by providing list of the
     * accounts the user can use to do the authentication.
     *
     * @return true, if successful
     */
    public boolean tryAuthenticate() {
        return tryAuthenticate(null);
    }

    /**
     * This method tries to authenticate the user by opening the specific
     * provider the user should use for authentication, specified with the
     * accountProviderId parameter.
     *
     * @param accountProviderId
     *            the account provider id
     * @return true, if successful
     */
    public boolean tryAuthenticate(final String accountProviderId) {

        Browser wv;
        if (accountProviderId != null) {
            wv = new Browser(Urls.AUTH_URL + Urls.PROVIDER_ID + accountProviderId);// 3136309828983524457
        } else {
            wv = new Browser(Urls.AUTH_URL);
        }

        final WebEngine we = wv.getWebEngine();
        we.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(final ObservableValue ov, final State oldState, final State newState) {

                if (newState == Worker.State.SUCCEEDED) {
                    final String url = we.getLocation();

                    if (url.startsWith(Urls.EXPECTED_AUTH_RESPONSE)) {
                        IdentityConfig.ACCESS_TOKEN = parseTokenFromUrl(url).getAccessToken();

                        IdentityConfig.config(IdentityService.this.getClientId(), IdentityService.this.getBaseUrl());

                        IdentityService.this.isAuthenticated = true;

                        wv.close();

                    } else {
                        IdentityService.this.isAuthenticated = false;
                    }
                }

            }
        });

        return this.isAuthenticated;

    }

    /**
     * This method verifies the received token. Returns true if is valid, false
     * otherwise.
     *
     * @return true, if successful
     * @throws InterruptedException
     *             the interrupted exception
     * @throws ExecutionException
     *             the execution exception
     */
    public boolean verifyToken() throws InterruptedException, ExecutionException {
        return new VerifyAccessTokenWorker(Urls.VERIFY_URI).get();
    }

    /**
     * Parses the token from the response url.
     *
     * @param urlString
     *            the url string
     * @return the token
     */
    final Token parseTokenFromUrl(final String urlString) {
        final URI uri = URI.create(urlString);
        final String fragment = uri.getFragment();
        final String[] fragmentArray = fragment.split("&");
        String accessToken = "";
        String tokenType = "";
        String expiresIn = "";
        String scope = "";
        int resourceOwnerIdentityVerified = 0;

        for (int i = 0; i < fragmentArray.length; i++) {
            final String[] paramArray = fragmentArray[i].split("=");
            if ((paramArray[0].compareTo("access_token") == 0) && (paramArray.length > 1)) {
                accessToken = paramArray[1];
            }
            if ((paramArray[0].compareTo("token_type") == 0) && (paramArray.length > 1)) {
                tokenType = paramArray[1];
            }
            if ((paramArray[0].compareTo("expires_in") == 0) && (paramArray.length > 1)) {
                expiresIn = paramArray[1];
            }
            if ((paramArray[0].compareTo("scope") == 0) && (paramArray.length > 1)) {
                scope = paramArray[1];
            }
            if ((paramArray[0].compareTo("resource_owner_identity_verified") == 0) && (paramArray.length > 1)) {
                resourceOwnerIdentityVerified = Integer.parseInt(paramArray[1]);
            }
        }

        final Token token = new Token(accessToken, tokenType, expiresIn, scope, resourceOwnerIdentityVerified);

        return token;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return this.clientId;
    }

}
