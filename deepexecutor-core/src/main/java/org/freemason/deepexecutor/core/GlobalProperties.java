package org.freemason.deepexecutor.core;

import java.io.IOException;
import java.util.Properties;

public class GlobalProperties {
    private static boolean inited = false;

    private static final String DEFAULT_REGISTRY_PROTOCOL = "redis";
    private static final int DEFAULT_QUEEN_SHARD_NUM = 5;
    private static final String DEFAULT_QUEEN_SHARD_PREFIX = "deepexecutor:task:queen";
    private static final int DEFAULT_THREAD_POOL_SIZE = 5;

    private static final String REGISTRY_PROTOCOL_KEY = "registry.protocol";
    private static final String ZOOKEEPER_PATH_KEY = "zookeeper.path";
    private static final String REDIS_CLUSTER_HOSTANDPORTS_KEY = "redis.cluster.host-and-ports";
    private static final String REDIS_POOL_MAXIDLE_KEY = "redis.pool.maxidle";
    private static final String REDIS_POOL_MAXTOTAL_KEY = "redis.pool.maxtotal";
    private static final String QUEEN_SHARD_NUM_KEY = "queen.shard.num";
    private static final String QUEEN_SHARD_PREFIX_KEY = "queen.shard.prefix";
    private static final String THREAD_POOL_SIZE_KEY = "queen.shard.prefix";

    public static String getRegistryProtocol(){
        return CONFIGS.getProperty(REGISTRY_PROTOCOL_KEY,DEFAULT_REGISTRY_PROTOCOL);
    }

    public static String getRedisClusterHostAndPorts(){
        return CONFIGS.getProperty(REDIS_CLUSTER_HOSTANDPORTS_KEY);
    }

    public static String getZookeeperPath() {
        return CONFIGS.getProperty(ZOOKEEPER_PATH_KEY);
    }

    public static int getRedisPoolMaxidle() {
        return Integer.parseInt(CONFIGS.getProperty(REDIS_POOL_MAXIDLE_KEY,"0"));
    }

    public static int getRedisPoolMaxtotal() {
        return Integer.parseInt(CONFIGS.getProperty(REDIS_POOL_MAXTOTAL_KEY,"0"));
    }

    public static int getQueenShardNum() {
        return Integer.parseInt(CONFIGS.getProperty(QUEEN_SHARD_NUM_KEY,DEFAULT_QUEEN_SHARD_NUM + ""));
    }

    public static String getQueenShardPrefix() {
        return CONFIGS.getProperty(QUEEN_SHARD_PREFIX_KEY, DEFAULT_QUEEN_SHARD_PREFIX);
    }

    public static int getThreadPoolSize() {
        return Integer.parseInt(CONFIGS.getProperty(THREAD_POOL_SIZE_KEY,DEFAULT_THREAD_POOL_SIZE + ""));
    }

    private GlobalProperties(){}

    private static Properties CONFIGS;

    public static void init() throws IOException {
        if(!inited){
            CONFIGS = new Properties();
            CONFIGS.load(GlobalProperties.class.getResourceAsStream("/application.properties"));
        }
    }

    public static void init(Properties properties) throws IOException{
        if (properties == null) {
            init();
        }else {
            CONFIGS = properties;
        }
    }



}
