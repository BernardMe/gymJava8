package org.learnit.cryptogram;

import org.junit.Test;

public class Test01 {

    @Test
    public void testEncrypt() throws Exception {
        String abc = "Hello, 一灰灰Blog!";
        String key = "JC66fRd3wj85k8Hr";
        String out = EncryptUtil.encrypt(abc, key);
        System.out.println(out);

        System.out.println(EncryptUtil.decrypt(out, key));
    }

    @Test
    public void testEncryptByte() throws Exception {
        String abc = "Hello, 一灰灰Blog!";
        String key = "JC66fRd3wj85k8Hr";
        byte[] out = EncryptUtil.encrypt2bytes(abc, key);
        System.out.println(new String(out));

        System.out.println(EncryptUtil.decrypt(out, key));
    }
}
