# PCAPdroid - Decompiled Source

این سورس کد از فایل `PCAPdroid.apk` با استفاده از ابزارهای **jadx** و **apktool** استخراج شده است.

## ساختار پروژه

```
app/src/main/
├── java/                    # سورس کد Java (decompile شده با jadx)
│   └── com/emanuelef/remote_capture/   # کد اصلی اپلیکیشن
├── java_thirdparty/         # کتابخانه‌های third-party
├── res/                     # منابع (XML, drawable, layout)
├── assets/                  # فایل‌های asset
└── AndroidManifest.xml      # مانیفست اپلیکیشن
```

## اطلاعات اپلیکیشن

- **Package:** `com.emanuelef.remote_capture`  
- **نام:** PCAPdroid  
- **SDK:** compileSdkVersion 35 (Android 15)

## ابزارهای استفاده شده

- [jadx 1.3.5](https://github.com/skylot/jadx) — decompile DEX به Java
- [apktool 2.6.1](https://apktool.org/) — استخراج resources و Smali

## توجه

کد decompile شده ممکن است با کد اصلی کامل یکسان نباشد ولی منطق و ساختار کلی حفظ شده است.
