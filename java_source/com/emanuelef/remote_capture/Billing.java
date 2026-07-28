package com.emanuelef.remote_capture;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import androidx.collection.ArraySet;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.model.Prefs;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class Billing {
    private static final String KEY = "ME4wEAYHKoZIzj0CAQYFK4EEACEDOgAE6cS1N1P0kaiuxq0g70OVVE0uIOD+t809Etg3k2h11k8uNvfkx3mL1HTjQyzSfdueyY4DqTW7+sk=";
    public static final String MALWARE_DETECTION_SKU = "malware_detection";
    private static final String PEER_SKU_KEY = "peer_skus";
    private static final String TAG = "Billing";
    protected final Context mContext;
    protected SharedPreferences mPrefs;
    public static final String SUPPORTER_SKU = "pcapdroid_supporter";
    public static final String UNLOCK_TOKEN_SKU = "unlock_code";
    public static final String FIREWALL_SKU = "no_root_firewall";
    public static final String PCAPNG_SKU = "pcapng";
    public static final List<String> ALL_SKUS = Arrays.asList(SUPPORTER_SKU, UNLOCK_TOKEN_SKU, "malware_detection", FIREWALL_SKU, PCAPNG_SKU);
    private static final int[] res_placeholder = {C0130R.string.billing_connecting, C0130R.string.pending_transaction, C0130R.string.feature_not_available, C0130R.string.show_me, C0130R.string.loading, C0130R.string.purchased, C0130R.string.no_items_for_purchase, C0130R.string.billing_failure, C0130R.string.learn_more, C0130R.string.buy_action, C0130R.string.can_use_purchased_feature, C0130R.C0131drawable.ic_shopping_cart, C0130R.string.firewall_summary, C0130R.string.no_root_firewall, C0130R.string.unlock_token, C0130R.string.unlock_token_summary, C0130R.string.unlock_token_error, C0130R.string.license_service_unavailable, C0130R.string.requesting_unlock_token, C0130R.string.show_action, C0130R.string.unlock_token_msg1, C0130R.string.qr_license_confirm, C0130R.string.qr_purchase_required, C0130R.string.license_limit_reached, C0130R.string.license_error, C0130R.string.requesting_license};
    private static final ArraySet mPeerSkus = new ArraySet(0);

    public Billing(Context context) {
        this.mContext = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPrefs = defaultSharedPreferences;
        Set<String> stringSet = defaultSharedPreferences.getStringSet(PEER_SKU_KEY, null);
        if (stringSet != null) {
            mPeerSkus.addAll(stringSet);
        }
    }

    private byte[] getASN1(byte[] bArr, int i) {
        int i2;
        int i3;
        if (bArr.length - i == 56) {
            if (bArr[i] < 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i4 = i + 28;
            if (bArr[i4] < 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i5 = 62 + i2 + i3;
            byte[] bArr2 = new byte[i5];
            bArr2[0] = 48;
            bArr2[1] = (byte) (i5 - 2);
            bArr2[2] = 2;
            bArr2[3] = (byte) (i2 + 28);
            int i6 = 4;
            if (i2 > 0) {
                bArr2[4] = 0;
                i6 = 5;
            }
            System.arraycopy(bArr, i, bArr2, i6, 28);
            bArr2[i6 + 28] = 2;
            int i7 = i6 + 30;
            bArr2[i6 + 29] = (byte) (28 + i3);
            if (i3 > 0) {
                bArr2[i7] = 0;
                i7 = i6 + 31;
            }
            System.arraycopy(bArr, i4, bArr2, i7, 28);
            return bArr2;
        }
        throw new IllegalArgumentException("invalid signature length");
    }

    public static PlayBilling newInstance(Context context) {
        return new PlayBilling(context);
    }

    public void clearPeerSkus() {
        handlePeerSkus(new ArraySet(0));
    }

    public void connectBilling() {
    }

    public void disconnectBilling() {
    }

    public String getInstallationId() {
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            str = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
        } else {
            str = Build.SERIAL;
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            return "M" + Utils.byteArrayToHex(digest, 8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "D" + str;
        }
    }

    public String getLicense() {
        return this.mPrefs.getString("license", "");
    }

    public void handlePeerSkus(Set<String> set) {
        ArraySet arraySet = mPeerSkus;
        if (!set.equals(arraySet)) {
            arraySet.clear();
            arraySet.addAll(set);
            Log.m583i(TAG, "Peer skus updated: " + set);
            this.mPrefs.edit().putStringSet(PEER_SKU_KEY, arraySet).apply();
        }
    }

    public boolean isAvailable(String str) {
        return isPurchased(str);
    }

    public boolean isFirewallVisible() {
        if (!isPurchased(FIREWALL_SKU)) {
            return false;
        }
        if (!CaptureService.isServiceActive()) {
            return !Prefs.isRootCaptureEnabled(this.mPrefs);
        }
        if (CaptureService.isCapturingAsRoot() || CaptureService.isReadingFromPcapFile()) {
            return false;
        }
        return true;
    }

    public boolean isPlayStore() {
        return false;
    }

    public boolean isPurchased(String str) {
        if (mPeerSkus.contains(str)) {
            return true;
        }
        return !getLicense().isEmpty();
    }

    public boolean isValidLicense(String str) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            byte[] base32Decode = Utils.base32Decode(str);
            if (base32Decode.length == 60 && base32Decode[0] == 118 && base32Decode[1] == 49) {
                PublicKey generatePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.decode(KEY, 0)));
                Signature signature = Signature.getInstance("SHA1withECDSA");
                signature.initVerify(generatePublic);
                signature.update(("pcapdroid_supporter@" + getInstallationId()).getBytes(StandardCharsets.US_ASCII));
                return signature.verify(getASN1(base32Decode, 4));
            }
            return false;
        } catch (IllegalArgumentException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e) {
            Log.m587d(TAG, e.getMessage());
            return false;
        }
    }

    public boolean setLicense(String str) {
        boolean z;
        if (!isValidLicense(str)) {
            str = "";
            z = false;
        } else {
            z = true;
        }
        this.mPrefs.edit().putString("license", str).apply();
        return z;
    }
}
