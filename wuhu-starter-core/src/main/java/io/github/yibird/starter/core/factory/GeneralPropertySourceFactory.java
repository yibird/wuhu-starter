package io.github.yibird.starter.core.factory;

import cn.hutool.core.text.CharSequenceUtil;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.NonNull;

import java.io.IOException;

/**
 * @Description 通用读取配置工厂, 用于搭配@PropertySource注解使用,加载指定配置文件
 * @Author zchengfeng
 * @Datetime 2025/3/26 23:37
 */
public class GeneralPropertySourceFactory extends DefaultPropertySourceFactory {

    @NonNull
    @Override
    public PropertySource<?> createPropertySource(@NonNull String name, EncodedResource encodedResource) throws IOException {
        Resource resource = encodedResource.getResource();
        // 获取配置文件名称
        String resourceName = resource.getFilename();
        // 如果配置文件不为空,且文件后缀名为.yml或yaml,则通过YamlPropertySourceLoader加载配置
        if (CharSequenceUtil.isNotBlank(resourceName) && CharSequenceUtil.endWithAny(resourceName, ".yml", ".yaml")) {
            return new YamlPropertySourceLoader().load(resourceName, resource).getFirst();
        }
        return super.createPropertySource(name, encodedResource);
    }
}
