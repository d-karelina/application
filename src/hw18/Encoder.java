package hw18;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//вынести в свойство пароль

public class Encoder extends FilterOutputStream {
    protected byte code[];
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public Encoder(OutputStream out) {
        super(out);
    }

    public void encode(String text, String password, OutputStream out) throws IOException {
        if (text == null || password == null) throw new NullPointerException("строка == null") ;

        byte[] textBytes = text.getBytes();
        byte[] encodedBytes = new byte[textBytes.length] ;
        byte[] bytePassword = password.getBytes() ;
        int countByte = 0 ;

        for (int i=0; i<textBytes.length; i++) {
            encodedBytes[i] = (byte) (textBytes[i] ^ bytePassword[countByte]) ;
            countByte ++ ;
            if (countByte == bytePassword.length) countByte = 0 ;
        }

        out.write(encodedBytes);
    }
}
