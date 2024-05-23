plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.deneme31"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.deneme31"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled =true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true

        }
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
    buildFeatures {
        compose = true
        buildConfig=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composeVersion = "1.4.2"

    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.activity:activity-compose:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))

    implementation("com.google.firebase:firebase-auth-ktx")

    implementation("com.google.accompanist:accompanist-insets:0.23.1")
}/*
dependencies {
    implementation("com.google.firebase:firebase-auth-ktx")                     bu var
    implementation("com.google.android.material:material:1.12.0")               bunun 1.10 versiyonu var
    val composeVersion = "1.4.2"                                                bu var
    implementation("androidx.multidex:multidex:2.0.1")//+                       -

    implementation("com.google.accompanist:accompanist-insets:0.23.1")          bu var
    implementation("com.google.android.exoplayer:exoplayer-core:2.17.1")        -
    implementation("com.google.android.exoplayer:exoplayer-ui:2.17.1")          -

    implementation("androidx.core:core-ktx:1.10.0")                             bu var
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")            bunun 2.6.1 versiyonu var
    implementation("androidx.activity:activity-compose:$composeVersion")        bu var

    // Compose BOM to manage consistent versions
    implementation(platform("androidx.compose:compose-bom:$composeVersion"))    -
    implementation("androidx.compose.ui:ui:$composeVersion")                    bu var
    implementation("androidx.compose.ui:ui-graphics")//+                        -
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")    bu var
    implementation("androidx.compose.material3:material3:$composeVersion") // Use only one material3 version
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")         bu var
    implementation("androidx.appcompat:appcompat:1.6.1")                                        bu var
    implementation("com.google.android.material:material:1.9.0")                                farklı versiyonu var
    implementation("androidx.compose.material:material:$composeVersion")                        bu var
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))                         bu var
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")                        bu var
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")                            bu var
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")                      bu var
    implementation("com.google.firebase:firebase-auth-ktx")                                     bu var

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:$composeVersion"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
*/
