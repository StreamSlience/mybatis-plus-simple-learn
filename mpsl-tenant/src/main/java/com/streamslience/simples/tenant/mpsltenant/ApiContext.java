package com.streamslience.simples.tenant.mpsltenant;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 14:09
 */
@Component
public class ApiContext {

    private static final String KEY_CURRENT_TENANT = "KEY_CURRENT_TENANT";

    private static final Map<String, Object> mContext = Maps.newConcurrentMap();

    public String setCurrentTenantId(String tenantId) {
        synchronized (mContext) {
            if (mContext.get(KEY_CURRENT_TENANT) == null) {
                mContext.put(KEY_CURRENT_TENANT, tenantId);
                return tenantId;
            } else {
                return (String) mContext.get(KEY_CURRENT_TENANT);
            }
        }
    }

    public String getCurrentTenant() {
        return (String) mContext.get(KEY_CURRENT_TENANT);
    }

}
