package com.emanuelef.remote_capture;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.model.Geomodel;
import com.maxmind.p003db.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class Geolocation {
    private static final String TAG = "Geolocation";
    private Reader mAsnReader;
    private final Context mContext;
    private Reader mCountryReader;

    public Geolocation(Context context) {
        this.mContext = context;
        openDb();
    }

    public static void deleteDb(Context context) {
        getCountryFile(context).delete();
        getAsnFile(context).delete();
    }

    private static boolean downloadAndUnzip(Context context, String str, String str2, File file) {
        File file2 = new File(context.getCacheDir() + "/geoip_db.zip");
        if (!Utils.downloadFile(str2, file2.getAbsolutePath())) {
            Log.m581w(TAG, "Could not download " + str + " db from " + str2);
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file2.getAbsolutePath());
            if (!Utils.ungzip(fileInputStream, file.getAbsolutePath())) {
                Log.m581w(TAG, "ungzip of " + file2 + " failed");
                fileInputStream.close();
                return false;
            }
            getDbDate(file);
            fileInputStream.close();
            file2.delete();
            return true;
        } finally {
            file2.delete();
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public static boolean downloadDb(Context context) {
        String format = new SimpleDateFormat("yyyy-MM", Locale.US).format(new Date());
        String m = ViewModelProvider.Factory.CC.m595m("https://download.db-ip.com/free/dbip-country-lite-", format, ".mmdb.gz");
        String m2 = ViewModelProvider.Factory.CC.m595m("https://download.db-ip.com/free/dbip-asn-lite-", format, ".mmdb.gz");
        try {
            if (downloadAndUnzip(context, "country", m, getCountryFile(context))) {
                if (downloadAndUnzip(context, "asn", m2, getAsnFile(context))) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static File getAsnFile(Context context) {
        return new File(context.getFilesDir() + "/dbip_asn_lite.mmdb");
    }

    private static File getCountryFile(Context context) {
        return new File(context.getFilesDir() + "/dbip_country_lite.mmdb");
    }

    public static Date getDbDate(File file) {
        Reader reader = new Reader(file);
        try {
            Date buildDate = reader.getMetadata().getBuildDate();
            reader.close();
            return buildDate;
        } catch (Throwable th) {
            try {
                reader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long getDbSize(Context context) {
        return getAsnFile(context).length() + getCountryFile(context).length();
    }

    private void openDb() {
        try {
            this.mCountryReader = new Reader(getCountryFile(this.mContext));
            Log.m587d(TAG, "Country DB loaded: " + this.mCountryReader.getMetadata());
            this.mAsnReader = new Reader(getAsnFile(this.mContext));
            Log.m587d(TAG, "ASN DB loaded: " + this.mAsnReader.getMetadata());
        } catch (IOException unused) {
            Log.m583i(TAG, "Geolocation is not available");
        }
    }

    public void finalize() {
        Utils.safeClose(this.mCountryReader);
        Utils.safeClose(this.mAsnReader);
        this.mCountryReader = null;
        this.mAsnReader = null;
    }

    public Geomodel.ASN getASN(InetAddress inetAddress) {
        Reader reader = this.mAsnReader;
        if (reader != null) {
            try {
                Geomodel.ASN asn = (Geomodel.ASN) reader.get(inetAddress, Geomodel.ASN.class);
                if (asn != null) {
                    return asn;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Geomodel.ASN();
    }

    public String getCountryCode(InetAddress inetAddress) {
        Geomodel.Country country;
        Reader reader = this.mCountryReader;
        if (reader == null) {
            return "";
        }
        try {
            Geomodel.CountryResult countryResult = (Geomodel.CountryResult) reader.get(inetAddress, Geomodel.CountryResult.class);
            if (countryResult == null || (country = countryResult.country) == null) {
                return "";
            }
            return country.isoCode;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isAvailable() {
        return (this.mCountryReader == null || this.mAsnReader == null) ? false : true;
    }

    public static boolean isAvailable(Context context) {
        return getDbDate(context) != null;
    }

    public static Date getDbDate(Context context) {
        try {
            return getDbDate(getCountryFile(context));
        } catch (IOException unused) {
            return null;
        }
    }
}
