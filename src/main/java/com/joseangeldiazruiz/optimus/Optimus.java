package com.joseangeldiazruiz.optimus;

import java.math.BigInteger;

public class Optimus {

    private final int prime;
    private final int modInverse;
    private final int randomNumber;

    private static final int MAX_INT = Integer.MAX_VALUE;

    public Optimus(int prime, int modInverse, int randomNumber) {

        if (!isProbablyPrime(prime))
            throw new IllegalArgumentException(String.format("%d is not a prime number", prime));

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

    public static int ModInverse(int n)
    {

        BigInteger p = BigInteger.valueOf(n);
        long l = Long.valueOf(MAX_INT) + 1L;
        BigInteger m = BigInteger.valueOf(l);
        return p.modInverse(m).intValue();
    }

    public static boolean isProbablyPrime(int n)
    {
        return BigInteger.valueOf(n - 1).nextProbablePrime().equals(BigInteger.valueOf(n));
    }

}
