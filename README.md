# PCAPdroid v1.9.1 — Decompiled & Rebuild-Ready

سورس کد کامل اپلیکیشن **PCAPdroid** که از فایل APK استخراج شده و آماده rebuild است.

---

## ⚡ Build خودکار (GitHub Actions)

هر بار که به `main` push شود، **GitHub Actions** بصورت خودکار APK می‌سازد:

[![Build APK](https://github.com/bc95game-art/PPPP/actions/workflows/build.yml/badge.svg)](https://github.com/bc95game-art/PPPP/actions/workflows/build.yml)

برای دانلود APK ساخته‌شده:
1. به تب **Actions** در GitHub بروید
2. آخرین run را انتخاب کنید
3. از بخش **Artifacts** فایل `PCAPdroid-APK` را دانلود کنید

یا از تب **Releases** فایل APK را مستقیم دانلود کنید.

---

## اطلاعات اپلیکیشن

| فیلد | مقدار |
|------|-------|
| **Package** | `com.emanuelef.remote_capture` |
| **نام** | PCAPdroid |
| **VersionName** | 1.9.1 |
| **VersionCode** | 91 |
| **minSdkVersion** | 21 (Android 5.0+) |
| **targetSdkVersion** | 35 (Android 15) |

---

## ساختار پروژه

```
PPPP/
├── .github/workflows/build.yml  ← GitHub Actions (build خودکار APK)
│
├── smali/                       ← Smali bytecode (classes.dex) — 2696 فایل
├── smali_classes2/              ← Smali bytecode (classes2.dex) — 541 فایل
├── res/                         ← منابع (layout, drawable, string, ...)
├── assets/                      ← فایل‌های asset
├── AndroidManifest.xml          ← مانیفست کامل
├── apktool.yml                  ← تنظیمات apktool
│
└── java_source/                 ← سورس Java (مرجع، decompile شده)
    └── com/emanuelef/remote_capture/
        ├── activities/
        ├── adapters/
        ├── fragments/
        ├── model/
        ├── views/
        ├── interfaces/
        └── pcap_dump/
```

---

## روش Build

### روش ۱: GitHub Actions (توصیه‌شده)
به‌طور خودکار با هر push اجرا می‌شود. نتیجه در تب **Actions** و **Releases** قابل دانلود است.

### روش ۲: Build دستی (محلی)

```bash
# نصب apktool
# https://apktool.org/docs/install/

# Clone مخزن
git clone https://github.com/bc95game-art/PPPP.git
cd PPPP

# Build APK از smali
apktool b . -o PCAPdroid-rebuilt.apk --use-aapt2

# امضا با debug keystore
keytool -genkey -v -keystore debug.keystore -alias androiddebugkey \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -storepass android -keypass android \
  -dname "CN=Android Debug,O=Android,C=US"

zipalign -v 4 PCAPdroid-rebuilt.apk PCAPdroid-aligned.apk

apksigner sign --ks debug.keystore --ks-key-alias androiddebugkey \
  --ks-pass pass:android --key-pass pass:android \
  --out PCAPdroid-signed.apk PCAPdroid-aligned.apk
```

---

## لایه‌های سورس

| لایه | تعداد | دقت | کاربرد |
|------|-------|-----|---------|
| **Smali** | ۳۲۳۷ فایل | ۱۰۰٪ (bytecode مستقیم) | **rebuild APK** |
| **Java** | ۲۱۶۸ فایل | ~۹۵٪ | مطالعه و تحلیل کد |
| **Resources** | ۹۶۳ فایل | ۱۰۰٪ | UI و strings |

---

## ابزارهای استخراج

| ابزار | نسخه | کاربرد |
|-------|------|---------|
| [jadx](https://github.com/skylot/jadx) | 1.3.5 | DEX → Java |
| [apktool](https://apktool.org/) | 2.6.1 | DEX → Smali + Resources |
