package com.daq.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.daq.springboot.utils.MailUtil;
import com.daq.springboot.utils.QRCodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	MailUtil mailUtil;

	@Autowired
	DataSource dataSource;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void testDatasource() throws SQLException {
		//看一下默认数据源
		System.out.println(dataSource.getClass());
		//获得连接
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
			DruidDataSource druidDataSource = (DruidDataSource) dataSource;
			System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
			System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			//关闭连接
			connection.close();
		}
	}

	@Test
	void testReids(){
		redisTemplate.opsForValue().set("key1","value1");
		redisTemplate.opsForValue().get("key1");
	}

	@Test
	void testMail(){
		String[] to = {"2829025551@qq.com"};
		mailUtil.sendHtmlMail("dierci","taihaole",to);
	}
	@Test
	void testQr() throws Exception {
		QRCodeUtil.shengcheng("nihoa","G:\\LogFile\\daq121.jpg");
	}
}
