# Prerequisites — SVT Automation (Test Automation)

This document lists everything you need to install and configure before you can build and run the **air-svt-automation** test automation suite and its dependency **svt-core-framework**.

---

## Table of Contents

1. [Java (JDK)](#1-java-jdk)
2. [Apache Maven](#2-apache-maven)
3. [Appium Server](#3-appium-server)
4. [Android SDK / Platform Tools](#4-android-sdk--platform-tools)
5. [Xcode & iOS Tooling (macOS only)](#5-xcode--ios-tooling-macos-only)
6. [Node.js & npm](#6-nodejs--npm)
7. [MQTT Broker & CLI Tools](#7-mqtt-broker--cli-tools)
8. [gRPC Server (Thermostat Simulator)](#8-grpc-server-thermostat-simulator)
9. [Tesseract OCR](#9-tesseract-ocr)
10. [MySQL Database](#10-mysql-database)
11. [Serial Port Drivers](#11-serial-port-drivers)
12. [Web Browsers & Drivers](#12-web-browsers--drivers)
13. [IDE](#13-ide)
14. [Maven Settings & Artifactory Access](#14-maven-settings--artifactory-access)
15. [Build & Install the Core Framework](#15-build--install-the-core-framework)
16. [Configuration Files to Update](#16-configuration-files-to-update)
17. [Device Cloud Provider Accounts (Optional)](#17-device-cloud-provider-accounts-optional)
18. [Google Gmail API Credentials](#18-google-gmail-api-credentials)
19. [JIRA / XRay Credentials](#19-jira--xray-credentials)
20. [Network & Connectivity Requirements](#20-network--connectivity-requirements)
21. [Quick-Start Checklist](#21-quick-start-checklist)

---

## 1. Java (JDK)

| Item | Requirement |
|------|-------------|
| **JDK Version** | **25** (Early-Access / Preview) |
| **Distribution** | Oracle JDK, Eclipse Temurin (Adoptium), or any OpenJDK 25 build |
| **JAVA_HOME** | Must be set and pointing to the JDK 25 installation |
| **PATH** | `$JAVA_HOME/bin` must be on your `PATH` |

Both `pom.xml` files set `<maven.compiler.source>25</maven.compiler.source>` / `<maven.compiler.target>25</maven.compiler.target>`.

### macOS (Homebrew)

```bash
brew install --cask oracle-jdk       # Or install EA build manually
# Verify
java -version    # Should show 25.x
javac -version
```

### Manual install

Download from <https://jdk.java.net/25/> and set:

```bash
export JAVA_HOME=/path/to/jdk-25
export PATH="$JAVA_HOME/bin:$PATH"
```

---

## 2. Apache Maven

| Item | Requirement |
|------|-------------|
| **Version** | **3.9.x** or later (must support Java 25) |
| **M2_HOME / PATH** | Maven `bin` directory on `PATH` |

### macOS (Homebrew)

```bash
brew install maven
mvn -version   # Verify Maven & Java version
```

---

## 3. Appium Server

The framework uses **Appium 2.x** (Appium Java Client **9.4.0** in core-framework).

| Item | Requirement |
|------|-------------|
| **Appium Server** | **2.x** (installed via npm) |
| **Default URL** | `http://127.0.0.1:4723` |

### Install

```bash
npm install -g appium@latest

# Install drivers
appium driver install uiautomator2    # Android
appium driver install xcuitest        # iOS

# Verify
appium -v
```

### Appium Inspector (Optional)

Download from <https://github.com/appium/appium-inspector/releases> for GUI element inspection.

---

## 4. Android SDK / Platform Tools

Required for Android device testing.

| Item | Requirement |
|------|-------------|
| **Android SDK** | Latest stable via Android Studio or command-line tools |
| **Platform Tools** | `adb` must be on `PATH` |
| **ANDROID_HOME** | Must be set |
| **Target APIs** | API 31+ (Android 12 is the primary test target) |

### Install

```bash
# Via Homebrew (command-line tools only)
brew install --cask android-commandlinetools

# Or install Android Studio from https://developer.android.com/studio

# Set environment variables
export ANDROID_HOME="$HOME/Library/Android/sdk"
export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

# Verify
adb version
adb devices   # Should list connected devices
```

### Device Setup

- Enable **Developer Options** and **USB Debugging** on the Android device.
- Confirm the device appears in `adb devices`.

---

## 5. Xcode & iOS Tooling (macOS only)

Required for iOS real-device and simulator testing.

| Item | Requirement |
|------|-------------|
| **Xcode** | Latest stable from Mac App Store (must support iOS 15.5 – 18.5) |
| **Xcode Command Line Tools** | `xcode-select --install` |
| **WebDriverAgent (WDA)** | Built automatically by Appium `xcuitest` driver |
| **Apple Developer Account** | Required to sign WDA for real-device testing |
| **ios-deploy** | For deploying apps to real devices |
| **libimobiledevice** | For iOS device communication |

### Install

```bash
xcode-select --install
brew install libimobiledevice ios-deploy ideviceinstaller

# Verify
xcodebuild -version
xcrun simctl list devices   # List available simulators
```

> **Note:** WDA Bundle ID used by the project is `com.resideo.ios`. You may need to update signing settings in Xcode.

---

## 6. Node.js & npm

Required for Appium installation.

| Item | Requirement |
|------|-------------|
| **Node.js** | **18.x LTS** or later |
| **npm** | Comes bundled with Node.js |

### Install

```bash
brew install node
node -v
npm -v
```

---

## 7. MQTT Broker & CLI Tools

The project communicates with thermostats over MQTT.

| Item | Requirement |
|------|-------------|
| **Mosquitto Broker** | Running at `tcp://192.168.135.64:1883` (or configure your own) |
| **mosquitto_sub** | CLI tool used by `MqttSubscribeManager.sh` |
| **Eclipse Paho MQTTv5** | Included as Maven dependency (v1.2.5) — no separate install needed |

### Install Mosquitto CLI tools (for local debugging)

```bash
brew install mosquitto

# Verify
mosquitto_sub --help
```

> **Note:** The MQTT broker address is configured in `src/test/resources/Properties/ProjectSpecific.properties` under the key `MQTT_BROKER_URL`. Update it to match your environment.

---

## 8. gRPC Server (Thermostat Simulator)

The framework communicates with a gRPC stat-commander service.

| Item | Requirement |
|------|-------------|
| **gRPC Server** | Running at `localhost:50051` (configurable) |
| **Protocol Buffers** | v4.29.3 (included as Maven dependency) |

The gRPC client libraries (v1.75.0) are pulled automatically by Maven. You need to ensure the **stat-commander gRPC server** is running and accessible.

Configuration keys in `ProjectSpecific.properties`:
- `GRPC_SERVER_IP_ADDRESS`
- `GRPC_SERVER_PORT`

---

## 9. Tesseract OCR

Used for on-screen text recognition (reading thermostat displays).

| Item | Requirement |
|------|-------------|
| **Tesseract** | v4.x or v5.x |
| **Tess4J** | 5.13.0 (core-framework Maven dependency) |
| **tessdata** | English language data files |

### Install

```bash
brew install tesseract

# Verify
tesseract --version
```

Tess4J looks for Tesseract native libraries on the system `PATH` or via `TESSDATA_PREFIX` environment variable.

---

## 10. MySQL Database

The core-framework includes a MySQL connector (v9.1.0) for result storage and performance data.

| Item | Requirement |
|------|-------------|
| **MySQL Server** | 8.x or 9.x |
| **Connector** | Included as Maven dependency |

Server addresses are configured in:
- `combined_core_framework/src/main/resources/ServersAddress/performancedb.properties`

> **Note:** Only required if your test execution involves database-backed result reporting.

---

## 11. Serial Port Drivers

The project controls hardware (thermostats, Arduino relays) over serial COM ports.

| Item | Requirement |
|------|-------------|
| **jSerialComm** | 2.11.2 (Maven dependency — no extra install) |
| **jssc** | 2.8.0 (Maven dependency) |
| **RXTX** | 1.1.0 (Maven dependency) |
| **USB/Serial drivers** | Install FTDI or CH340 drivers if using USB-to-serial adapters |

For macOS:
```bash
# Check connected serial devices
ls /dev/tty.*
ls /dev/cu.*
```

---

## 12. Web Browsers & Drivers

For web-based testing (e.g., router configuration pages).

| Item | Requirement |
|------|-------------|
| **Google Chrome** | Latest stable |
| **Safari** | Built into macOS |
| **WebDriverManager** | v6.1.0 (Maven dependency — auto-downloads browser drivers) |

WebDriverManager automatically manages ChromeDriver, GeckoDriver, etc. No manual driver download is needed.

---

## 13. IDE

| Item | Recommendation |
|------|----------------|
| **IDE** | IntelliJ IDEA (Community or Ultimate) or VS Code with Java extensions |
| **Plugins** | Cucumber for Java, TestNG, Maven Integration |

### IntelliJ IDEA Setup

1. Open the project as a Maven project.
2. Install the **Cucumber for Java** and **TestNG** plugins.
3. Set Project SDK to JDK 25.
4. Reload Maven dependencies.

---

## 14. Maven Settings & Artifactory Access

The project pulls dependencies from **JFrog Artifactory** at `artifactory.softwaretools.resideo.com`.

### Step 1 — Copy `settings.xml` to Maven home

```bash
# For air-svt-automation
cp settings.xml ~/.m2/settings.xml
```

Or merge the server entries into your existing `~/.m2/settings.xml`.

### Step 2 — Configure Credentials

The `settings.xml` uses placeholders `${jfrog.username}` and `${jfrog.password}`. Set them via:

**Option A:** Command-line properties
```bash
mvn clean install -Djfrog.username=YOUR_USERNAME -Djfrog.password=YOUR_PASSWORD
```

**Option B:** Add to `~/.m2/settings.xml` directly
```xml
<servers>
    <server>
        <id>jfrog-releases</id>
        <username>your-username</username>
        <password>your-encrypted-password</password>
    </server>
    <server>
        <id>jfrog-snapshots</id>
        <username>your-username</username>
        <password>your-encrypted-password</password>
    </server>
    <server>
        <id>jfrog-bfcom-stable</id>
        <username>your-username</username>
        <password>your-encrypted-password</password>
    </server>
    <server>
        <id>jfrog-plugin-snapshots</id>
        <username>your-username</username>
        <password>your-encrypted-password</password>
    </server>
</servers>
```

> Contact your team lead or DevOps for JFrog Artifactory credentials.

---

## 15. Build & Install the Core Framework

The `air-svt-automation` project depends on `svt-core-framework` (v1.0.0). You must build and install it **first**.

```bash
# 1. Build the core-framework and install to local Maven repo
cd svt-core-framework
mvn clean install -DskipTests

# 2. Build the test project
cd ../air-svt-automation
mvn clean compile -DskipTests
```

If the core-framework is already published to JFrog Artifactory, step 1 can be skipped.

---

## 16. Configuration Files to Update

Before running tests, review and update these property files in `air-svt-automation/src/test/resources/Properties/`:

| File | What to Configure |
|------|-------------------|
| `ProjectSpecific.properties` | CHIL/Tabasco/Titan API endpoints, MQTT broker URL, gRPC server address, WiFi credentials, device-under-test |
| `Appium.properties` | Appium server URLs, Android activity names, capabilities, timeouts |
| `MobileApp.properties` | App package names, bundle IDs, app version |
| `AppNameFormat.properties` | Local APK/IPA file paths, cloud-uploaded app references |
| `TestSuite.properties` | Suite name, thread pool size, retry count |
| `XRayConfiguration.properties` | JIRA/XRay client ID, client secret, JIRA token, project key |
| `ResultUpload.properties` | Bitbucket URL, email toggle |
| `Perfecto.properties` | Perfecto cloud APK/IPA names *(if using Perfecto)* |
| `SauceLabs.properties` | SauceLabs APK/IPA references *(if using SauceLabs)* |
| `pCloudy.properties` | pCloudy API endpoint *(if using pCloudy)* |
| `RouterIOPAutomation.properties` | WiFi router details *(if running WiFi IOP tests)* |
| `WebApp.properties` | Browser type, web URLs, credentials *(if running web tests)* |

Also update:
- `Requirement_file.txt` — Set `YES` in the **Include Group** column for the test groups you want to execute.
- `credentials.json` — Google OAuth2 credentials for Gmail OTP verification (if applicable).

---

## 17. Device Cloud Provider Accounts (Optional)

The framework supports multiple device cloud providers. You only need credentials for the one(s) you use:

| Provider | SignUp / Access | Notes |
|----------|----------------|-------|
| **Local (Appium)** | No account needed | Default; requires physical device or emulator connected locally |
| **Perfecto** | <https://www.perfecto.io/> | Requires Perfecto security token |
| **SauceLabs** | <https://saucelabs.com/> | Requires username + access key |
| **pCloudy** | Internal: `https://pcloudy.honeywell.com` | Requires corporate credentials |
| **TestObject** | <https://testobject.com/> | Requires API key |

---

## 18. Google Gmail API Credentials

Used for email verification / OTP retrieval during test flows.

1. Obtain `credentials.json` from the Google Cloud Console (project: `gmailrezi`).
2. Place it at `src/test/resources/credentials.json`.
3. On the first run, a browser window will open for OAuth consent. The resulting token is stored in `tokens/StoredCredential`.

> Contact your team if you need access to the shared Google Cloud project.

---

## 19. JIRA / XRay Credentials

For uploading test results to JIRA XRay:

| Property | Description |
|----------|-------------|
| `CLIENT_ID` | XRay Cloud API client ID |
| `CLIENT_SECRET` | XRay Cloud API client secret |
| `JIRA_TOKEN` | JIRA API token for `https://resideo.atlassian.net` |

Configure in `src/test/resources/Properties/XRayConfiguration.properties`.

---

## 20. Network & Connectivity Requirements

| Requirement | Details |
|-------------|---------|
| **Resideo VPN / Corporate Network** | Required to access JFrog Artifactory, pCloudy, internal CHIL/Tabasco/Titan servers |
| **MQTT Broker** | Access to `tcp://192.168.135.64:1883` (or your configured broker) |
| **gRPC Server** | Access to `localhost:50051` (or your configured server) |
| **Internet** | For Maven Central, cloud device providers, Google APIs |
| **WiFi Network** | A 2.4 GHz WiFi network for thermostat pairing (network name/password configured in test data) |
| **USB** | Physical USB connection for local Android/iOS device testing |

---

## 21. Quick-Start Checklist

Use this checklist to verify your environment is ready:

- [ ] **JDK 25** installed and `JAVA_HOME` set
- [ ] **Maven 3.9+** installed and on `PATH`
- [ ] **Node.js 18+** and **npm** installed
- [ ] **Appium 2.x** installed (`npm install -g appium`)
- [ ] Appium drivers installed (`uiautomator2`, `xcuitest`)
- [ ] **Android SDK** installed and `ANDROID_HOME` set *(for Android testing)*
- [ ] **Xcode** installed with command-line tools *(for iOS testing, macOS only)*
- [ ] **Mosquitto CLI** installed *(if running MQTT tests)*
- [ ] **Tesseract OCR** installed *(if running OCR-based tests)*
- [ ] Maven `settings.xml` configured with JFrog Artifactory credentials
- [ ] `svt-core-framework` built and installed (`mvn clean install -DskipTests`)
- [ ] `air-svt-automation` compiles successfully (`mvn clean compile`)
- [ ] Property files in `src/test/resources/Properties/` updated for your environment
- [ ] `Requirement_file.txt` configured with desired test groups set to `YES`
- [ ] Mobile device connected and detected (`adb devices` / Xcode Devices)
- [ ] Appium server started (`appium`)
- [ ] MQTT broker accessible *(if needed)*
- [ ] gRPC server running *(if needed)*
- [ ] VPN connected *(if accessing internal Resideo services)*

---

## Running Tests

Once all prerequisites are met:

```bash
cd air-svt-automation

# Run via Maven (uses exec-maven-plugin → SuiteExecutor)
mvn clean test

# With custom arguments
mvn clean test -Dexec.args="--requirementfilename=Requirement_file.txt --publishresult=false"
```

The `SuiteExecutor` reads `Requirement_file.txt`, picks up groups marked `YES`, and dispatches tests to the configured platform/device/environment.

---

## Key Dependency Version Summary

| Component | Version |
|-----------|---------|
| Java (JDK) | 25 |
| Maven | 3.9+ |
| Maven Compiler Plugin | 3.14.0 |
| Selenium | 4.27.0 (svt) / 4.28.0 (core) |
| Appium Java Client | 9.4.0 |
| Appium Server | 2.x |
| Cucumber | 7.20.1 |
| TestNG | 7.10.2 |
| gRPC | 1.75.0 |
| Protocol Buffers | 4.29.3 |
| Eclipse Paho MQTTv5 | 1.2.5 |
| Log4j2 | 2.24.3 |
| SLF4J | 2.0.17 |
| Jackson | 2.18.3 |
| REST Assured | 5.5.0 |
| Apache POI | 5.4.0 |
| WebDriverManager | 6.1.0 |
| Tess4J / Tesseract | 5.13.0 / 4.x+ native |
| OpenCV | 4.10.0 |
| MySQL Connector | 9.1.0 |
| Guava | 33.4.0-jre (svt) / 33.5.0-jre (core) |
| OkHttp | 4.12.0 |
| Azure IoT Device Client | 2.0.0 |
| JSch (SSH) | 0.1.55 |
| jSerialComm | 2.11.2 |
| Node.js | 18+ LTS |

---

*Last updated: March 2026*
