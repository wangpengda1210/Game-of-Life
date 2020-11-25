import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements CharSequence {

    byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray.clone();
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int i) {
        return (char) byteArray[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] subArray = new byte[i1 - i];
        if (i1 - i >= 0) System.arraycopy(byteArray, i, subArray, 0, i1 - i);
        return new AsciiCharSequence(subArray);
    }

    @NotNull
    @Override
    public String toString() {
        return new String(byteArray, StandardCharsets.UTF_8);
    }

}