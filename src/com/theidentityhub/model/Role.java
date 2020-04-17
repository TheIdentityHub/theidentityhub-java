package com.theidentityhub.model;

/**
 * Represents a role for specified identity.
 * 
 * @author U2U Consult
 * @since 1.0
 */
public class Role {

     /** The name. */
     private String name;

     /**
      * Instantiates a new role.
      * 
      * @param name
      *             the name
      */
     public Role(String name) {
          super();
          this.name = name;
     }

     /**
      * Gets the name.
      * 
      * @return the name
      */
     public String getName() {
          return name;
     }

}
