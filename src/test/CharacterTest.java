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
}