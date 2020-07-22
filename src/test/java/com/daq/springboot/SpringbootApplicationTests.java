package com.daq.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	private JavaMailSenderImpl mailSender;

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
		//一个简单的邮件
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setSubject("你好~");
		mailMessage.setText("桐宝桐宝,欢迎使用脚手架!!https://daqwt.top");

		mailMessage.setTo("1018505421@qq.com");
		mailMessage.setFrom("2829025551@qq.com");

		mailSender.send(mailMessage);
	}


}
