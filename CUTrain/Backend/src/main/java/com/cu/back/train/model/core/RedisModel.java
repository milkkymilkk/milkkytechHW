package com.cu.back.train.model.core;

import lombok.Data;
import redis.clients.jedis.Jedis;

@Data
public class RedisModel {

	private Jedis jedis;
	
}
