# نور قرآن | Nur Quran 📖

**Offline Quran App — القرآن الكريم دون نت**

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://www.android.com/)
[![Capacitor](https://img.shields.io/badge/Capacitor-Android-119EFF?logo=capacitor&logoColor=white)](https://capacitorjs.com/)
[![License](https://img.shields.io/badge/License-CC--BY--SA%204.0-blue)](https://creativecommons.org/licenses/by-sa/4.0/)

**Nur Quran** is a simple, fast, and offline Quran reading application. It is designed to make reading the Holy Quran accessible anytime and anywhere, without requiring an internet connection.

**نور قرآن** هو تطبيق بسيط وسريع لقراءة القرآن الكريم في أي وقت وأي مكان، دون الحاجة إلى الاتصال بالإنترنت.

---

## 📱 Download

<a href="https://play.google.com/store/apps/details?id=com.eddahby.quran">
  <img src="https://upload.wikimedia.org/wikipedia/commons/7/78/Google_Play_Store_badge_EN.svg" alt="Get it on Google Play" width="200" />
</a>

**[Download Nur Quran on Google Play](https://play.google.com/store/apps/details?id=com.eddahby.quran)**

---

## ✨ Features | المميزات

- 📖 **Offline Quran reading** — Read the Quran without an internet connection.
- 🔎 **Fast search** — Search by Surah name, Surah number, or Arabic text.
- 📚 **Surah navigation** — Quickly browse and open Surahs.
- 🔖 **Reading progress** — Easily return to your reading.
- 🌙 **Dark mode** — A comfortable interface for low-light reading.
- ⚡ **Fast startup** — Lightweight and responsive navigation.
- 📱 **Clean interface** — Focused on a simple and comfortable reading experience.
- 🕌 **Lightweight** — Built to provide a smooth Quran-reading experience without unnecessary complexity.

### 🆕 What's New

Recent improvements include:

- Faster and more accurate search for Surahs and verses.
- Faster startup and smoother navigation.
- A cleaner and more comfortable reading interface.
- Improved dark-mode contrast for night reading.
- General stability, performance, and accuracy improvements.

---

## 🧱 Technology

The Android application is built around a **Capacitor** Android project and integrates the Quran reading experience into a native Android application.

- **Web layer:** React
- **Native runtime:** Capacitor
- **Platform:** Android
- **Build system:** Gradle
- **Language in native Android layer:** Java

The repository contains the Android project, including the Gradle wrapper, Android application module, Capacitor configuration, and native Android build configuration.

---

## 📂 Project Structure

```text
nurquranapp/
├── app/                       # Android application module
├── gradle/                    # Gradle wrapper configuration
├── .gitignore
├── build.gradle              # Root Gradle configuration
├── capacitor.settings.gradle # Capacitor Android integration
├── gradle.properties
├── gradlew                    # Gradle wrapper (Unix/macOS/Linux)
├── gradlew.bat                # Gradle wrapper (Windows)
├── settings.gradle
├── variables.gradle
├── LICENSE.txt
└── README.md
```

> The repository is the Android side of the application. Capacitor-generated files should generally be regenerated from the parent web project when the underlying Capacitor configuration changes.

---

## 🛠️ Development

### Requirements

For Android development, you will typically need:

- [Android Studio](https://developer.android.com/studio)
- Android SDK configured through Android Studio
- A compatible JDK
- An Android emulator or physical Android device for testing
- The required Capacitor/web project dependencies when regenerating or synchronizing the Android platform

### Clone

```bash
git clone https://github.com/younesseddahby/nurquranapp.git
cd nurquranapp
```

### Open in Android Studio

1. Open the repository in Android Studio.
2. Allow Gradle to sync the project.
3. Make sure the required Android SDK is installed.
4. Connect an Android device or start an emulator.
5. Select the `app` configuration and run the application.

### Build a debug APK

On Linux/macOS:

```bash
./gradlew assembleDebug
```

On Windows:

```powershell
.\gradlew.bat assembleDebug
```

The debug APK is generated under:

```text
app/build/outputs/apk/debug/
```

### Run tests

Unit tests:

```bash
./gradlew test
```

Android instrumentation tests:

```bash
./gradlew connectedAndroidTest
```

The instrumentation command requires a connected Android device or running emulator.

---

## 🔄 Capacitor Workflow

If the Android project is generated or synchronized from a Capacitor web application, make changes to the web application and Capacitor configuration in the parent project first, then synchronize the Android platform.

Typical Capacitor workflow:

```bash
npm install
npx cap sync android
npx cap open android
```

> Run these commands from the parent web project that contains the JavaScript/React application and `node_modules`. They are not intended to be run from this Android-only repository unless the corresponding web project is present there.

Avoid manually modifying generated Capacitor files when the same configuration can be changed in the source web project and regenerated.

---

## 📖 Quran Data Sources & Attribution

The Quran content and supporting data used by Nur Quran come from the following sources. Their attribution is intentionally preserved here.

### English Translation — `en-json`

- **Source:** [risan/quran-json](https://github.com/risan/quran-json)
- **License:** [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/)

### Warsh & Hafs Arabic Text — `warsh-json` / `hafs-json`

- **Source:** [thetruetruth/quran-data-kfgqpc](https://github.com/thetruetruth/quran-data-kfgqpc)
- **Origin:** King Fahd Glorious Quran Printing Complex (KFGQPC)
- **Permission:** Used with explicit permission from KFGQPC ("You may use this data by downloading from Github").

### Tafsir — `tafsir-json`

- **Source:** [GlobalQuran.com](https://docs.globalquran.com/data)

Please respect the licenses and attribution requirements of each upstream data source when redistributing or modifying the application.

---

## 📄 License

This project's source code is licensed under the **Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)** license, in accordance with the licensing requirements associated with the included `en-json` source.

See the repository's [`LICENSE.txt`](./LICENSE.txt) for the license text.

Full license information: [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/)

> **Important:** The application source code and Quran/translation/tafsir datasets may have different upstream attribution or usage requirements. Always check the individual source licenses listed above.

---

## 🙏 Acknowledgements

Special thanks to:

- **King Fahd Glorious Quran Printing Complex (KFGQPC)** — Quranic text.
- **Risan Bagja Pradana** — `quran-json` project and English translation data.
- **GlobalQuran.com** — Tafsir data.
- The wider open-source community whose tools and projects make this application possible.

---

## 🎯 About Nur Quran

Nur Quran was created with a simple goal: **make reading the Quran easy, fast, and available offline.**

نور قرآن تم تطويره بهدف بسيط: **توفير تجربة سهلة وسريعة ومريحة لقراءة القرآن الكريم دون الحاجة إلى الإنترنت.**

If you find the app useful, consider supporting the project by rating it on Google Play or sharing it with others.

---

## 🔗 Links

- 📱 [Nur Quran on Google Play](https://play.google.com/store/apps/details?id=com.eddahby.quran)
- 💻 [Source Code on GitHub](https://github.com/younesseddahby/nurquranapp)

---

**Made for the global Muslim community. 🤍**
