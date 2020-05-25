# PowerAct

## Introduction

An Android library that can manipulate power-related actions with just few lines of code without root privilege.

(Use `AccessibilityService` and `DevicePolicyManager`)

## Usage

```java
// Lock screen, Without callback.
lockScreenBtn.setOnClickListener(v -> PowerAct.lockScreen(MainActivity.this));
// Show system power dialog, with callback.
powerDialogBtn.setOnClickListener(v -> PowerAct.showPowerDialog(MainActivity.this, callback));
// An additional widget.
PowerButton powerButton = findViewById(R.id.pwrBtn);
```

Create `res/values/poweract_config.xml`

```xml
<resources>
    <!--  In order to configure some UI properties you must rewrite the res of the library.  -->
    <string name="poweract_accessibility_service_label">Power Action Service</string>
    <string name="poweract_accessibility_service_description">The service is used to perform some power action without reaching the actual power button on the side of the phone. It will never collect any user data.</string>
    <string name="poweract_accessibility_service_summary">Virtual power key accessibility service.</string>
    <!--  Optional.  -->
    <bool name="poweract_accessibility_service_show_foreground_notification">true</bool>
</resources>
```

## Compatibility

API level|LockScreen|Show System Dialog
-|-|-
14 ~ 20 |√|×
21 ~ 27 |√|√
28+|√+|√

> √+ `Unlock by fingerprint`