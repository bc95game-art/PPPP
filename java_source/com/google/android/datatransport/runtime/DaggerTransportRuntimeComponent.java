package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.material.snackbar.SnackbarManager;
import java.io.Closeable;
import javax.inject.Provider;
/* loaded from: classes.dex */
public final class DaggerTransportRuntimeComponent implements Closeable {
    public Provider executorProvider;
    public Provider metadataBackendRegistryProvider;
    public Provider sQLiteEventStoreProvider;
    public SchemaManager_Factory schemaManagerProvider;
    public SnackbarManager setApplicationContextProvider;
    public Provider transportRuntimeProvider;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((SQLiteEventStore) ((EventStore) this.sQLiteEventStoreProvider.get())).close();
    }
}
