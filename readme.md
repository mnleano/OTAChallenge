# OTA Challenge

## Demo 

![Demo](./assets/demo.gif)

## Installation

The APK for the application can be found in the `apk` folder of this repository. Here are the steps to install it:

1. Download the APK file to your Android device.
2. Go to your device's settings and allow installing applications from unknown sources.
3. Open the APK file on your device to start the installation process.
4. Follow the prompts to complete the installation.

Please note that the APK provided in the repository might not be the latest version of the application. It is recommended to clone the repository and build the project in Android Studio for the latest version.

## Architecture

This application uses the Model-View-ViewModel (MVVM) architecture. This architecture allows separating the user interface logic from the business logic, making the code more modular and easier to manage and test.

- **Model**: This represents the data and business logic of the application. It's responsible for fetching the data from the network or database and providing the data to the ViewModel.

- **View**: This is the user interface of the application. It observes the ViewModel and updates the UI elements when the data in the ViewModel changes.

- **ViewModel**: It acts as a bridge between the Model and the View. It requests data from the Model, and then provides the data to the View. It also handles the user interactions and updates the data accordingly.

The MVVM architecture ensures that the View does not contain any business logic and the Model does not know anything about the user interface, achieving a clean separation of concerns.

## Acknowledgements

This project uses the following third-party libraries:

- [AndroidX Core KTX](https://developer.android.com/kotlin/ktx) - Provides Kotlin extensions for Android framework APIs.
- [AndroidX AppCompat](https://developer.android.com/jetpack/androidx/releases/appcompat) - Provides backward compatibility for Android UI components.
- [Google Android Material](https://material.io/develop/android/docs/getting-started) - Provides Material Design components for Android.
- [AndroidX ConstraintLayout](https://developer.android.com/training/constraint-layout) - Allows you to create large and complex layouts with a flat view hierarchy.
- [Koin](https://insert-koin.io/) - A pragmatic lightweight dependency injection framework for Kotlin.
- [ObjectBox](https://objectbox.io/) - An easy-to-use, high-performance NoSQL object database for Android.
- [Tencent MMKV](https://github.com/Tencent/MMKV) - An efficient, small mobile key-value storage framework developed by WeChat.
- [Facebook SoLoader](https://github.com/facebook/SoLoader) - A native code loader for Android.
- [Facebook Flipper](https://fbflipper.com/) - A debugging platform for mobile apps.
- [Flipper-Plugin-MMKV Viewer](https://github.com/ddyos/flipper-plugin-mmkv-viewer) - A Flipper plugin for viewing MMKV data.
- [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back.
- [JUnit](https://junit.org/junit4/) - A simple framework to write repeatable tests.
- [Mockito](https://site.mockito.org/) - A mocking framework for unit tests in Java.
- [AndroidX Core Testing](https://developer.android.com/jetpack/androidx/releases/core) - Provides core utility classes for testing.
- [OkHttp MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - A scriptable web server for testing HTTP clients.

Please refer to the respective library's documentation for their usage and license details.