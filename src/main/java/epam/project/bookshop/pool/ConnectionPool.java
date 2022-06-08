package epam.project.bookshop.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static ConnectionPool instance;
    private static final int CAPACITY_OF_QUEUE = 8;
    private BlockingQueue<Connection> free = new LinkedBlockingQueue<>(CAPACITY_OF_QUEUE);
    private BlockingQueue<Connection> used = new LinkedBlockingQueue<>(CAPACITY_OF_QUEUE);
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean();


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConnectionPool() {
        String url = "jdbc:postgresql://localhost:5432/mvcProject";

        Properties properties = new Properties();
        properties.put("password", "mvcProject");
        properties.put("user", "mvcProject");
        for (int i = 0; i < CAPACITY_OF_QUEUE; i++) {
            try {
                Connection connection = DriverManager.getConnection(url, properties);
                free.add(connection);
            } catch (SQLException e) {
//                e.printStackTrace(); // todo logs
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        // todo Proxy Connection

        Connection connection = null;
        try {
            connection = free.take();
            used.put(connection);
        } catch (InterruptedException e) {
//            e.printStackTrace(); // todo lodo convensci
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    // todo deregisterDriver

    public void releaseConnection(Connection connection) {
        try {
            used.remove(connection);
            free.put(connection);
        } catch (InterruptedException e) {
                // todo lodo convensci
            Thread.currentThread().interrupt();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < CAPACITY_OF_QUEUE; i++) {
            try {
                free.take().close();
            } catch (InterruptedException | SQLException e) {
//                e.printStackTrace();
                // todo log
            }
        }
    }

}
