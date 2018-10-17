package com.xx.baseutilslibrary.network.provider;

/**
 * XxApiConfigProvider
 * (。・∀・)ノ
 * Describe：使用Java8接口默认方法的配置提供者
 * Created by 雷小星🍀 on 2017/10/31 17:48.
 */

public interface XxApiConfigProvider {
    /**
     * 获取Api绝对路径
     *
     * @return 接口基础路径
     */
    default String getApiBaseUrl() {
        return getHost() + getApiRelativePath();
    }

    /**
     * 获取当前环境的Host
     *
     * @return 当前环境的Host
     */
    default String getHost() {
        return isDebug() ? getDebugHost() : getReleaseHost();
    }

    /**
     * 获取Api相对路径
     *
     * @return Api相对路径
     */
    String getApiRelativePath();

    /**
     * 获取调试版的Host路径
     *
     * @return 调试版的Host路径
     */
    String getDebugHost();

    /**
     * 获取发布版的Host路径
     *
     * @return 发布版的Host路径
     */
    String getReleaseHost();

    /**
     * 是否是Debug 模式
     *
     * @return 是否是Debug 模式
     */
    boolean isDebug();
}
