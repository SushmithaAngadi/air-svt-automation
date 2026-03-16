# AIR SVT Automation

End-to-end **System Verification Test (SVT)** automation framework for Resideo smart home products. Supports mobile (Android/iOS), web, thermostat GUI, and IoT protocol testing.

---

## Supported Products

| Product Family | Variant | Type |
|----------------|---------|------|
| Gleneagles | Trade | DIY, System |
| Denali | Trade, Retail | DIY, System |

## Tech Stack

| Technology | Version |
|------------|---------|
| Java (JDK) | 25 |
| Maven | 3.9+ |
| Selenium | 4.27.0 |
| Appium | 2.x (Java Client 9.4.0) |
| Cucumber | 7.20.1 |
| TestNG | 7.10.2 |
| gRPC | 1.75.0 |
| MQTT (Eclipse Paho) | 1.2.5 |
| REST Assured | 5.5.0 |
| svt-core-framework | 1.0.1 |

## Project Structure

```
air-svt-automation/
├── pom.xml                          # Maven build config
├── settings.xml                     # JFrog Artifactory settings
├── Requirement_file.txt             # Test group selection (YES/NO)
├── PREREQUISITES.md                 # Full setup guide
├── MqttSubscribeManager.sh          # MQTT subscription helper
└── src/test/
    ├── java/com/resideo/
    │   ├── commons/                 # Core utilities (mobile, web, report)
    │   ├── keywords/                # BDD keyword step implementations
    │   ├── testcases/               # Test executors
    │   └── utils/                   # Product-specific utilities
    │       ├── resideo_app/         # Resideo Pro app utils
    │       ├── firstalert_app/      # First Alert app utils
    │       ├── stat/                # Thermostat GUI & gRPC commands
    │       └── web/                 # Router & web portal utils
    └── resources/
        ├── features/                # 140+ Cucumber feature files
        ├── Properties/              # Environment & test configuration
        ├── MobileAPP/               # APK/IPA files for testing
        ├── objects_definition/      # UI element locators
        └── testdata/                # Test data files
```

## Prerequisites

See [PREREQUISITES.md](PREREQUISITES.md) for the full setup guide. Quick summary:

1. **JDK 25**, **Maven 3.9+**, **Node.js 18+**
2. **Appium 2.x** with `uiautomator2` and `xcuitest` drivers
3. **Android SDK** (`ANDROID_HOME` set) and/or **Xcode** (for iOS)
4. Build the core framework first:
   ```bash
   cd svt-core-framework
   mvn clean install -DskipTests -s settings.xml
   ```

## Build

```bash
cd air-svt-automation
mvn clean install -s settings.xml -Djfrog.username=YOUR_USERNAME -Djfrog.password=YOUR_PASSWORD
```

## Running Tests

1. Edit `Requirement_file.txt` — set `YES` for the test groups to execute
2. Connect your mobile device (`adb devices` to verify)
3. Start Appium server (`appium`)
4. Run:
   ```bash
   mvn clean test -Dexec.args="--requirementfilename=Requirement_file.txt --publishresult=false"
   ```

## Configuration

All config files are in `src/test/resources/Properties/`:

| File | Purpose |
|------|---------|
| `TestSuite.properties` | Suite name, thread pool, retry count |
| `ProjectSpecific.properties` | API endpoints, MQTT broker, WiFi, device config |
| `Appium.properties` | Appium server URL, capabilities, timeouts |
| `MobileApp.properties` | App package names, bundle IDs |
| `XRayConfiguration.properties` | JIRA/XRay integration for test reporting |

## Test Reports

After execution, reports are generated at:
- **TestNG Report:** `test-output/index.html`
- **Execution Logs:** `src/test/resources/Execution_Folder/CurrentResult/`

## Dependencies

This project depends on [svt-core-framework](https://github.com/SushmithaAngadi/svt-core-framework) which provides:
- Mobile/Web driver management
- BDD test execution engine
- Reporting utilities
- Device cloud provider integrations

## Selenium 4 / Appium 2 Migration Notes

| Change | Details |
|--------|--------|
| `getAttribute()` → `getDomAttribute()` | All Selenium element calls updated across 30 files |
| `TouchAction` → W3C Actions API | Uses `W3CTouchActions` from svt-core-framework |
| `appium:` prefixed capabilities | `ExtendedLocalDesiredCapability` uses `appium:` prefix on all Appium caps |
| macOS serial port support | `MqttSerialController` handles macOS port detection and screen session cleanup |
