//package sourcecode.analysis;
//
///**
// * Created by caoxiaohong on 17/11/10 10:50.
// */
//public class SpringTransaction {
//    /**
//     * Support a current transaction, create a new one if none exists.
//     * Analogous to EJB transaction attribute of the same name.
//     * <p>This is typically the default setting of a transaction definition.
//     *
//     * 支持当前事务,如果当前没有事务,那就新建一个事务.
//     * 和EJB同名的事务属性基本相同.
//     * 这是事务定义的默认属性.
//     */
//    int PROPAGATION_REQUIRED = 0;
//
//    /**
//     * Support a current transaction, execute non-transactionally if none exists.
//     * Analogous to EJB transaction attribute of the same name.
//     * <p>Note: For transaction managers with transaction synchronization,
//     * PROPAGATION_SUPPORTS is slightly different from no transaction at all,
//     * as it defines a transaction scopp that synchronization will apply for.
//     * As a consequence, the same resources (JDBC Connection, Hibernate Session, etc)
//     * will be shared for the entire specified scope. Note that this depends on
//     * the actual synchronization configuration of the transaction manager.
//     * @see org.springframework.transaction.support.AbstractPlatformTransactionManager#setTransactionSynchronization
//     *
//     * 支持当前事务,如果当前没有事务,则以非事务方式执行.
//     * 和EJB同名的事务属性基本相同.
//     * 注意:有事务同步的事务管理器和没有同步事务的事务管理器,PROPAGATION_SUPPORTS还是稍有区别的,因为它会定义一个在同步时需要用到的
//     * 事务scopp.
//     * 结果就是:一些相同的资源(比如JDBC连接,Hibernate会话等等)会在特定的范围内进行共享.
//     * 注意:这也取决于事务管理器的实际的同步配置机制.
//     *
//     */
//    int PROPAGATION_SUPPORTS = 1;
//
//    /**
//     * Support a current transaction, throw an exception if none exists.
//     * Analogous to EJB transaction attribute of the same name.
//     * 支持当前事务,如果当前没有事务,则会抛出异常.
//     * 和EJB同名的事务属性基本是一样的.
//     */
//    int PROPAGATION_MANDATORY = 2;
//
//    /**
//     * Create a new transaction, suspend the current transaction if one exists.
//     * Analogous to EJB transaction attribute of the same name.
//     * <p>Note: Actual transaction suspension will not work on out-of-the-box
//     * on all transaction managers. This in particular applies to JtaTransactionManager,
//     * which requires the <code>javax.transaction.TransactionManager</code> to be
//     * made available it to it (which is server-specific in standard J2EE).
//     *
//     * 创建一个新事务,如果当前已经存在事务,则挂起当前的事务.
//     * 和EJB同名的事务属性基本是一样的.
//     * 注意:在所有的事务管理器中,事务被挂起并不是开箱即用的.
//     * 这特别适用于JtaTransactionManager,JtaTransactionManager需要javax.transaction.TransactionManager的协助,来使得开箱即用
//     * 这一功能对他来说是可用的.(这是标准J2EE中的服务器会用到的)
//     * @see org.springframework.transaction.jta.JtaTransactionManager#setTransactionManager
//     */
//    int PROPAGATION_REQUIRES_NEW = 3;
//
//    /**
//     * Execute non-transactionally, suspend the current transaction if one exists.
//     * Analogous to EJB transaction attribute of the same name.
//     * <p>Note: Actual transaction suspension will not work on out-of-the-box
//     * on all transaction managers. This in particular applies to JtaTransactionManager,
//     * which requires the <code>javax.transaction.TransactionManager</code> to be
//     * made available it to it (which is server-specific in standard J2EE).
//     *
//     * 以非事务方式执行,如果当前存在事务,则挂起当前事务.
//     * 和EJB同名的事务属性基本是一样的.
//     * 注意:在所有的事务管理器中,事务被挂起并不是开箱即用的.
//     * 这特别适用于JtaTransactionManager,JtaTransactionManager需要javax.transaction.TransactionManager的协助,来使得开箱即用
//     * 这一功能对他来说是可用的.(这是标准J2EE中的服务器会用到的)
//     *
//     * @see org.springframework.transaction.jta.JtaTransactionManager#setTransactionManager
//     */
//    int PROPAGATION_NOT_SUPPORTED = 4;
//
//    /**
//     * Execute non-transactionally, throw an exception if a transaction exists.
//     * Analogous to EJB transaction attribute of the same name.
//     * 以非事务方式执行,如果当前存在事务则抛出异常.
//     * 和EJB同名的事务属性基本是一样的.
//     */
//    int PROPAGATION_NEVER = 5;
//
//    /**
//     * Execute within a nested transaction if a current transaction exists,
//     * behave like PROPAGATION_REQUIRED else. There is no analogous feature in EJB.
//     * <p>Note: Actual creation of a nested transaction will only work on specific
//     * transaction managers. Out of the box, this only applies to the JDBC
//     * DataSourceTransactionManager when working on a JDBC 3.0 driver.
//     * Some JTA providers might support nested transactions as well.
//     *
//     * 如果当前存在事务,则以嵌入式事务方式去执行,和PROPAGATION_REQUIRED行为类似.
//     * 在EJB中没有和这类型的事务执行方式一样的事务.
//     * 注意:嵌入式事务的创建只能工作在特定的事务管理器中.开箱即用这一功能,只能在JDBC驱动的情况下应用在JDBC
//     * DataSourceTransactionManager上面.
//     * 一些JTA供应商也可能会支持嵌入式事务处理.
//     *
//     * @see org.springframework.jdbc.datasource.DataSourceTransactionManager
//     */
//    int PROPAGATION_NESTED = 6;
//}
