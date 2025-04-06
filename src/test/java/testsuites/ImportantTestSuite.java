package testsuites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Important Test Suite")
@IncludeTags("Important")
@SelectPackages("sppcw")

public class ImportantTestSuite {
}
