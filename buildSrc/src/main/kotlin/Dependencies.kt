object Dependencies {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val googleMaterial by lazy { "com.google.android.material:material:${Versions.googleMaterial}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }

    val lifecycle by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecycleExtensions by lazy { "androidx.lifecycle:lifecycle-extensions::${Versions.lifecycle}" }

    val activity by lazy { "androidx.activity:activity-ktx:${Versions.activity}" }


    //region Retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gsonConvertor by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    //endregion

    //region Glide
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val glideCompiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glide}" }
    //endregion

    //region Hilt
    val daggerHilt by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val daggerHiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}" }
    //endregion

    //region Multidex
    val multidex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }
    //endregion

    //region OkHttp
    val okhttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}" }
    val okhttpMockWebServer by lazy { "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}" }
    //endregion

    //region Timber
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    //endregion

    //region Coroutines
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    //endregion

}