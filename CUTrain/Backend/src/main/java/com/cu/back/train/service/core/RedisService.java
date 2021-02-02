package com.cu.back.train.service.core;

import com.cu.back.train.model.core.RedisModel;
import com.cu.back.train.utils.CoreUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
@Repository
public class RedisService {
	
	@Value("${redis.url}")
	private String redisUrl;
	
	@Value("${redis.port}")
	private Integer redisPort;

	@Value("${redis.password}")
	private String redisPassword;
	
	public void setData(String key, String value, Integer expire) {
		RedisModel redis = openConnection();
		Jedis jedis = redis.getJedis();
		try {
			if (expire.equals(0)) {
				jedis.set(key, value);
			} else {
				jedis.setex(key, expire, value);
			}
		} catch (Exception e) {
			log.error("Redis error: ", e);
			throw e;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void setData(String key, String value) {
		RedisModel redis = openConnection();
		Jedis jedis = redis.getJedis();
		try {
			jedis.setex(key, (24 * 60 * 60) * 7, value);
		} catch (Exception e) {
			log.error("Redis error: ", e);
			throw e;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public String getData(String key) {
		String rs = null;
		RedisModel redis = openConnection();
		Jedis jedis = redis.getJedis();
		try {
			rs = jedis.get(key);
			if (CoreUtils.isNotEmpty(rs) && (rs.equals("OK") || rs.equals("PONG"))) {
				rs = getData(key);
			}
		} catch (Exception e) {
			log.error("Redis error: ", e);
			throw e;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return rs;
	}

	public void delete(String key) {
		RedisModel redis = openConnection();
		Jedis jedis = redis.getJedis();
		try {
			jedis.del(key);
		} catch (Exception e) {
			log.error("Redis error: ", e);
			throw e;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
 
	private RedisModel openConnection() {
		Jedis jedis = new Jedis(redisUrl, redisPort);
		jedis.auth(redisPassword);
		RedisModel redis = new RedisModel();
		redis.setJedis(jedis);
		return redis;
	}

}
