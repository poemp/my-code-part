package org.poem.lang.loader;

import org.poem.lang.SearchJava;
import org.poem.lang.core.JavaClass;
import org.poem.lang.stream.JavaClassFunction;
import org.poem.utils.collection.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Java Class 加载
 */
public class JavaLoader {

    /**
     * 需要加载的类
     */
    private List<String> classNames;

    /**
     * 类加载
     */
    private static JavaLoader classLoader;

    /**
     * constructor
     *
     * @param classNames
     */
    private JavaLoader(List<String> classNames) {
        this.classNames = classNames;
    }


    /**
     * 加载类
     *
     * @return
     */
    public List<JavaClass> getJavaClass() {
        return this.classNames
                .stream()
                .map(new JavaClassFunction())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * 组装数据
     *
     * @param classNames
     * @return
     */
    public static JavaLoader getInstance(List<String> classNames) {
        return new JavaLoader(classNames);
    }
}
