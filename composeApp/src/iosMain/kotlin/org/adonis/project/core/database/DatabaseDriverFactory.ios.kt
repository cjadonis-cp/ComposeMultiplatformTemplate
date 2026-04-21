package org.adonis.project.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            schema = AppDatabase.Schema,
            name = "app.db"
        )
    }
}
