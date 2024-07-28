pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}
rootProject.name = "Chatty"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":core:common")
include(":core:domain")
include(":core:data")
include(":core:network")
include(":core:database")
include(":core:datastore")
include(":core:designsystem")
include(":core:ui")

include(":feature:onboarding:api")
include(":feature:onboarding:impl")

include(":feature:auth:api")
include(":feature:auth:impl")

include(":feature:overview:api")
include(":feature:overview:impl")

include(":feature:profile:api")
include(":feature:profile:impl")

include(":feature:settings:api")
include(":feature:settings:impl")

include(":android")
include(":desktop")
