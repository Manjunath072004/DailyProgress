plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")                     // For Hilt annotation processing
    id("com.google.dagger.hilt.android")  // Hilt for Dependency Injection
}

android {
    namespace = "com.example.viewproject"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.viewproject"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {

    // ---------- AndroidX & Compose ----------
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)

    // ---------- Networking (Retrofit + OkHttp) ----------
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14")

    // ---------- Dependency Injection (Hilt) ----------
    implementation("com.google.dagger:hilt-android:2.52")
    implementation(libs.androidx.room.ktx)
    kapt("com.google.dagger:hilt-compiler:2.52")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // ---------- Kotlin Coroutines ----------
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    // ---------- Lifecycle + ViewModel ----------
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")

    // ---------- Glide (for image loading) ----------
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // ---------- Testing ----------
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}


//
//plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kotlin.compose)
//    id("org.jetbrains.kotlin.kapt")                  // Correct kapt plugin for annotation processing
//    id("com.google.dagger.hilt.android")             // Hilt plugin for dependency injection
//}
//
//android {
//    namespace = "com.example.viewproject"
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.example.viewproject"
//        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//
//    buildFeatures {
//        compose = true
//    }
//
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.3"
//    }
//}
//
//dependencies {
//
//    // ---------- AndroidX & Compose ----------
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.compose.ui)
//    implementation(libs.androidx.compose.ui.graphics)
//    implementation(libs.androidx.compose.ui.tooling.preview)
//    implementation(libs.androidx.compose.material3)
//    implementation(libs.androidx.navigation.runtime.ktx)
//    implementation(libs.androidx.navigation.compose)
//
//    // ---------- Networking (Retrofit + OkHttp) ----------
//    implementation("com.squareup.retrofit2:retrofit:2.11.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
//    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")
//    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14")
//
//    // ---------- Dependency Injection (Hilt) ----------
//    implementation("com.google.dagger:hilt-android:2.52")
//    kapt("com.google.dagger:hilt-compiler:2.52")
//    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
//
//    // ---------- Kotlin Coroutines ----------
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
//
//    // ---------- Lifecycle + ViewModel ----------
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")
//
//    // ---------- Glide (optional for images) ----------
//    implementation("com.github.bumptech.glide:glide:4.16.0")
//    kapt("com.github.bumptech.glide:compiler:4.16.0")
//
//    // ---------- Testing ----------
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
//    debugImplementation(libs.androidx.compose.ui.tooling)
//    debugImplementation(libs.androidx.compose.ui.test.manifest)
//}
