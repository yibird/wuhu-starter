package io.github.yibird.starter.core.utils.tree;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description 树工具类
 * @Author zchengfeng
 * @Datetime 2025/7/22 09:43
 */
public class TreeUtils {

    public static <T> void toTree(Collection<T> coll) {

    }

    public static <T> void toTree(Collection<T> coll, Function<T, T> mapper) {
    }

    public static <T> void toTree(Map<T, T> map) { }

    public static <T> void toTree(Map<T, T> map, Function<T, T> mapper) { }

    public static <T> void getParentNodes() { }

    public static <T> void findNodeById() { }

    public static <T> void findParentNode() { }

    public static <T> void getFirstBranch() { }

    public static <T> void getLastBranch() { }

    public static <T> void getLeafNodes () { }

    public static <T> void eachPreOrder () { }

    public static <T> void eachPostOrder () { }
}
