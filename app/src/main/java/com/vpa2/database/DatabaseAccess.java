package com.vpa2.database;

public interface DatabaseAccess {
   public default String header() {
      return this.getClass().getSimpleName();
   }

   /// Prime Key  stored inside a datastrucutre used
   /// in the database to look up through.
   ///
   /// As an example `UUID`, `NAME`, `URL`, `CONTEXT` and etc.
   public abstract String key();
}
