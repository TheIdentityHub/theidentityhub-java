package com.theidentityhub.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents {@link Token} object that contains details about user
 * authorization, such as {@link #access_token}, {@link #token_type} and token
 * expiration.
 * 
 * @author U2U Consult
 * @since 1.0
 */
public class Token {

     /** The access token. */
     @SerializedName("access_token")
     private String accessToken;

     /** The token type. */
     @SerializedName("token_type")
     private String tokenType;

     /** The expires in. */
     @SerializedName("expires_in")
     private String expiresIn;

     /** The scope. */
     private String scope;

     /** The is resource owner identity verified. */
     @SerializedName("resource_owner_identity_verified")
     private int isResourceOwnerIdentityVerified;

     /** The refresh token. */
     @SerializedName("refresh_token")
     private String refreshToken;

     /**
      * Instantiates a new token.
      * 
      * @param accessToken
      *             the access token
      * @param tokenType
      *             the token type
      * @param expiresIn
      *             the expires in
      * @param scope
      *             the scope
      * @param isResourceOwnerIdentityVerified
      *             the is resource owner identity verified
      */
     public Token(String accessToken, String tokenType, String expiresIn,
               String scope, int isResourceOwnerIdentityVerified) {
          super();
          this.accessToken = accessToken;
          this.tokenType = tokenType;
          this.expiresIn = expiresIn;
          this.scope = scope;
          this.isResourceOwnerIdentityVerified = isResourceOwnerIdentityVerified;
     }

     /**
      * Instantiates a new token.
      * 
      * @param accessToken
      *             the access token
      * @param tokenType
      *             the token type
      * @param expiresIn
      *             the expires in
      * @param scope
      *             the scope
      * @param refreshToken
      *             the refresh token
      */
     public Token(String accessToken, String tokenType, String expiresIn,
               String scope, String refreshToken) {
          super();
          this.accessToken = accessToken;
          this.tokenType = tokenType;
          this.expiresIn = expiresIn;
          this.scope = scope;
          this.refreshToken = refreshToken;
     }

     /**
      * Gets the access token.
      * 
      * @return the access token
      */
     public String getAccessToken() {
          return accessToken;
     }

     /**
      * Gets the token type.
      * 
      * @return the token type
      */
     public String getTokenType() {
          return tokenType;
     }

     /**
      * Gets the expires in.
      * 
      * @return the expires in
      */
     public String getExpiresIn() {
          return expiresIn;
     }

     /**
      * Gets the scope.
      * 
      * @return the scope
      */
     public String getScope() {
          return scope;
     }

     /**
      * Checks if is resource owner identity verified.
      * 
      * @return the int
      */
     public int isResourceOwnerIdentityVerified() {
          return isResourceOwnerIdentityVerified;
     }

     /**
      * Gets the refresh token.
      * 
      * @return the refresh token
      */
     public String getRefreshToken() {
          return refreshToken;
     }

}
