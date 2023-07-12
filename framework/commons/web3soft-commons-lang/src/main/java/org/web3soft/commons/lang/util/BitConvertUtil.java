package org.web3soft.commons.lang.util;

import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author web3soft-team
 **/
public class BitConvertUtil {

    public static final String HEX_CHARS_STR = "0123456789ABCDEF";

    public static short byteToShort(final byte b) {
        final ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put((byte) 0);
        buffer.put(b);
        buffer.flip();
        return buffer.getShort();
    }

    public static byte[] getBytes(final short value) {
        final ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putShort(value);
        return buffer.array();
    }

    public static byte[] getBytes(final int value) {
        final ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(value);
        return buffer.array();
    }

    public static byte[] getBytes(final long value) {
        final ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(value);
        return buffer.array();
    }

    public static byte[] getShortBytes(final double value, final double ratio) {
        return getBytes((short) (value * ratio));
    }

    public static byte[] getIntBytes(final double value, final double ratio) {
        return getBytes((int) (value * ratio));
    }

    public static byte[] getLongBytes(final double value, final double ratio) {
        return getBytes((long) (value * ratio));
    }

    public static short getReverseShort(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getShort(getReverseBytes(bytes));
    }

    public static short getReverseShort(final byte[] src) {
        return getShort(getReverseBytes(src));
    }

    public static short getShort(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getShort(bytes);
    }

    public static short getShort(final byte[] bytes) {
        final ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        return buffer.getShort();
    }

    public static int getReverseInt(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getInt(getReverseBytes(bytes));
    }

    public static int getReverseInt(final byte[] src) {
        return getInt(getReverseBytes(src));
    }

    public static int getInt(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getInt(bytes);
    }

    public static int getInt(final byte[] bytes) {
        final ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        return buffer.getInt();
    }

    public static long getReverseLong(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getLong(getReverseBytes(bytes));
    }

    public static long getReverseLong(final byte[] src) {
        return getLong(getReverseBytes(src));
    }

    public static long getLong(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getLong(bytes);
    }

    public static long getLong(final byte[] bytes) {
        final ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        return buffer.getLong();
    }

    public static String getBitString(final byte value) {
        return bytesToBitString(getBytes(value));
    }

    public static String getBitString(final short value) {
        return bytesToBitString(getBytes(value));
    }

    public static String getBitString(final int value) {
        return bytesToBitString(getBytes(value));
    }

    public static String getBitString(final long value) {
        return bytesToBitString(getBytes(value));
    }

    public static String bytesToBitString(final byte[] bytes) {
        final StringBuilder sb = new StringBuilder();
        for (final byte b : bytes) {
            sb.append(byteToBitString(b));
        }
        return sb.toString();
    }

    public static String byteToBitString(final byte b) {
        return String.format("%s%s%s%s%s%s%s%s",
                (byte) ((b >> 7) & 0x1),
                (byte) ((b >> 6) & 0x1),
                (byte) ((b >> 5) & 0x1),
                (byte) ((b >> 4) & 0x1),
                (byte) ((b >> 3) & 0x1),
                (byte) ((b >> 2) & 0x1),
                (byte) ((b >> 1) & 0x1),
                (byte) (b & 0x1)
        );
    }

    public static byte[] getReverseBytes(final short x) {
        return getReverseBytes(getBytes(x));
    }

    public static byte[] getReverseBytes(final int x) {
        return getReverseBytes(getBytes(x));
    }

    public static byte[] getReverseBytes(final long x) {
        return getReverseBytes(getBytes(x));
    }

    public static byte[] getReverseBytes(final byte[] src) {
        return getReverseBytes(src, 0, src.length);
    }

    public static byte[] getReverseBytes(final byte[] src, final int startIndexInclusive, final int endIndexExclusive) {
        if (src == null) {
            return null;
        }

        final int start = Math.max(startIndexInclusive, 0);
        final int end = Math.min(src.length, endIndexExclusive);
        final int length = end - start;
        final byte[] dest = new byte[length];
        for (int i = 0; i < length; i++) {
            dest[i] = src[end - i - 1];
        }
        return dest;
    }

    public static String getHexStringWith0X(final String hexStr) {
        return "0x" + hexStr;
    }

    public static String getHexString(final byte src) {
        final byte[] bytes = new byte[]{src};
        return StringUtils.trim(bytesToHexString(bytes, ""));
    }

    public static String getHexString(final short src) {
        final byte[] bytes = getBytes(src);
        return StringUtils.trim(bytesToHexString(bytes, ""));
    }

    public static String getHexString(final int src) {
        final byte[] bytes = getBytes(src);
        return StringUtils.trim(bytesToHexString(bytes, ""));
    }

    public static String getHexString(final long src) {
        final byte[] bytes = getBytes(src);
        return StringUtils.trim(bytesToHexString(bytes, ""));
    }

    public static String getHexString(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return StringUtils.trim(bytesToHexString(bytes, ""));
    }

    public static String getReverseHexString(final byte[] src, final int startIndex, final int endIndex) {
        final byte[] bytes = Arrays.copyOfRange(src, startIndex, endIndex);
        return getReverseHexString(bytes);
    }

    public static String getReverseHexString(final byte[] src) {
        final byte[] bytes = getReverseBytes(src);
        return StringUtils.trim(bytesToHexString(bytes, ""));
    }

    public static String bytesToHexString(final byte[] src) {
        return bytesToHexString(src, " ");
    }

    public static String bytesToHexString(final byte[] src, final String operator) {
        final StringBuilder stringBuilder = new StringBuilder(StringUtils.EMPTY);
        if (src == null || src.length == 0) {
            return null;
        }
        for (final byte b : src) {
            final int v = b & 0xFF;
            final String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv).append(operator);
        }
        return stringBuilder.toString().toUpperCase();
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (StringUtils.isBlank(hexString)) {
            return null;
        }
        hexString = hexString.toUpperCase();
        final int length = hexString.length() / 2;
        final char[] hexChars = hexString.toCharArray();
        final byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            final int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    public static byte[] getBytes(final byte[] src, final int length) {
        if (length <= src.length) {
            return src;
        }
        final byte[] bytes = new byte[length];
        for (int i = 0; i < src.length; i++) {
            bytes[bytes.length - 1 - i] = src[src.length - 1 - i];
        }
        return bytes;
    }

    public static byte[] getFixedLengthBytes(final int length) {
        if (length <= 0) {
            return new byte[]{0x0};
        }
        final byte[] bytes = new byte[length];
        IntStream.range(0, length).forEach(i -> bytes[i] = 0);
        return bytes;
    }

    public static byte[] listToArray(final List<Byte> list) {
        final byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    public static void copyArrayToList(final byte[] unit, final List<Byte> list) {
        for (final byte b : unit) {
            list.add(b);
        }
    }

    private static byte charToByte(final char index) {
        return (byte) HEX_CHARS_STR.indexOf(index);
    }

    public static long setBitValue(long value, final int pos, final int bit) {
        final long dex = 1L;
        if (getBitValue(value, pos) == 1) {
            if (bit == 0) {
                value = value - (dex << pos - 1);
            }
        } else {
            if (bit == 1) {
                value = value | (dex << pos - 1);
            }
        }
        return value;
    }


    public static long getBitValue(final long value, final int pos) {
        return value >> pos & 1;
    }

    /**
     * 按位取值，返回指定位的值<br>
     *
     * @param value value
     * @param pos   指定位序号，从1开始
     * @return int
     */
    public static int getBinaryIndex(final long value, final int pos) {
        return (int) (value >> (pos - 1) & 1);
    }
}
