package com.theidentityhub.model;

import com.google.gson.annotations.SerializedName;

/**
 * The object that holds data about token verification.
 * 
 * @author U2U Consult
 * @since 1.0
 */
public class VerifyResult {

     /** The audience. */
     private String audience;

     /** The scope. */
     private String scope;

     /** The expires in. */
     @SerializedName("expires_in")
     private int expiresIn;

     /** The is resource owner identity verified. */
     @SerializedName("resource_owner_identity_verified")
     private boolean isResourceOwnerIdentityVerified;

     /** The error. */
     private String error;

     /**
      * Instantiates a new verify result.
      * 
      * @param audience
      *             the audience
      * @param scope
      *             the scope
      * @param expiresIn
      *             the expires in
      * @param isResourceOwnerIdentityVerified
      *             the is resource owner identity verified
      * @param error
      *             the error
      */
     public VerifyResult(String audience, String scope, int expiresIn,
               boolean isResourceOwnerIdentityVerified, String error) {
          super();
          this.audience = audience;
          this.scope = scope;
          this.expiresIn = expiresIn;
          this.isResourceOwnerIdentityVerified = isResourceOwnerIdentityVerified;
          this.error = error;
     }

     /**
      * Gets the audience.
      * 
      * @return the audience
      */
     public String getAudience() {
          return audience;
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
      * Gets the expires in.
      * 
      * @return the expires in
      */
     public int getExpiresIn() {
          return expiresIn;
     }

     /**
      * Checks if is resource owner identity verified.
      * 
      * @return true, if is resource owner identity verified
      */
     public boolean isResourceOwnerIdentityVerified() {
          return isResourceOwnerIdentityVerified;
     }

     /**
      * Gets the error.
      * 
      * @return the error
      */
     public String getError() {
          return error;
     }

}
