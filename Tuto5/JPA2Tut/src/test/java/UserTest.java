
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

import org.dbunit.dataset.ITable;
import org.dbunit.util.TableFormatter;
import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Date;

import javax.persistence.*;
import java.sql.*;
import org.slf4j.*;

import net.persistance.db.User;

public class UserTest {
    static EntityManager em;
    static EntityTransaction tx;

    private static final Logger LOG = LoggerFactory.getLogger(UserTest.class);
    
    @BeforeClass
    public static void initEntityManager()throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("USER");
		em = emf.createEntityManager();
    } 
    
    @AfterClass
    public static void closeEntityManager()throws Exception {}
    
    @Before
    public void initTransaction() throws Exception {
        tx = em.getTransaction();
        seedData();
        }
    protected void seedData() throws Exception { 
        tx.begin();
        Connection connection = em.unwrap(java.sql.Connection.class);
         try { 
             IDatabaseConnection dbUnitCon = new DatabaseConnection(connection);
             dbUnitCon.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
                     
             IDataSet dataset;
             FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
             flatXmlDataSetBuilder.setColumnSensing(true);
             InputStream in =Thread.currentThread().getContextClassLoader().getResourceAsStream("data/dataset.xml");
             if(in !=null){ 
                 LOG.warn("DataSet found");
                 dataset = flatXmlDataSetBuilder.build(in);
                 DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataset);
                 } else {
                     LOG.warn("DataSet not found");
                     dataset= new DefaultDataSet();
                     }
                     DatabaseOperation.REFRESH.execute(dbUnitCon, dataset);
                     } finally {
                         tx.commit();
                        } }
    @Test
    public final void testFindAll() {
        LOG.info("testFindAll");
         try{
             tx.begin();
             List<User> list = em.createQuery("select u from USER u").getResultList();
             LOG.debug("find by example successful, result size: "+ list.size());
             assertEquals("did not get expected number of entities ", 5, list.size());
             } catch (RuntimeException re) {
                 LOG.error("find by example failed", re);
                 throw re;
                 }finally{
                     tx.commit();}
                     }
    
    @Test
    public void addTwoUsers() throws Exception {
        LOG.info("addTwoUsers");
        try{ 
            tx.begin();
            User user1=new User("James","Gosling",new Date());
            em.persist(user1);
            User user2=new User("Dennis","Ritchie",new Date());
            em.persist(user2);
            }catch (RuntimeException re) {
                LOG.error("find by example failed", re);
                throw re;
                }finally{
                    tx.commit();
                     }}
    
    @Rule public TestName name = new TestName();
    @After
    public void afterTests() throws Exception {
        Class driverClass = Class.forName("org.h2.Driver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:h2:mem://localhost :9101/dbunit", "sa", "");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
         // full database export
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("target/"+ name.getMethodName()+".xml"));
        FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("target/"+" test.dtd"));
        }
}
