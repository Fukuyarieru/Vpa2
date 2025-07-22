package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements DatabaseDatastructure {

   private String name;
   private String password;
   private String description;
   private byte[] picture;

   private Playlist viewHistory;
   private String[] ownedPlaylists;
   private Playlist ownedVideos;

   private String[] peopleLike;
   private String[] peopleDislike;
   private String[] peopleViewed;

   public static final String DEFAULT_USER_NAME ="user";
   public static final String DEFAULT_USER_PASSWORD ="123";
   public static final String DEFAULT_USER_DESCRIPTION ="";

   public User() {
      this(DEFAULT_USER_NAME, DEFAULT_USER_PASSWORD);
   }

   public User(String name, String password) {
      this.name = name;
      this.password = password;
      this.description= DEFAULT_USER_DESCRIPTION;
      this.picture=new byte[]{0};

      this.viewHistory=new Playlist(name+"'s view history", new Video[]{});
      this.ownedVideos=new Playlist(name+"'s owned videos",new Video[]{});
      this.ownedPlaylists=new String[]{viewHistory.getTitle(),ownedVideos.getTitle()};

      this.peopleLike=new String[]{};
      this.peopleDislike=new String[]{};
      this.peopleViewed=new String[]{};
   }

   @Override
   public String header() {
      return "users";
   }

   @Override
   public String key() {
      return name;
   }
}
