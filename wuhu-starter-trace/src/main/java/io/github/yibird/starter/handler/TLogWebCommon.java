package io.github.yibird.starter.handler;

import com.yomahub.tlog.constant.TLogConstants;
import com.yomahub.tlog.core.rpc.TLogLabelBean;
import com.yomahub.tlog.core.rpc.TLogRPCHandler;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Description TLog Web 通用拦截器
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:32
 */
public class TLogWebCommon extends TLogRPCHandler {
    private static volatile TLogWebCommon tLogWebCommon;

    public static TLogWebCommon loadInstance() {
        if (tLogWebCommon == null) {
            synchronized (TLogWebCommon.class) {
                if (tLogWebCommon == null) {
                    tLogWebCommon = new TLogWebCommon();
                }
            }
        }
        return tLogWebCommon;
    }

    public void preHandle(HttpServletRequest request) {
        String traceId = request.getHeader(TLogConstants.TLOG_TRACE_KEY);
        String spanId = request.getHeader(TLogConstants.TLOG_SPANID_KEY);
        String preIvkApp = request.getHeader(TLogConstants.PRE_IVK_APP_KEY);
        String preIvkHost = request.getHeader(TLogConstants.PRE_IVK_APP_HOST);
        String preIp = request.getHeader(TLogConstants.PRE_IP_KEY);
        TLogLabelBean labelBean = new TLogLabelBean(preIvkApp, preIvkHost, preIp, traceId, spanId);
        processProviderSide(labelBean);
    }

    public void afterCompletion() {
        cleanThreadLocal();
    }
}
