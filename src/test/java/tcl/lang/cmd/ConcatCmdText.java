package tcl.lang.cmd;

import com.veriktig.scandium.internal.test.TclCmdTest;

public class ConcatCmdText  extends TclCmdTest {
	public void testCmd() throws Exception {
		String resName = "/tcl/lang/cmd/concat.test";
		tclTestResource(resName);
	}
}
