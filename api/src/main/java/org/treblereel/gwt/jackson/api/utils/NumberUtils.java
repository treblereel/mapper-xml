package org.treblereel.gwt.jackson.api.utils;

import java.math.BigInteger;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/4/20
 */
public class NumberUtils {

    private final static long MIN_INT_L = Integer.MIN_VALUE;
    private final static long MAX_INT_L = Integer.MAX_VALUE;
    private final static BigInteger MIN_LONG_BIGINTEGER = new BigInteger("" + Long.MIN_VALUE);
    private final static BigInteger MAX_LONG_BIGINTEGER = new BigInteger("" + Long.MAX_VALUE);

    public static Number toNumber(String peekedString) {
        if (peekedString == null) {
            return 0;
        }
        Number result;

        if (peekedString.contains(".")) {
            // decimal
            double resultDouble = Double.parseDouble(peekedString); // don't catch this NumberFormatException.
            if (Double.isNaN(resultDouble) || Double.isInfinite(resultDouble)) {
                throw new UnsupportedOperationException("It forbids NaN and infinities: " + resultDouble);
            }
            result = resultDouble;
        } else {
            int length = peekedString.length();
            if (length <= 9) { // fits in int
                result = Integer.parseInt(peekedString);
            } else if (length <= 18) { // fits in long and potentially int
                long longResult = Long.parseLong(peekedString);
                if (length == 10) { // can fits in int
                    if (longResult < 0l) {
                        if (longResult >= MIN_INT_L) {
                            result = (int) longResult;
                        } else {
                            result = longResult;
                        }
                    } else {
                        if (longResult <= MAX_INT_L) {
                            result = (int) longResult;
                        } else {
                            result = longResult;
                        }
                    }
                } else {
                    result = longResult;
                }
            } else {
                BigInteger bigIntegerResult = new BigInteger(peekedString);
                if (bigIntegerResult.signum() == -1) {
                    if (bigIntegerResult.compareTo(MIN_LONG_BIGINTEGER) >= 0) {
                        result = bigIntegerResult.longValue();
                    } else {
                        result = bigIntegerResult;
                    }
                } else {
                    if (bigIntegerResult.compareTo(MAX_LONG_BIGINTEGER) <= 0) {
                        result = bigIntegerResult.longValue();
                    } else {
                        result = bigIntegerResult;
                    }
                }
            }
        }
        return result;
    }
}
