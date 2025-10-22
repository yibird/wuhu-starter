package io.github.yibird.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 访问(请求)日志属性类
 * @Author zchengfeng
 * @Datetime 2025/4/11 15:25
 */
public class AccessLogProperties {
    private boolean enabled = false;
    /**
     * 是否打印请求参数
     */
    private boolean isPrintRequestParam = false;
    /**
     * 是否自动截断超长参数值（如 base64、大文本）
     */
    private boolean longParamTruncate = false;
    /**
     * 超长参数检测阈值（单位：字符）,当参数值长度超过此值时，触发截断规则
     */
    private int longParamThreshold = 2000;
    /**
     * 超长参数最大保留长度(单位：字符),当参数超过 {@link #longParamThreshold} 时，强制截断到此长度
     */
    private int longParamMaxLength = 50;
    /**
     * 截断后追加的后缀符号（如配置 "..." 会让截断内容更直观）
     */
    private String longParamSuffix = "...";
    /**
     * 是否过滤敏感参数,搭配sensitiveParams字段使用
     */
    private boolean isParamSensitive = false;
    /**
     * 敏感词参数字段列表,支持精确匹配,例如id,password
     */
    private List<String> sensitiveParams = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isPrintRequestParam() {
        return isPrintRequestParam;
    }

    public void setPrintRequestParam(boolean printRequestParam) {
        isPrintRequestParam = printRequestParam;
    }

    public boolean isLongParamTruncate() {
        return longParamTruncate;
    }

    public void setLongParamTruncate(boolean longParamTruncate) {
        this.longParamTruncate = longParamTruncate;
    }

    public int getLongParamThreshold() {
        return longParamThreshold;
    }

    public void setLongParamThreshold(int longParamThreshold) {
        this.longParamThreshold = longParamThreshold;
    }

    public int getLongParamMaxLength() {
        return longParamMaxLength;
    }

    public void setLongParamMaxLength(int longParamMaxLength) {
        this.longParamMaxLength = longParamMaxLength;
    }

    public String getLongParamSuffix() {
        return longParamSuffix;
    }

    public void setLongParamSuffix(String longParamSuffix) {
        this.longParamSuffix = longParamSuffix;
    }

    public boolean isParamSensitive() {
        return isParamSensitive;
    }

    public void setParamSensitive(boolean paramSensitive) {
        isParamSensitive = paramSensitive;
    }

    public List<String> getSensitiveParams() {
        return sensitiveParams;
    }

    public void setSensitiveParams(List<String> sensitiveParams) {
        this.sensitiveParams = sensitiveParams;
    }
}
