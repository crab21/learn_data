package com.example.algorithm.Executor;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Java并发减少锁的竞争：
 * 1.减少锁的持有时间
 * 2.降低锁的请求频率
 * 3.放弃使用并发锁，使用并发容器，原子变量，读写锁等来代替他。
 */
public class LockLearn {

    /**
     * 减少锁的持有时间
     */
    private final Map<String, String> attributes = new HashMap<String, String>();

    public synchronized boolean userLocationMatches(String username, String regex) {
        String key = "user." + username;
        String location = attributes.get(key);
        if (location == null)
            return false;
        else
            return Pattern.matches(regex, location);
    }

    /**
     * 上述代码可以优化
     */

    public boolean userLocationMatchesTwo(String username, String regex) {
        String key = "user." + username;
        String location;
        //todo 缩小范围
        synchronized (this) {
            location = attributes.get(key);
        }
        if (StringUtils.isEmpty(location)) {

            return false;
        }
        return Pattern.matches(regex, location);
    }


    public static void main(String[] args) {
        String lfc = null;
        if (lfc == null || lfc.length() == 0) {
            System.out.println("----");
        }
    }

    /**
     * 降低锁的请求频率：使用锁分解
     */
    private Set<String> users;
    private Set<String> queries;

    public synchronized void addUser(String user) {
        users.add(user);
    }

    public synchronized void removeUser(String user) {
        users.remove(user);
    }

    public synchronized void addQuery(String query) {
        queries.add(query);
    }

    public synchronized void removeQuery(String query) {
        queries.remove(query);
    }

    /**
     * 上述代码优化后<锁分解>
     */

    public void addUserT(String user) {
        synchronized (users) {
            users.add(user);
        }
    }

    public void removeUserT(String user) {
        synchronized (users) {
            users.add(user);
        }
    }

    public void addQueryT(String query) {
        synchronized (queries) {
            queries.add(query);
        }
    }

    public void removeQueryT(String query) {
        synchronized (queries) {
            queries.remove(query);
        }
    }

}
