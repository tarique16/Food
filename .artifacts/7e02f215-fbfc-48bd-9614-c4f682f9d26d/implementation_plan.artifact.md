# Fix Compose Test Dependency Resolution Issue

The project is failing to resolve `androidx.compose.ui:ui-test-junit4` because the Compose Bill of Materials (BOM) is only applied to the `implementation` configuration. In modern Gradle setups, especially with the 2026.08.00 BOM, the platform constraint must be explicitly added to the `androidTestImplementation` and `debugImplementation` configurations to ensure their respective dependencies (like `ui-test-junit4` and `ui-tooling`) can resolve their versions.

## User Review Required

> [!IMPORTANT]
> This change explicitly applies the Compose BOM to the testing and debug configurations. This is standard practice when using the BOM to manage library versions.

## Proposed Changes

### app module

#### [MODIFY] [build.gradle.kts](file:///Users/tarique/AndroidStudioProjects/Food/app/build.gradle.kts)

Apply the Compose BOM to `androidTestImplementation` and `debugImplementation` configurations.

```diff
 dependencies {
     implementation(platform(libs.androidx.compose.bom))
+    androidTestImplementation(platform(libs.androidx.compose.bom))
+    debugImplementation(platform(libs.androidx.compose.bom))
     implementation(libs.androidx.activity.compose)
```

## Verification Plan

### Automated Tests
- Run Gradle sync to verify the issue is resolved.
- Run `:app:assembleDebugAndroidTest` to ensure the test dependencies are correctly resolved and compiled.

### Manual Verification
- Verify that the "Failed to resolve: androidx.compose.ui:ui-test-junit4" error no longer appears in the Build tool window or Sync tab.
