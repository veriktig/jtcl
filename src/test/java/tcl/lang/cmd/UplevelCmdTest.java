package tcl.lang.cmd;

import com.veriktig.scandium.internal.test.TclCmdTest;

public class UplevelCmdTest extends TclCmdTest {
	public void testCmd() throws Exception {
		String resName = "/tcl/lang/cmd/uplevel.test";
		tclTestResource(resName);
	}
}
