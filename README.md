# Compose Multiplatform Template

A Kotlin Multiplatform project targeting **Android** and **iOS**, built with **MVI architecture** and modern KMP libraries.

## Architecture

This project follows the **Model-View-Intent (MVI)** pattern with three base class variants, allowing each screen to pick the right level of complexity:

| Variant | Location | Best For |
|---------|----------|----------|
| **Pure MVI** | `core.mvi.BaseViewModelSimple` | Simple screens (counters, forms, detail views) |
| **MVI with Reducer** | `core.mvi.BaseViewModelReducer` | Medium complexity (search, filters, validated forms) |
| **MVI with State Machine** | `core.mvi.BaseViewModelStateMachine` | Multi-step workflows (checkout, onboarding, auth) |

Reference: [Pure MVI, MVI with Reducer, and MVI with State Machine](https://proandroiddev.com/pure-mvi-mvi-with-reducer-and-mvi-with-state-machine-43a0ec4b629f)

## Tech Stack

| Library | Purpose |
|---------|---------|
| [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/) | Shared UI |
| [Ktor](https://ktor.io/) | HTTP networking |
| [SQLDelight](https://cashapp.github.io/sqldelight/) | Database |
| [Datastore](https://developer.android.com/kotlin/multiplatform/datastore) | Key-value preferences |
| [Koin](https://insert-koin.io/) | Dependency injection |
| [Navigation Compose](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html) | Navigation |
| [kotlinx-serialization](https://github.com/Kotlin/kotlinx.serialization) | JSON parsing |

## Project Structure

```
composeApp/src/commonMain/kotlin/org/adonis/project/
├── core/
│   ├── mvi/                  # MVI base classes
│   │   ├── BaseViewModelSimple.kt
│   │   ├── BaseViewModelReducer.kt
│   │   └── BaseViewModelStateMachine.kt
│   ├── network/              # Ktor HttpClient setup
│   ├── database/             # SQLDelight driver (expect/actual)
│   └── datastore/            # Datastore setup (expect/actual)
├── di/                       # Koin modules
├── domain/                   # Models, repository interfaces, use cases
└── ui/                       # Screens, theme, navigation
    └── theme/                # Material3 theme
```

## Getting Started

### Prerequisites

- Android Studio or IntelliJ IDEA with KMP plugin
- Xcode (for iOS)
- JDK 21 (required for AGP compatibility — use the JDK bundled with Android Studio / IntelliJ IDEA)

### Build and Run Android

```shell
./gradlew :composeApp:assembleDebug
```

Or use the run configuration in your IDE.

### Build and Run iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and run, or use the iOS run configuration in your IDE.

## Adding a New Feature

1. Create a package under `ui/` for your screen
2. Define your `State`, `Intent`, and optionally `Effect` sealed classes
3. Extend the appropriate `BaseViewModel` variant
4. Create your Composable screen observing the ViewModel state
5. Register your ViewModel in a Koin module under `di/`

## Learn More

- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/)
- [MVI Architecture Guide](https://proandroiddev.com/pure-mvi-mvi-with-reducer-and-mvi-with-state-machine-43a0ec4b629f)
