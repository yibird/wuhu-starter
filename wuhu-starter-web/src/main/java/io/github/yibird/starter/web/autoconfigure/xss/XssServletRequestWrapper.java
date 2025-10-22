package io.github.yibird.starter.web.autoconfigure.xss;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HtmlUtil;
import io.github.yibird.starter.core.constant.StringConstants;
import io.github.yibird.starter.web.enums.XssMode;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.List;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/3/17 1:52
 */
public class XssServletRequestWrapper extends HttpServletRequestWrapper {

    private final XssProperties xssProperties;

    private final String body = "";

    public XssServletRequestWrapper(HttpServletRequest request, XssProperties xssProperties) {
        super(request);
        this.xssProperties = xssProperties;
    }

    @Override
    public BufferedReader getReader() {
        return IoUtil.toBuffered(new StringReader(body));
    }

    @Override
    public ServletInputStream getInputStream() {
        return getServletInputStream(body);
    }

    @Override
    public String getQueryString() {
        return this.handleTag(super.getQueryString());
    }

    @Override
    public String getParameter(String name) {
        return this.handleTag(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (ArrayUtil.isEmpty(values)) {
            return values;
        }
        int length = values.length;
        String[] resultValues = new String[length];
        for (int i = 0; i < length; i++) {
            resultValues[i] = this.handleTag(values[i]);
        }
        return resultValues;
    }

    /**
     * 对文本内容进行 XSS 处理
     *
     * @param content 文本内容
     * @return 返回处理过后内容
     */
    private String handleTag(String content) {
        if (CharSequenceUtil.isBlank(content)) {
            return content;
        }
        XssMode mode = xssProperties.getMode();
        // 转义
        if (XssMode.ESCAPE.equals(mode)) {
            List<String> reStr = ReUtil.findAllGroup0(HtmlUtil.RE_HTML_MARK, content);
            if (CollUtil.isEmpty(reStr)) {
                return content;
            }
            for (String s : reStr) {
                content = content.replace(s, EscapeUtil.escapeHtml4(s)
                        .replace(StringConstants.BACKSLASH, StringConstants.EMPTY));
            }
            return content;
        }
        // 清理
        return HtmlUtil.cleanHtmlTag(content);
    }

    static ServletInputStream getServletInputStream(String body) {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
        return new ServletInputStream() {
            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return false;
            }


            @Override
            public void setReadListener(ReadListener readListener) {
                // 设置监听器
            }
        };
    }
}
