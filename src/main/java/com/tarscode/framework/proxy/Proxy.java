package com.tarscode.framework.proxy;

/**
 * 代理接口
 *
 *Created by liuyang on 17/5/29.
 */
public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}