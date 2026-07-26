package com.emanuelef.remote_capture.model;

import com.maxmind.p003db.MaxMindDbConstructor;
import com.maxmind.p003db.MaxMindDbParameter;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Geomodel {

    /* loaded from: classes.dex */
    public static class Country implements Serializable {
        public final String isoCode;

        @MaxMindDbConstructor
        public Country(@MaxMindDbParameter(name = "iso_code") String str) {
            this.isoCode = str;
        }
    }

    /* loaded from: classes.dex */
    public static class CountryResult {
        public final Country country;

        @MaxMindDbConstructor
        public CountryResult(@MaxMindDbParameter(name = "country") Country country) {
            this.country = country;
        }
    }

    /* loaded from: classes.dex */
    public static class ASN implements Serializable {
        public final String asname;
        public final long number;

        public ASN() {
            this.number = 0L;
            this.asname = "";
        }

        public boolean isKnown() {
            if (this.number != 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            if (this.number == 0) {
                return "Unknown ASN";
            }
            return "AS" + this.number + " - " + this.asname;
        }

        @MaxMindDbConstructor
        public ASN(@MaxMindDbParameter(name = "autonomous_system_number") long j, @MaxMindDbParameter(name = "autonomous_system_organization") String str) {
            this.number = j;
            this.asname = str;
        }
    }
}
