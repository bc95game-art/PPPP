# PCAPdroid — Decompiled Source Code

سورس کد کامل اپلیکیشن **PCAPdroid** که از فایل APK با ابزارهای تخصصی استخراج شده است.

---

## اطلاعات اپلیکیشن

| فیلد | مقدار |
|------|-------|
| **Package** | `com.emanuelef.remote_capture` |
| **نام** | PCAPdroid |
| **VersionName** | 1.9.1 |
| **VersionCode** | 91 |
| **minSdkVersion** | 21 (Android 5.0) |
| **targetSdkVersion** | 35 (Android 15) |
| **compileSdkVersion** | 35 |

---

## ساختار پروژه

```
PCAPdroid/
├── app/
│   └── src/main/
│       ├── java/                        ← سورس Java (decompile شده با jadx)
│       │   └── com/emanuelef/remote_capture/
│       │       ├── activities/          ← Activity های اصلی
│       │       ├── adapters/            ← RecyclerView Adapters
│       │       ├── fragments/           ← Fragments
│       │       ├── model/               ← مدل‌های داده
│       │       ├── views/               ← View های سفارشی
│       │       ├── interfaces/          ← Interface ها
│       │       └── pcap_dump/           ← منطق ذخیره PCAP
│       ├── smali/                       ← کد Smali (دقیق‌ترین نمایش bytecode - classes.dex)
│       ├── smali_classes2/              ← کد Smali (classes2.dex)
│       ├── res/                         ← منابع (layout, drawable, string, style, ...)
│       ├── assets/                      ← فایل‌های asset
│       └── AndroidManifest.xml          ← مانیفست کامل
├── build.gradle                         ← تنظیمات build (jadx export)
├── settings.gradle
└── apktool.yml                          ← متادیتا apktool
```

---

## لایه‌های استخراج

### ۱. Java Source (`app/src/main/java/`) — jadx 1.3.5
- **۲۱۶۸ فایل Java** decompile شده با jadx نسخه 1.3.5
- شامل کد اصلی اپ (`com.emanuelef.remote_capture`) + کتابخانه‌های bundled
- گزینه‌های استفاده شده: `--deobf --show-bad-code --export-gradle`
- دقت: بسیار بالا — منطق برنامه کاملاً قابل مطالعه است

### ۲. Smali (`app/src/main/smali/` و `smali_classes2/`) — apktool 2.6.1
- **۲۶۹۶ + ۵۴۱ فایل Smali** (مجموع: ۳۲۳۷ فایل)
- **دقیق‌ترین نمایش**: disassembly مستقیم DEX bytecode (۱:۱)
- قابل استفاده برای بازسازی دقیق یا تحلیل bytecode
- منبع: `classes.dex` و `classes2.dex`

### ۳. Resources (`app/src/main/res/`) — apktool 2.6.1
- **۹۶۳ فایل منبع** شامل:
  - Layout های XML (همه صفحات و dialog ها)
  - String های ترجمه‌شده
  - Drawable ها و آیکون‌ها
  - Style ها و Theme ها
  - Navigation graph
  - Preference XML ها

---

## کتابخانه‌های شناسایی‌شده

| کتابخانه | کاربرد |
|----------|---------|
| Google Billing | خرید درون‌برنامه‌ای |
| Firebase (Encoders, Transport) | تحلیل و گزارش |
| AndroidX (Activity, Fragment, Navigation, Lifecycle, ...) | UI Framework |
| Material Design 3 | رابط کاربری |
| CustomActivityOnCrash | مدیریت خطا |
| Kotlin Coroutines | برنامه‌نویسی async |

---

## ابزارهای استفاده شده

| ابزار | نسخه | کاربرد |
|-------|------|---------|
| [jadx](https://github.com/skylot/jadx) | 1.3.5 | DEX → Java decompiler |
| [apktool](https://apktool.org/) | 2.6.1 | Resource decoder + Smali disassembler |

---

## نکات مهم

- کد Java decompile شده ممکن است در برخی بخش‌های پیچیده کاملاً با کد اصلی یکسان نباشد
- کد **Smali** دقیق‌ترین نمایش برنامه است و هیچ اطلاعاتی از دست نرفته
- APK اصلی از این مخزن حذف شده است
