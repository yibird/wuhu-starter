//package com.fly.starter.web.autoconfigure.response;
//
//import com.feiniaojin.gracefulresponse.GracefulResponseProperties;
//import com.feiniaojin.gracefulresponse.advice.AbstractResponseBodyAdvice;
//import com.feiniaojin.gracefulresponse.advice.AdviceSupport;
//import com.feiniaojin.gracefulresponse.advice.GrNotVoidResponseBodyAdvice;
//import com.feiniaojin.gracefulresponse.advice.lifecycle.response.ResponseBodyAdvicePredicate;
//import com.feiniaojin.gracefulresponse.advice.lifecycle.response.ResponseBodyAdviceProcessor;
//import com.feiniaojin.gracefulresponse.api.ResponseFactory;
//import com.feiniaojin.gracefulresponse.data.Response;
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.Resource;
//import jakarta.servlet.http.HttpServletRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.MethodParameter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.lang.reflect.Method;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//
///**
// * @Description
// * @Author zchengfeng
// * @Datetime 2025/3/27 3:03
// */
//@Order(100)
//@ControllerAdvice
//public class NotVoidResponseBodyAdvice extends AbstractResponseBodyAdvice implements ResponseBodyAdvicePredicate, ResponseBodyAdviceProcessor {
//
//    private final Logger logger = LoggerFactory.getLogger(GrNotVoidResponseBodyAdvice.class);
//    @Resource
//    private ResponseFactory responseFactory;
//    @Resource
//    private GracefulResponseProperties properties;
//    @Resource
//    private AdviceSupport adviceSupport;
//    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();
//
//    public NotVoidResponseBodyAdvice() {
//    }
//
//    public Object process(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        System.out.println("asdasd");
//        if (body == null) {
//            return this.responseFactory.newSuccessInstance();
//        } else if (body instanceof Response) {
//            return body;
//        } else {
//            if (this.logger.isDebugEnabled()) {
//                String path = request.getURI().getPath();
//                this.logger.debug("Graceful Response:非空返回值，执行封装:path={}", path);
//            }
//
//            return this.responseFactory.newSuccessInstance(body);
//        }
//    }
//
//    public boolean shouldApplyTo(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> clazz) {
//        Method method = methodParameter.getMethod();
//        if (!Objects.isNull(method) && !method.getReturnType().equals(Void.TYPE) && !method.getReturnType().equals(Response.class) && this.adviceSupport.isJsonHttpMessageConverter(clazz)) {
//            if (this.adviceSupport.matchExcludeFromGracefulResponse(method)) {
//                return false;
//            } else {
//                List<String> excludePackages = this.properties.getExcludePackages();
//                if (!CollectionUtils.isEmpty(excludePackages)) {
//                    String packageName = method.getDeclaringClass().getPackage().getName();
//                    if (excludePackages.stream().anyMatch((item) -> {
//                        return ANT_PATH_MATCHER.match(item, packageName);
//                    })) {
//                        this.logger.debug("Graceful Response:匹配到excludePackages例外配置，跳过:packageName={},", packageName);
//                        return false;
//                    }
//                }
//
//                Set<Class<?>> excludeReturnTypes = this.properties.getExcludeReturnTypes();
//                if (!CollectionUtils.isEmpty(excludeReturnTypes) && excludeReturnTypes.contains(method.getReturnType())) {
//                    this.logger.debug("Graceful Response:匹配到excludeReturnTypes例外配置，跳过:returnType={},", method.getReturnType());
//                    return false;
//                } else {
//                    List<String> excludeUrls = this.properties.getExcludeUrls();
//                    RequestAttributes requestAttributes;
//                    if (!CollectionUtils.isEmpty(excludeUrls)) {
//                        requestAttributes = RequestContextHolder.currentRequestAttributes();
//                        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//                        String requestUri = request.getRequestURI();
//                        Iterator var10 = excludeUrls.iterator();
//
//                        while(var10.hasNext()) {
//                            String excludeUrl = (String)var10.next();
//                            if (ANT_PATH_MATCHER.match(excludeUrl, requestUri)) {
//                                this.logger.debug("Graceful Response:匹配到excludeUrls例外配置，跳过:excludeUrl={},requestURI={}", excludeUrl, requestUri);
//                                return false;
//                            }
//                        }
//                    }
//
//                    requestAttributes = RequestContextHolder.getRequestAttributes();
//                    if (Objects.isNull(requestAttributes)) {
//                        return false;
//                    } else {
//                        Exception releaseException = (Exception)requestAttributes.getAttribute("RELEASE_EXCEPTION_KEY", 0);
//                        if (Objects.nonNull(releaseException) && this.adviceSupport.isMatchExcludeException(releaseException)) {
//                            return false;
//                        } else {
//                            this.logger.debug("Graceful Response:非空返回值，需要进行封装");
//                            return true;
//                        }
//                    }
//                }
//            }
//        } else {
//            this.logger.debug("Graceful Response:method为空、返回值为void和Response类型、非JSON，跳过");
//            return false;
//        }
//    }
//
//    @PostConstruct
//    public void init() {
//        CopyOnWriteArrayList<ResponseBodyAdvicePredicate> copyOnWriteArrayList = new CopyOnWriteArrayList();
//        copyOnWriteArrayList.add(this);
//        this.setPredicates(copyOnWriteArrayList);
//        this.setResponseBodyAdviceProcessor(this);
//    }
//}
