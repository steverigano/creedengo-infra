package org.greencodeinitiative.creedengo.infra.checks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.System.Logger.Level.ERROR;

class OptimizeReadFileExceptionCheck {

	Logger logger = Logger.getLogger("");

	OptimizeReadFileExceptionCheck(OptimizeReadFileExceptionCheck readFile) {
	}

	public void readPreferences(String filename) {
		//...
		InputStream in = null;
		try {
			in = new FileInputStream(filename); // Noncompliant {{Optimize Read File Exceptions}}
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
		}
		//...
	}
}
