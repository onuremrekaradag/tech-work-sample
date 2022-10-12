plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //region Dagger Hilt
    implementation(Dependencies.daggerHilt)
    implementation(Dependencies.daggerHiltCompiler)
    //endregion

    //region Room
    implementation(Dependencies.roomRuntime)
    annotationProcessor(Dependencies.roomCompilerAP)
    //endregion

    //Region modules
    implementation(project(":core-model"))
    //endregion

}