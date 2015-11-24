package com.joseangeldiazruiz.optimus;


import java.math.BigInteger;

public class Optimus {

    private final int prime;
    private final int modInverse;
    private final int randomNumber;

    private static final int MAX_INT = Integer.MAX_VALUE;

    public Optimus(int prime, int modInverse, int randomNumber) {
        this.prime = prime;
        this.modInverse = modInverse;
        this.randomNumber = randomNumber;
    }

    public Optimus(int prime, int randomNumber)
    {
        this(prime, ModInverse(prime), randomNumber);
    }


    public int encode(int n)
    {
        return ((n * this.prime) & MAX_INT) ^ this.randomNumber;
    }


    public int decode(int n)
    {
        return ((n ^ this.randomNumber) * this.modInverse ) & MAX_INT;
    }

    public static int ModInverse(int prime)
    {
        BigInteger p = new BigInteger(String.valueOf(prime));
        long l = Long.valueOf(MAX_INT) + 1L;
        BigInteger m = BigInteger.valueOf(l);
        return p.modInverse(m).intValue();
    }

}
