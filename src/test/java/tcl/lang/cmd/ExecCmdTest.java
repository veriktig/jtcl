/*
 * Copyright 2018 Veriktig, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tcl.lang.cmd;

import java.util.Arrays;
import java.util.LinkedList;

import com.veriktig.scandium.internal.test.TclCmdTest;

public class ExecCmdTest extends TclCmdTest {
	public void testCmd() throws Exception {
		LinkedList<String> expectedFailureList = new LinkedList<String>(Arrays.asList( new String[] {
				// exec-1.3 and exec-63 fail because the JVM process model doesn't allow for proper STDIN 
				// file descriptor inheritance, instead using a pipe model.  Too much of stdin can get
				// eaten up because of this.  The solution is to create platform-specific subclasses
				// of TclProcess which do proper inheritance.  However, these two test fail only
				// occassionally, so we inserted the "stdinInherit" testconstraint into exec.test
				// which should be removed when we have platform-specific exec.
				//"exec-1.3",
				//"exec-6.3",
				
				// exec-11.5 and exec-17.1 fail because JVM doesn't allow background processes to survive the JVM
				// if they read from STDIN or write to STDOUT/STDERR.  There's no direct access
				// in the JVM to filedescriptors 0, 1, 2; we're only given InputStream() and OutputStream()
				// so the JVM must be running.  However, putting processes in the background does
				// work, even though these tests fail.
                /*
	            "exec-11.5",
	            "exec-17.1" 
                */
	        }));
		String resName = "/tcl/lang/cmd/exec.test";
		tclTestResource(TCLTEST_NAMEOFEXECUTABLE,  resName, expectedFailureList);
	}
}
