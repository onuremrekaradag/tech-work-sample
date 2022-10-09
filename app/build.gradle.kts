plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")

}

android {
    compileSdk = Configuration.compileSdk


    defaultConfig {
        applicationId = "com.kefelon.themovieapp"
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kotlin {
        sourceSets.configureEach {
            kotlin.srcDir("$buildDir/generated/ksp/$name/kotlin/")
        }
    }

    buildFeatures {
        dataBinding = true
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

    packagingOptions {

            exclude( "META-INF/gradle/incremental.annotation.processors")

    }


}

dependencies {
    implementation(Dependencies.androidCore)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.googleMaterial)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.lifecycle)

    implementation(Dependencies.activity)

    //region Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConvertor)
    //endregion

    //region Glide
    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glideCompiler)
    //endregion

    //region Dagger Hilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
    //endregion

    //region Multidex
    implementation(Dependencies.multidex)
    //endregion

    //region Timber
    implementation(Dependencies.timber)
    //endregion

    testImplementation(Dependencies.junit)

    //region Modules
    implementation(project(":core-data"))
    //endregion
}