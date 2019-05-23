package main.java.com.sparrow.zg.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataSource ds = null;
        try {
            ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println( "Hello World!" );
    }
}
