package co.edu.uniquindio.proyecto.segurity;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {
    public Hash() {
    }
    public static Hash factory(){
        return new Hash();
    }

    public String toSha1(String value){
        String sha1 = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            return sha1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
