package com.theidentityhub.model;

/**
 * Represents a friend. Each {@link Friend} object has its {@link #displayName},
 * {@link #identityId}, {@link #largePictures}, {@link #mediumPictures},
 * {@link #smallPicture} and {@link #smallPictures}. They can be accessed using
 * the get methods respectively.
 * 
 * @author U2U Consult
 * @since 1.0
 */
public class Friend {

     /** The display name. */
     private String displayName;

     /** The identity id. */
     private String identityId;

     /** The large pictures. */
     private String[] largePictures;

     /** The medium pictures. */
     private String[] mediumPictures;

     /** The small picture. */
     private String smallPicture;

     /** The small pictures. */
     private String[] smallPictures;

     /**
      * Instantiates a new friend.
      * 
      * @param displayName
      *             the display name
      * @param identityId
      *             the identity id
      * @param largePictures
      *             the large pictures
      * @param mediumPictures
      *             the medium pictures
      * @param smallPicture
      *             the small picture
      * @param smallPictures
      *             the small pictures
      */
     public Friend(String displayName, String identityId,
               String[] largePictures, String[] mediumPictures,
               String smallPicture, String[] smallPictures) {
          super();
          this.displayName = displayName;
          this.identityId = identityId;
          this.largePictures = largePictures;
          this.mediumPictures = mediumPictures;
          this.smallPicture = smallPicture;
          this.smallPictures = smallPictures;
     }

     /**
      * Gets the display name of the friend.
      * 
      * @return the display name
      */
     public String getDisplayName() {
          return displayName;
     }

     /**
      * Gets the identifier of the friend.
      * 
      * @return the identity id
      */
     public String getIdentityId() {
          return identityId;
     }

     /**
      * Gets the large pictures of the friend.
      * 
      * @return the large pictures
      */
     public String[] getLargePictures() {
          return largePictures;
     }

     /**
      * Gets the medium pictures of the friend.
      * 
      * @return the medium pictures
      */
     public String[] getMediumPictures() {
          return mediumPictures;
     }

     /**
      * Gets the first small picture of the friend.
      * 
      * @return the small picture
      */
     public String getSmallPicture() {
          return smallPicture;
     }

     /**
      * Gets the small pictures of the friend.
      * 
      * @return the small pictures
      */
     public String[] getSmallPictures() {
          return smallPictures;
     }

}
