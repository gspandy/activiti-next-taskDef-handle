import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author  izerui.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext*.xml"})
@TransactionConfiguration(defaultRollback=false)
public abstract class AbstractBaseTest extends AbstractTransactionalJUnit4SpringContextTests {
	protected static Logger log = LoggerFactory.getLogger(AbstractBaseTest.class);
	
}
