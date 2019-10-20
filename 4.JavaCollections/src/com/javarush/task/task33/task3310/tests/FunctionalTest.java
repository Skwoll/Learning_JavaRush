package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

   public void testStorage(Shortener shortener){
        String s1 = "asdfghjkl";
        String s2 = "qwertyuiop";
        String s3 = "asdfghjkl";

        Long l1 = shortener.getId(s1);
        Long l2 = shortener.getId(s2);
        Long l3 = shortener.getId(s3);

       Assert.assertNotEquals(l2,l1);
       Assert.assertNotEquals(l2,l3);
       Assert.assertEquals(l1,l3);

       String so1 = shortener.getString(l1);
       String so2 = shortener.getString(l2);
       String so3 = shortener.getString(l3);

       Assert.assertEquals(s1,so1);
       Assert.assertEquals(s2,so2);
       Assert.assertEquals(s3,so2);
   }

   @Test
   public void testHashMapStorageStrategy(){
       Shortener shortener = new Shortener(new HashMapStorageStrategy());
       testStorage(shortener);
   }

   @Test
   public void testOurHashMapStorageStrategy(){
       Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
       testStorage(shortener);
   }

   @Test
   public void testFileStorageStrategy(){
       Shortener shortener = new Shortener(new FileStorageStrategy());
       testStorage(shortener);
   }

   @Test
   public void testHashBiMapStorageStrategy(){
       Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
       testStorage(shortener);
   }

   @Test
   public void testDualHashBidiMapStorageStrategy(){
       Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
       testStorage(shortener);
   }

   @Test
   public void testOurHashBiMapStorageStrategy(){
       Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
       testStorage(shortener);
   }
}
