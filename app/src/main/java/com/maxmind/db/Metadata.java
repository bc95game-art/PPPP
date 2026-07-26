package com.maxmind.db;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class Metadata {
    private final int binaryFormatMajorVersion;
    private final int binaryFormatMinorVersion;
    private final BigInteger buildEpoch;
    private final String databaseType;
    private final Map<String, String> description;
    private final int ipVersion;
    private final List<String> languages;
    private final int nodeByteSize;
    private final int nodeCount;
    private final int recordSize;
    private final int searchTreeSize;

    @MaxMindDbConstructor
    public Metadata(@MaxMindDbParameter(name = "binary_format_major_version") int i, @MaxMindDbParameter(name = "binary_format_minor_version") int i2, @MaxMindDbParameter(name = "build_epoch") BigInteger bigInteger, @MaxMindDbParameter(name = "database_type") String str, @MaxMindDbParameter(name = "languages") List<String> list, @MaxMindDbParameter(name = "description") Map<String, String> map, @MaxMindDbParameter(name = "ip_version") int i3, @MaxMindDbParameter(name = "node_count") long j, @MaxMindDbParameter(name = "record_size") int i4) {
        this.binaryFormatMajorVersion = i;
        this.binaryFormatMinorVersion = i2;
        this.buildEpoch = bigInteger;
        this.databaseType = str;
        this.languages = list;
        this.description = map;
        this.ipVersion = i3;
        int i5 = (int) j;
        this.nodeCount = i5;
        this.recordSize = i4;
        int i6 = i4 / 4;
        this.nodeByteSize = i6;
        this.searchTreeSize = i5 * i6;
    }

    public int getBinaryFormatMajorVersion() {
        return this.binaryFormatMajorVersion;
    }

    public int getBinaryFormatMinorVersion() {
        return this.binaryFormatMinorVersion;
    }

    public Date getBuildDate() {
        return new Date(this.buildEpoch.longValue() * 1000);
    }

    public String getDatabaseType() {
        return this.databaseType;
    }

    public Map<String, String> getDescription() {
        return this.description;
    }

    public int getIpVersion() {
        return this.ipVersion;
    }

    public List<String> getLanguages() {
        return this.languages;
    }

    public int getNodeByteSize() {
        return this.nodeByteSize;
    }

    public int getNodeCount() {
        return this.nodeCount;
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    public int getSearchTreeSize() {
        return this.searchTreeSize;
    }

    public String toString() {
        return "Metadata [binaryFormatMajorVersion=" + this.binaryFormatMajorVersion + ", binaryFormatMinorVersion=" + this.binaryFormatMinorVersion + ", buildEpoch=" + this.buildEpoch + ", databaseType=" + this.databaseType + ", description=" + this.description + ", ipVersion=" + this.ipVersion + ", nodeCount=" + this.nodeCount + ", recordSize=" + this.recordSize + "]";
    }
}
