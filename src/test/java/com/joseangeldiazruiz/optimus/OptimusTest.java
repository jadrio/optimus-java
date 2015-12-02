package com.joseangeldiazruiz.optimus;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class OptimusTest {

    int prime = 1580030173;
    int modInverse = 59260789;
    int randomInt = 1163945558;
    int hash = 1103647397;
    int id = 15;

    Optimus optimus = new Optimus(prime, modInverse, randomInt);

    @Test
    public void testEncode() throws Exception
    {
        assertEquals(hash,optimus.encode(id));
    }

    @Test
    public void testDecode() throws Exception
    {
        assertEquals(id, optimus.decode(hash));
    }

    @Test
    public void testModInverse() throws Exception
    {
        assertEquals(modInverse, Optimus.ModInverse(prime));
    }

    @Test
    public void testIsProbablyPrime()
    {
        assertTrue(Optimus.isProbablyPrime(3));
    }

}