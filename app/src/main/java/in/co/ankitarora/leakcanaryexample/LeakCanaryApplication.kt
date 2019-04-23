package `in`.co.ankitarora.leakcanaryexample

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class LeakCanaryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }
}