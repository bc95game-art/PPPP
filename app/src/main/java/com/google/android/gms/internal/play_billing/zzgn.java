package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public abstract class zzgn {
    public static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            zzc(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                zzeg zzegVar = zzeg.zzb;
                sb.append(LazyKt__LazyJVMKt.zza(new zzeg(((String) obj).getBytes(zzfo.zza))));
                sb.append('\"');
            } else if (obj instanceof zzeg) {
                sb.append(": \"");
                sb.append(LazyKt__LazyJVMKt.zza((zzeg) obj));
                sb.append('\"');
            } else if (obj instanceof zzfi) {
                sb.append(" {");
                zzd((zzfi) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                zzb(sb, i3, "key", entry2.getKey());
                zzb(sb, i3, "value", entry2.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    public static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    public static void zzd(zzfi zzfiVar, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzfiVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null) {
                if (method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, substring.substring(0, substring.length() - 4), zzfi.zzs(method2, zzfiVar, new Object[0]));
                    i2 = 3;
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, substring.substring(0, substring.length() - 3), zzfi.zzs(method, zzfiVar, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzs = zzfi.zzs(method4, zzfiVar, new Object[0]);
                    if (method5 != null) {
                        if (!((Boolean) zzfi.zzs(method5, zzfiVar, new Object[0])).booleanValue()) {
                        }
                        zzb(sb, i, substring, zzs);
                    } else if (zzs instanceof Boolean) {
                        if (!((Boolean) zzs).booleanValue()) {
                        }
                        zzb(sb, i, substring, zzs);
                    } else if (zzs instanceof Integer) {
                        if (((Integer) zzs).intValue() == 0) {
                        }
                        zzb(sb, i, substring, zzs);
                    } else if (zzs instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) zzs).floatValue()) == 0) {
                        }
                        zzb(sb, i, substring, zzs);
                    } else if (zzs instanceof Double) {
                        if (Double.doubleToRawLongBits(((Double) zzs).doubleValue()) == 0) {
                        }
                        zzb(sb, i, substring, zzs);
                    } else {
                        if (zzs instanceof String) {
                            z = zzs.equals("");
                        } else if (zzs instanceof zzeg) {
                            z = zzs.equals(zzeg.zzb);
                        } else if (zzs instanceof zzds) {
                            if (zzs == ((zzfi) ((zzfi) ((zzds) zzs)).zzb(6))) {
                            }
                            zzb(sb, i, substring, zzs);
                        } else {
                            if ((zzs instanceof Enum) && ((Enum) zzs).ordinal() == 0) {
                            }
                            zzb(sb, i, substring, zzs);
                        }
                        if (z) {
                        }
                        zzb(sb, i, substring, zzs);
                    }
                }
            }
            i2 = 3;
        }
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar != null) {
            for (int i4 = 0; i4 < zzhiVar.zzb; i4++) {
                zzb(sb, i, String.valueOf(zzhiVar.zzc[i4] >>> 3), zzhiVar.zzd[i4]);
            }
        }
    }
}
