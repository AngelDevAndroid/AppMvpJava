plugins {
    alias(libs.plugins.android.application)
    kotlin("kapt") version "2.1.20"
    id ("realm-android")
}

android {
    namespace = "com.angandroid.appmvprxjava"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.angandroid.appmvprxjava"
        minSdk = 23
        targetSdk = 35
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    // RxJava
    implementation ("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")

    // Dagger

    implementation ("com.google.dagger:dagger-android:2.40.5")
    implementation ("com.google.dagger:dagger-android-support:2.40.5")
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.40.5")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.40.5")

}
