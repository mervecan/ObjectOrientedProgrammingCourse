package development.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCell.class, TestGame.class, TestGrid.class, TestPlayer.class, TestRow.class })
public class AllTests {

}
