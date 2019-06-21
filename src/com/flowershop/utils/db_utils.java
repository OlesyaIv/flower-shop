package utils;

import com.mysql.cj.jdbc.MysqlDataSource;

public class db_utils {

    private static final String URL = "jdbc:mysql://localhost:3306/flsh?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static db_utils dataGateway;
    private static MysqlDataSource mysqlDataSource;
    private db_utils()
    {
        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USER);
        mysqlDataSource.setPassword(PASSWORD);

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static db_utils getInstance() {
        if (dataGateway == null)
            dataGateway = new db_utils();
        return dataGateway;
    }
    public MysqlDataSource getDataSource() {
        return mysqlDataSource;
    }



}