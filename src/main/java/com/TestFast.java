package com;

/**
 * Created by apple on 07/01/17.
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import java.text.ParseException;
import java.util.InputMismatchException;

final class TestFast {

    public int MOD = 1000000007;

    final void solve(int testNumber, InputReader in,OutputWriter out) throws ParseException {

        int tc = in.readInt();

        for (int k = 0; k < tc; k++) {


            int numberToTest=in.readInt();
            String s=Integer.toBinaryString(numberToTest);

            if(numberToTest%2==0){

                out.printLine(numberToTest+1);

            }else if(!s.contains("0")){

                out.printLine((long)(Math.pow(2,s.length())+(long)numberToTest));

            }else{

                out.printLine(Long.parseLong(manupilateBinaryString(s),2));

            }


        }

    }


    public  String manupilateBinaryString(String binaryNumber){





        StringBuffer stringBuffer=new StringBuffer(binaryNumber);
        return new  StringBuffer( stringBuffer.reverse().toString().replaceFirst("0","1")).reverse().toString();









    }


    long pow_mod(long a, long b, long m) {
        long x = 1, y = a;
        while (b > 0) {
            if (b == 1) {
                x = (x * y) % m;
            }
            y = (y * y) % m;
            b >>= 1;
        }
        return x;
    }

    long fast_exp(long a, long b, long p) {
        if (b == 1) {
            return a % p;
        }
        if (b == 2) {
            return (a * a) % p;
        }

        if (b % 2 == 0) {
            return fast_exp(fast_exp(a, b / 2, p) % p, 2, p) % p;
        } else {
            return a * fast_exp(fast_exp(a, (b - 1) / 2, p) % p, 2, p) % p;
        }
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }

}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        return (char) c;
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, readInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public int[] readIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }

    public long[] readLongArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = readLong();
        }
        return array;
    }

    public double[] readDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = readDouble();
        }
        return array;
    }

    public String[] readStringArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = readString();
        }
        return array;
    }

    public char[][] readTable(int rowCount, int columnCount) {
        char[][] table = new char[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                table[i][j] = readCharacter();
            }
        }
        return table;
    }

    public void readIntArrays(int[]
                                      ... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = readInt();
            }
        }
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {

        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {

    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    public void printLine(int i) {
        writer.println(i);
    }
}

class IOUtils {

    public static void readIntArrays(InputReader in, int[]
            ... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = in.readInt();
            }
        }
    }

    public static long[] readLongArray(InputReader in, int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.readLong();
        }
        return array;
    }

}

class ArrayUtils {

    public static int maxElement(int[] array) {
        return maxElement(array, 0, array.length);
    }

    public static int maxElement(int[] array, int from, int to) {
        int result = Integer.MIN_VALUE;
        for (int i = from; i < to; i++) {
            result = Math.max(result, array[i]);
        }
        return result;
    }

    public static int minPosition(int[] array) {
        return minPosition(array, 0, array.length);
    }

    public static int minPosition(int[] array, int from, int to) {
        if (from >= to) {
            return -1;
        }
        int min = array[from];
        int result = from;
        for (int i = from + 1; i < to; i++) {
            if (array[i] < min) {
                min = array[i];
                result = i;
            }
        }
        return result;
    }

    public static int minElement(int[] array) {
        return array[minPosition(array)];
    }

    public static void main(String[] args) throws ParseException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TestFast solver = new TestFast();
        solver.solve(1, in, out);
        out.close();
    }

}
