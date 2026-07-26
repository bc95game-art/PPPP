package com.emanuelef.remote_capture.model;

import androidx.collection.ArraySet;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.fragments.EditListFragment;
import com.emanuelef.remote_capture.model.MatchList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public class ListInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Type mType;

    /* loaded from: classes.dex */
    public enum Type {
        VISUALIZATION_MASK,
        MALWARE_WHITELIST,
        BLOCKLIST,
        FIREWALL_WHITELIST,
        DECRYPTION_LIST
    }

    public ListInfo(Type type) {
        this.mType = type;
    }

    public int getHelpString() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            return C0130R.string.hidden_connections_help;
        }
        if (ordinal == 1) {
            return C0130R.string.malware_whitelist_help;
        }
        if (ordinal == 2) {
            return 0;
        }
        if (ordinal == 3) {
            return C0130R.string.firewall_whitelist_help;
        }
        if (ordinal != 4) {
            return 0;
        }
        return C0130R.string.decryption_rules_help;
    }

    public MatchList getList() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            return PCAPdroid.getInstance().getVisualizationMask();
        }
        if (ordinal == 1) {
            return PCAPdroid.getInstance().getMalwareWhitelist();
        }
        if (ordinal == 2) {
            return PCAPdroid.getInstance().getBlocklist();
        }
        if (ordinal == 3) {
            return PCAPdroid.getInstance().getFirewallWhitelist();
        }
        if (ordinal != 4) {
            return null;
        }
        return PCAPdroid.getInstance().getDecryptionList();
    }

    public Set<MatchList.RuleType> getSupportedRules() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            return new ArraySet(Arrays.asList(MatchList.RuleType.APP, MatchList.RuleType.IP, MatchList.RuleType.HOST, MatchList.RuleType.COUNTRY, MatchList.RuleType.PROTOCOL));
        }
        if (!(ordinal == 1 || ordinal == 2)) {
            if (ordinal == 3) {
                return new ArraySet(Collections.singletonList(MatchList.RuleType.APP));
            }
            if (ordinal != 4) {
                return null;
            }
        }
        return new ArraySet(Arrays.asList(MatchList.RuleType.APP, MatchList.RuleType.IP, MatchList.RuleType.HOST, MatchList.RuleType.COUNTRY));
    }

    public int getTitle() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            return C0130R.string.hidden_connections_rules;
        }
        if (ordinal == 1) {
            return C0130R.string.malware_whitelist_rules;
        }
        if (ordinal == 2) {
            return C0130R.string.firewall_rules;
        }
        if (ordinal == 3) {
            return C0130R.string.whitelist;
        }
        if (ordinal != 4) {
            return 0;
        }
        return C0130R.string.decryption_rules;
    }

    public Type getType() {
        return this.mType;
    }

    public EditListFragment newFragment() {
        return EditListFragment.newInstance(this.mType);
    }

    public void reloadRules() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 1) {
            CaptureService.reloadMalwareWhitelist();
        } else if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal == 4) {
                    CaptureService.reloadDecryptionList();
                }
            } else if (CaptureService.isServiceActive()) {
                CaptureService.requireInstance().reloadFirewallWhitelist();
            }
        } else if (CaptureService.isServiceActive()) {
            CaptureService.requireInstance().reloadBlocklist();
        }
    }
}
