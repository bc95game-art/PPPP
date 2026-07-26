package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Streams;
import j$.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {
    public final Serializable value;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.value = bool;
    }

    public static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Serializable serializable = jsonPrimitive.value;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        double d;
        double d2;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        Serializable serializable = jsonPrimitive.value;
        Serializable serializable2 = this.value;
        if (serializable2 == null) {
            if (serializable == null) {
                return true;
            }
            return false;
        } else if (!isIntegral(this) || !isIntegral(jsonPrimitive)) {
            if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
                return serializable2.equals(serializable);
            }
            if (!(serializable2 instanceof BigDecimal) || !(serializable instanceof BigDecimal)) {
                if (serializable2 instanceof Number) {
                    d = getAsNumber().doubleValue();
                } else {
                    d = Double.parseDouble(getAsString());
                }
                if (serializable instanceof Number) {
                    d2 = jsonPrimitive.getAsNumber().doubleValue();
                } else {
                    d2 = Double.parseDouble(jsonPrimitive.getAsString());
                }
                if (d == d2) {
                    return true;
                }
                if (!Double.isNaN(d) || !Double.isNaN(d2)) {
                    return false;
                }
                return true;
            }
            if (serializable2 instanceof BigDecimal) {
                bigDecimal = (BigDecimal) serializable2;
            } else {
                bigDecimal = Streams.parseBigDecimal(getAsString());
            }
            if (serializable instanceof BigDecimal) {
                bigDecimal2 = (BigDecimal) serializable;
            } else {
                bigDecimal2 = Streams.parseBigDecimal(jsonPrimitive.getAsString());
            }
            if (bigDecimal.compareTo(bigDecimal2) == 0) {
                return true;
            }
            return false;
        } else if ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) {
            return getAsBigInteger().equals(jsonPrimitive.getAsBigInteger());
        } else {
            if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
                return true;
            }
            return false;
        }
    }

    public final BigInteger getAsBigInteger() {
        Serializable serializable = this.value;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (isIntegral(this)) {
            return BigInteger.valueOf(getAsNumber().longValue());
        }
        String asString = getAsString();
        Streams.checkNumberStringLength(asString);
        return new BigInteger(asString);
    }

    public final int getAsInt() {
        if (this.value instanceof Number) {
            return getAsNumber().intValue();
        }
        return Integer.parseInt(getAsString());
    }

    public final Number getAsNumber() {
        Serializable serializable = this.value;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new LazilyParsedNumber((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // com.google.gson.JsonElement
    public final String getAsString() {
        Serializable serializable = this.value;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return getAsNumber().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.value;
        if (serializable == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else if (!(serializable instanceof Number)) {
            return serializable.hashCode();
        } else {
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.value = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.value = str;
    }
}
