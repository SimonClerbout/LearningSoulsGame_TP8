package test;

import com.sun.istack.internal.Nullable;
import lsg.armor.ArmorItem;
import lsg.weapons.Weapon;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

public class CharacterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testCollectibleInterface() {
        try {
            Class<?> c = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC | Modifier.ABSTRACT);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        }
    }

    @Test
    public void testCollectibleArmorItem() {
        try {
            Class<?> c = Class.forName("lsg.armor.ArmorItem");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 4);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.armor.ArmorItem");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleWeapon() {
        try {
            Class<?> c = Class.forName("lsg.weapons.Weapon");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.weapons.Claw");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 2);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.weapon.Weapons");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleConsumable() {
        try {
            Class<?> c = Class.forName("lsg.consumables.Consumable");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.consumables.Consumable");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleBuffItem() {
        try {
            Class<?> c = Class.forName("lsg.buffs.BuffItem");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.buffs.rings.RingOfDeath");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.buffs.BuffItem");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleDragonSlayerLeggings() {
        try {
            Class<?> c = Class.forName("lsg.armor.DragonSlayerLeggings");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 3);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.armor.DragonSlayerLeggings");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}