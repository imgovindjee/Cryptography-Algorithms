package Cipher.Algorithms.RSA;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

//    Taking to random BIGGER prime number say 'p' and 'q'
    private BigInteger p_prime1;
    private BigInteger q_prime2;

    private BigInteger N;
    private BigInteger phi_N;

//    Judging the e-> public[FOR BROADCAST] and  d-> private key[FOR DECRYPT the Message]
    private BigInteger e;
    private BigInteger d;

    private final int bitLength = 1024;
    private Random random;


    public RSA() {
        random = new Random();

        this.p_prime1 = BigInteger.probablePrime(bitLength, random);
        this.q_prime2 = BigInteger.probablePrime(bitLength, random);
        this.N = p_prime1.multiply(q_prime2);
        this.phi_N = p_prime1.subtract(BigInteger.ONE).multiply(q_prime2.subtract(BigInteger.ONE));

//        CALCULATE THE PUBLIC KEY [THAT NEED TO BE BROADCAST]
        e = BigInteger.probablePrime(bitLength / 2, random);
        while (phi_N.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi_N) < 0 ) {
            e.add(BigInteger.ONE);
        }
//        CALCULATE THE PRIVATE KEY [THAT IS USED FOR DECRYPTED THE MESSAGE]
        d = e.modInverse(phi_N);
    }

    public RSA(BigInteger e, BigInteger d, BigInteger N) {
        this.e = e;
        this.d = d;
        this.N = N;
    }

    public byte[] encryptMessage(byte[] messageToEncrypt) {
        return (new BigInteger(messageToEncrypt).modPow(e, N).toByteArray());
    }

    public byte[] decryptMessage(byte[] messageToDecrypt) {
        return (new BigInteger(messageToDecrypt).modPow(d, N).toByteArray());
    }

    public String bytesToString(byte[] encryptedMessageBytes) {
        StringBuilder sb = new StringBuilder();
        for (byte encryptedMessageByte: encryptedMessageBytes) {
            sb.append(Byte.toString(encryptedMessageByte));
        }
        return sb.toString();
    }
}
