package epam.project.bookshop.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger= LogManager.getLogger();
    private static ConnectionPool instance;
    private static final int CAPACITY_OF_QUEUE = 8;
    private static final String DATABASE_URL="jdbc:postgresql://localhost:5432/mvcProject";
    private BlockingQueue<ProxyConnection> free = new LinkedBlockingQueue<>(CAPACITY_OF_QUEUE);
    private BlockingQueue<ProxyConnection> used = new LinkedBlockingQueue<>(CAPACITY_OF_QUEUE);
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean();


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.fatal("Driver not registered: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConnectionPool() {

        Properties properties = new Properties();
        properties.put("password", "mvcProject");
        properties.put("user", "mvcProject");
        for (int i = 0; i < CAPACITY_OF_QUEUE; i++) {
            try {
                ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(DATABASE_URL, properties));
                free.add(connection);
            } catch (SQLException e) {
                logger.error("Connection with database is failed: " + e);
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

    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = free.take();
            used.put(connection);
        } catch (InterruptedException e) {
            logger.fatal("Get Connection is failed: " + e);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    // todo deregisterDriver
    private void deregisterDriver(){
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try{
                DriverManager.deregisterDriver(driver);
            }catch (SQLException e){
                logger.fatal("Can't access database to deregister driver: ",e);
            }
        });
    }

    public void releaseConnection(ProxyConnection connection) {
        try {
            used.remove(connection);
            free.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < CAPACITY_OF_QUEUE; i++) {
            try {
                free.take().close();
            } catch (InterruptedException | SQLException e) {
                logger.fatal("Connection is not destroyed: " + e);
            }
        }
    }
}
