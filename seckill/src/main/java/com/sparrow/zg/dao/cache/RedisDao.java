package com.sparrow.zg.dao.cache;

import com.sparrow.zg.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final JedisPool jedisPool;

	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}

	public Seckill getSeckill(long seckillId) {
		//redis逻辑操作
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckillId;
				//并没有实现内部序列化操作
				// get -> byte[] -> 反序列化 -> Object(Seckill)

			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public String putSeckill() {
		return null;
	}

}
