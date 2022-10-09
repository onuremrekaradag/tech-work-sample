plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {

            buildConfigField("boolean", "IS_DEVELOPMENT", "true")
            buildConfigField("String", "API_BASE_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "TMDB_API_KEY", "\"e8331e1f8118359528424addd9eb4e73\"")


        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("boolean", "IS_DEVELOPMENT", "false")
            buildConfigField("String", "API_BASE_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "TMDB_API_KEY", "e8331e1f8118359528424addd9eb4e73")


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
    //region Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConvertor)
    //endregion

    //region Dagger Hilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
    //endregion

    //region OkHttp
    implementation(Dependencies.okhttpLoggingInterceptor)
    testImplementation(Dependencies.okhttpMockWebServer)
    //endregion

    //region Timber
    implementation(Dependencies.timber)
    //endregion

    //Region modules
    implementation(project(":core-model"))
    //endregion

}