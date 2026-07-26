package androidx.profileinstaller;

import android.content.pm.PackageInfo;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.ViewUtilsApi21;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
/* loaded from: classes.dex */
public abstract class Encoding {
    public static final ViewUtilsApi21 EMPTY_DIAGNOSTICS = new Object();
    public static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    public static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    public static final byte[] V015_S = {48, 49, 53, 0};
    public static final byte[] V010_P = {48, 49, 48, 0};
    public static final byte[] V009_O_MR1 = {48, 48, 57, 0};
    public static final byte[] V005_O = {48, 48, 53, 0};
    public static final byte[] V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V002 = {48, 48, 50, 0};

    /* JADX WARN: Finally extract failed */
    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i2 += ((((dexProfileData.numMethodIds * 2) + 7) & (-8)) / 8) + (dexProfileData.classSetSize * 2) + generateDexKey(bArr, dexProfileData.apkName, dexProfileData.dexName).getBytes(StandardCharsets.UTF_8).length + 16 + dexProfileData.hotMethodRegionSize;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, V009_O_MR1)) {
            int length = dexProfileDataArr.length;
            while (i < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(bArr, dexProfileData2.apkName, dexProfileData2.dexName));
                writeLineData(byteArrayOutputStream, dexProfileData2);
                i++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(bArr, dexProfileData3.apkName, dexProfileData3.dexName));
            }
            int length2 = dexProfileDataArr.length;
            while (i < length2) {
                writeLineData(byteArrayOutputStream, dexProfileDataArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == i2) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i2);
    }

    public static boolean deleteFilesRecursively(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z = true;
            for (File file2 : listFiles) {
                if (!deleteFilesRecursively(file2) || !z) {
                    z = false;
                } else {
                    z = true;
                }
            }
            return z;
        }
        file.delete();
        return true;
    }

    public static String generateDexKey(byte[] bArr, String str, String str2) {
        Object obj;
        byte[] bArr2 = V001_N;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = V005_O;
        String str3 = "!";
        if (!equals && !Arrays.equals(bArr, bArr3)) {
            obj = str3;
        } else {
            obj = ":";
        }
        if (str.length() <= 0) {
            if (str3.equals(obj)) {
                return str2.replace(":", str3);
            }
            if (":".equals(obj)) {
                return str2.replace(str3, ":");
            }
        } else if (str2.equals("classes.dex")) {
            return str;
        } else {
            if (str2.contains(str3) || str2.contains(":")) {
                if (str3.equals(obj)) {
                    return str2.replace(":", str3);
                }
                if (":".equals(obj)) {
                    return str2.replace(str3, ":");
                }
            } else if (!str2.endsWith(".apk")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                    str3 = ":";
                }
                return ViewModelProvider.Factory.CC.m(sb, str3, str2);
            }
        }
        return str2;
    }

    public static void noteProfileWrittenFor(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public static byte[] read(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read >= 0) {
                i2 += read;
            } else {
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m(i, "Not enough bytes to read: "));
            }
        }
        return bArr;
    }

    public static int[] readClasses(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += (int) readUInt(byteArrayInputStream, 2);
            iArr[i3] = i2;
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r0.finished() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] readCompressed(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L2e
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            r4 = 0
            r5 = 0
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            if (r4 >= r9) goto L57
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L2e
            if (r6 < 0) goto L3b
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L2e
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.lang.Throwable -> L2e java.util.zip.DataFormatException -> L30
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            goto L8a
        L30:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L3b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L57:
            if (r4 != r9) goto L6b
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L63
            r0.end()
            return r1
        L63:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            r8.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L8a:
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.Encoding.readCompressed(java.io.FileInputStream, int, int):byte[]");
    }

    public static DexProfileData[] readMeta(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) {
        byte[] bArr3 = METADATA_V001_N;
        if (Arrays.equals(bArr, bArr3)) {
            if (Arrays.equals(V015_S, bArr2)) {
                throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            } else if (Arrays.equals(bArr, bArr3)) {
                int readUInt = (int) readUInt(fileInputStream, 1);
                byte[] readCompressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                    try {
                        DexProfileData[] readMetadataForNBody = readMetadataForNBody(byteArrayInputStream, readUInt, dexProfileDataArr);
                        byteArrayInputStream.close();
                        return readMetadataForNBody;
                    } catch (Throwable th) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("Content found after the end of file");
                }
            } else {
                throw new IllegalStateException("Unsupported meta version");
            }
        } else if (Arrays.equals(bArr, METADATA_V002)) {
            int readUInt2 = (int) readUInt(fileInputStream, 2);
            byte[] readCompressed2 = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(readCompressed2);
                try {
                    DexProfileData[] readMetadataV002Body = readMetadataV002Body(byteArrayInputStream2, bArr2, readUInt2, dexProfileDataArr);
                    byteArrayInputStream2.close();
                    return readMetadataV002Body;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported meta version");
        }
    }

    public static DexProfileData[] readMetadataForNBody(ByteArrayInputStream byteArrayInputStream, int i, DexProfileData[] dexProfileDataArr) {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i == dexProfileDataArr.length) {
            String[] strArr = new String[i];
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                int readUInt = (int) readUInt(byteArrayInputStream, 2);
                iArr[i2] = (int) readUInt(byteArrayInputStream, 2);
                strArr[i2] = new String(read(byteArrayInputStream, readUInt), StandardCharsets.UTF_8);
            }
            for (int i3 = 0; i3 < i; i3++) {
                DexProfileData dexProfileData = dexProfileDataArr[i3];
                if (dexProfileData.dexName.equals(strArr[i3])) {
                    int i4 = iArr[i3];
                    dexProfileData.classSetSize = i4;
                    dexProfileData.classes = readClasses(byteArrayInputStream, i4);
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static DexProfileData[] readMetadataV002Body(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, DexProfileData[] dexProfileDataArr) {
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i == dexProfileDataArr.length) {
            for (int i2 = 0; i2 < i; i2++) {
                readUInt(byteArrayInputStream, 2);
                String str2 = new String(read(byteArrayInputStream, (int) readUInt(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
                long readUInt = readUInt(byteArrayInputStream, 4);
                int readUInt2 = (int) readUInt(byteArrayInputStream, 2);
                DexProfileData dexProfileData = null;
                if (dexProfileDataArr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(":");
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= dexProfileDataArr.length) {
                            break;
                        } else if (dexProfileDataArr[i3].dexName.equals(str)) {
                            dexProfileData = dexProfileDataArr[i3];
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (dexProfileData != null) {
                    dexProfileData.mTypeIdCount = readUInt;
                    int[] readClasses = readClasses(byteArrayInputStream, readUInt2);
                    if (Arrays.equals(bArr, V001_N)) {
                        dexProfileData.classSetSize = readUInt2;
                        dexProfileData.classes = readClasses;
                    }
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return dexProfileDataArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static DexProfileData[] readProfile(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, V010_P)) {
            int readUInt = (int) readUInt(fileInputStream, 1);
            byte[] readCompressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                try {
                    DexProfileData[] readUncompressedBody = readUncompressedBody(byteArrayInputStream, str, readUInt);
                    byteArrayInputStream.close();
                    return readUncompressedBody;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported version");
        }
    }

    public static long readUInt(InputStream inputStream, int i) {
        byte[] read = read(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (read[i2] & 255) << (i2 * 8);
        }
        return j;
    }

    public static DexProfileData[] readUncompressedBody(ByteArrayInputStream byteArrayInputStream, String str, int i) {
        int i2;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i];
        for (int i3 = 0; i3 < i; i3++) {
            int readUInt = (int) readUInt(byteArrayInputStream, 2);
            dexProfileDataArr[i3] = new DexProfileData(str, new String(read(byteArrayInputStream, (int) readUInt(byteArrayInputStream, 2)), StandardCharsets.UTF_8), readUInt(byteArrayInputStream, 4), readUInt, (int) readUInt(byteArrayInputStream, 4), (int) readUInt(byteArrayInputStream, 4), new int[readUInt], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i) {
            DexProfileData dexProfileData = dexProfileDataArr[i4];
            int available = byteArrayInputStream.available();
            int i5 = dexProfileData.hotMethodRegionSize;
            int i6 = dexProfileData.numMethodIds;
            TreeMap treeMap = dexProfileData.methods;
            int i7 = available - i5;
            int i8 = 0;
            while (byteArrayInputStream.available() > i7) {
                i8 += (int) readUInt(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i8), 1);
                int readUInt2 = (int) readUInt(byteArrayInputStream, 2);
                while (readUInt2 > 0) {
                    readUInt(byteArrayInputStream, 2);
                    int readUInt3 = (int) readUInt(byteArrayInputStream, 1);
                    if (!(readUInt3 == 6 || readUInt3 == 7)) {
                        while (readUInt3 > 0) {
                            readUInt(byteArrayInputStream, 1);
                            int i9 = i4;
                            for (int readUInt4 = (int) readUInt(byteArrayInputStream, 1); readUInt4 > 0; readUInt4--) {
                                readUInt(byteArrayInputStream, 2);
                            }
                            readUInt3--;
                            i4 = i9;
                        }
                    }
                    readUInt2--;
                    i4 = i4;
                }
            }
            int i10 = i4;
            if (byteArrayInputStream.available() == i7) {
                dexProfileData.classes = readClasses(byteArrayInputStream, dexProfileData.classSetSize);
                BitSet valueOf = BitSet.valueOf(read(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
                for (int i11 = 0; i11 < i6; i11++) {
                    if (valueOf.get(i11)) {
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    if (valueOf.get(i11 + i6)) {
                        i2 |= 4;
                    }
                    if (i2 != 0) {
                        Integer num = (Integer) treeMap.get(Integer.valueOf(i11));
                        if (num == null) {
                            num = 0;
                        }
                        treeMap.put(Integer.valueOf(i11), Integer.valueOf(i2 | num.intValue()));
                    }
                }
                i4 = i10 + 1;
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return dexProfileDataArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean transcodeAndWriteBody(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) {
        long j;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = V015_S;
        if (Arrays.equals(bArr, bArr2)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                writeUInt16(byteArrayOutputStream2, dexProfileDataArr.length);
                int i = 2;
                for (DexProfileData dexProfileData : dexProfileDataArr) {
                    writeUInt(byteArrayOutputStream2, dexProfileData.dexChecksum, 4);
                    writeUInt(byteArrayOutputStream2, dexProfileData.mTypeIdCount, 4);
                    writeUInt(byteArrayOutputStream2, dexProfileData.numMethodIds, 4);
                    String generateDexKey = generateDexKey(bArr2, dexProfileData.apkName, dexProfileData.dexName);
                    Charset charset = StandardCharsets.UTF_8;
                    int length2 = generateDexKey.getBytes(charset).length;
                    writeUInt16(byteArrayOutputStream2, length2);
                    i = i + 14 + length2;
                    byteArrayOutputStream2.write(generateDexKey.getBytes(charset));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i == byteArray.length) {
                    WritableFileSection writableFileSection = new WritableFileSection(1, byteArray, false);
                    byteArrayOutputStream2.close();
                    arrayList2.add(writableFileSection);
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    int i2 = 0;
                    for (int i3 = 0; i3 < dexProfileDataArr.length; i3++) {
                        try {
                            DexProfileData dexProfileData2 = dexProfileDataArr[i3];
                            writeUInt16(byteArrayOutputStream3, i3);
                            writeUInt16(byteArrayOutputStream3, dexProfileData2.classSetSize);
                            i2 = i2 + 4 + (dexProfileData2.classSetSize * 2);
                            int[] iArr = dexProfileData2.classes;
                            int length3 = iArr.length;
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < length3) {
                                int i6 = iArr[i4];
                                writeUInt16(byteArrayOutputStream3, i6 - i5);
                                i4++;
                                i5 = i6;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    if (i2 == byteArray2.length) {
                        WritableFileSection writableFileSection2 = new WritableFileSection(3, byteArray2, true);
                        byteArrayOutputStream3.close();
                        arrayList2.add(writableFileSection2);
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        int i7 = 0;
                        int i8 = 0;
                        while (i7 < dexProfileDataArr.length) {
                            try {
                                DexProfileData dexProfileData3 = dexProfileDataArr[i7];
                                int i9 = 0;
                                for (Map.Entry entry : dexProfileData3.methods.entrySet()) {
                                    i9 |= ((Integer) entry.getValue()).intValue();
                                }
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                writeMethodBitmapForS(byteArrayOutputStream4, i9, dexProfileData3);
                                byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                                byteArrayOutputStream4.close();
                                ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                                writeMethodsWithInlineCaches(byteArrayOutputStream5, dexProfileData3);
                                byte[] byteArray4 = byteArrayOutputStream5.toByteArray();
                                byteArrayOutputStream5.close();
                                writeUInt16(byteArrayOutputStream3, i7);
                                int length4 = byteArray3.length + 2 + byteArray4.length;
                                int i10 = i8 + 6;
                                ArrayList arrayList4 = arrayList3;
                                writeUInt(byteArrayOutputStream3, length4, 4);
                                writeUInt16(byteArrayOutputStream3, i9);
                                byteArrayOutputStream3.write(byteArray3);
                                byteArrayOutputStream3.write(byteArray4);
                                i8 = i10 + length4;
                                i7++;
                                arrayList3 = arrayList4;
                            } finally {
                                try {
                                    byteArrayOutputStream3.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
                        if (i8 == byteArray5.length) {
                            WritableFileSection writableFileSection3 = new WritableFileSection(4, byteArray5, true);
                            byteArrayOutputStream3.close();
                            arrayList2.add(writableFileSection3);
                            long j2 = 4;
                            long size = j2 + j2 + 4 + (arrayList2.size() * 16);
                            writeUInt(byteArrayOutputStream, arrayList2.size(), 4);
                            int i11 = 0;
                            while (i11 < arrayList2.size()) {
                                WritableFileSection writableFileSection4 = (WritableFileSection) arrayList2.get(i11);
                                int i12 = writableFileSection4.mType;
                                byte[] bArr3 = writableFileSection4.mContents;
                                if (i12 == 1) {
                                    j = 0;
                                } else if (i12 == 2) {
                                    j = 1;
                                } else if (i12 == 3) {
                                    j = 2;
                                } else if (i12 == 4) {
                                    j = 3;
                                } else if (i12 == 5) {
                                    j = 4;
                                } else {
                                    throw null;
                                }
                                writeUInt(byteArrayOutputStream, j, 4);
                                writeUInt(byteArrayOutputStream, size, 4);
                                if (writableFileSection4.mNeedsCompression) {
                                    byte[] compress = compress(bArr3);
                                    arrayList = arrayList5;
                                    arrayList.add(compress);
                                    writeUInt(byteArrayOutputStream, compress.length, 4);
                                    writeUInt(byteArrayOutputStream, bArr3.length, 4);
                                    length = compress.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr3);
                                    writeUInt(byteArrayOutputStream, bArr3.length, 4);
                                    writeUInt(byteArrayOutputStream, 0L, 4);
                                    length = bArr3.length;
                                }
                                size += length;
                                i11++;
                                arrayList5 = arrayList;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int i13 = 0; i13 < arrayList6.size(); i13++) {
                                byteArrayOutputStream.write((byte[]) arrayList6.get(i13));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray5.length);
                    } else {
                        throw new IllegalStateException("Expected size " + i2 + ", does not match actual size " + byteArray2.length);
                    }
                } else {
                    throw new IllegalStateException("Expected size " + i + ", does not match actual size " + byteArray.length);
                }
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } else {
            byte[] bArr4 = V010_P;
            if (Arrays.equals(bArr, bArr4)) {
                byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, bArr4);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, createCompressibleBody.length, 4);
                byte[] compress2 = compress(createCompressibleBody);
                writeUInt(byteArrayOutputStream, compress2.length, 4);
                byteArrayOutputStream.write(compress2);
                return true;
            }
            byte[] bArr5 = V005_O;
            if (Arrays.equals(bArr, bArr5)) {
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                for (DexProfileData dexProfileData4 : dexProfileDataArr) {
                    String generateDexKey2 = generateDexKey(bArr5, dexProfileData4.apkName, dexProfileData4.dexName);
                    Charset charset2 = StandardCharsets.UTF_8;
                    writeUInt16(byteArrayOutputStream, generateDexKey2.getBytes(charset2).length);
                    writeUInt16(byteArrayOutputStream, dexProfileData4.classes.length);
                    writeUInt(byteArrayOutputStream, dexProfileData4.methods.size() * 4, 4);
                    writeUInt(byteArrayOutputStream, dexProfileData4.dexChecksum, 4);
                    byteArrayOutputStream.write(generateDexKey2.getBytes(charset2));
                    for (Integer num : dexProfileData4.methods.keySet()) {
                        writeUInt16(byteArrayOutputStream, num.intValue());
                        writeUInt16(byteArrayOutputStream, 0);
                    }
                    for (int i14 : dexProfileData4.classes) {
                        writeUInt16(byteArrayOutputStream, i14);
                    }
                }
                return true;
            }
            byte[] bArr6 = V009_O_MR1;
            if (Arrays.equals(bArr, bArr6)) {
                byte[] createCompressibleBody2 = createCompressibleBody(dexProfileDataArr, bArr6);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, createCompressibleBody2.length, 4);
                byte[] compress3 = compress(createCompressibleBody2);
                writeUInt(byteArrayOutputStream, compress3.length, 4);
                byteArrayOutputStream.write(compress3);
                return true;
            }
            byte[] bArr7 = V001_N;
            if (!Arrays.equals(bArr, bArr7)) {
                return false;
            }
            writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            for (DexProfileData dexProfileData5 : dexProfileDataArr) {
                String str = dexProfileData5.apkName;
                TreeMap treeMap = dexProfileData5.methods;
                String generateDexKey3 = generateDexKey(bArr7, str, dexProfileData5.dexName);
                Charset charset3 = StandardCharsets.UTF_8;
                writeUInt16(byteArrayOutputStream, generateDexKey3.getBytes(charset3).length);
                writeUInt16(byteArrayOutputStream, treeMap.size());
                writeUInt16(byteArrayOutputStream, dexProfileData5.classes.length);
                writeUInt(byteArrayOutputStream, dexProfileData5.dexChecksum, 4);
                byteArrayOutputStream.write(generateDexKey3.getBytes(charset3));
                for (Integer num2 : treeMap.keySet()) {
                    writeUInt16(byteArrayOutputStream, num2.intValue());
                }
                for (int i15 : dexProfileData5.classes) {
                    writeUInt16(byteArrayOutputStream, i15);
                }
            }
            return true;
        }
    }

    public static void writeLineData(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) {
        writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData);
        int i = dexProfileData.numMethodIds;
        int[] iArr = dexProfileData.classes;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            writeUInt16(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        byte[] bArr = new byte[(((i * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                int i5 = intValue / 8;
                bArr[i5] = (byte) (bArr[i5] | (1 << (intValue % 8)));
            }
            if ((intValue2 & 4) != 0) {
                int i6 = intValue + i;
                int i7 = i6 / 8;
                bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeLineHeader(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData, String str) {
        Charset charset = StandardCharsets.UTF_8;
        writeUInt16(byteArrayOutputStream, str.getBytes(charset).length);
        writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
        writeUInt(byteArrayOutputStream, dexProfileData.hotMethodRegionSize, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.numMethodIds, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void writeMethodBitmapForS(ByteArrayOutputStream byteArrayOutputStream, int i, DexProfileData dexProfileData) {
        int i2 = dexProfileData.numMethodIds;
        byte[] bArr = new byte[(((Integer.bitCount(i & (-2)) * i2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i3 = 0;
            for (int i4 = 1; i4 <= 4; i4 <<= 1) {
                if (!(i4 == 1 || (i4 & i) == 0)) {
                    if ((i4 & intValue2) == i4) {
                        int i5 = (i3 * i2) + intValue;
                        int i6 = i5 / 8;
                        bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
                    }
                    i3++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeMethodsWithInlineCaches(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) {
        int i = 0;
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                writeUInt16(byteArrayOutputStream, intValue - i);
                writeUInt16(byteArrayOutputStream, 0);
                i = intValue;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void writeProfile(android.content.Context r18, java.util.concurrent.Executor r19, androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.Encoding.writeProfile(android.content.Context, java.util.concurrent.Executor, androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback, boolean):void");
    }

    public static void writeUInt(ByteArrayOutputStream byteArrayOutputStream, long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeUInt16(ByteArrayOutputStream byteArrayOutputStream, int i) {
        writeUInt(byteArrayOutputStream, i, 2);
    }
}
