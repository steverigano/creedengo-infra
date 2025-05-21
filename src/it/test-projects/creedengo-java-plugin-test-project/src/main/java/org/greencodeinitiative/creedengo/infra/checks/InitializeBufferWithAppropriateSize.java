package org.greencodeinitiative.creedengo.infra.checks;

class InitializeBufferWithAppropriateSize {
	InitializeBufferWithAppropriateSize(InitializeBufferWithAppropriateSize mc) {
	}

	public void testBufferCompliant() {
		StringBuffer stringBuffer = new StringBuffer(16);
	}

	public void testBufferCompliant2() {
		StringBuffer stringBuffer = new StringBuffer(Integer.valueOf(16));
	}

	public void testBufferNonCompliant() {
		StringBuffer stringBuffer = new StringBuffer(); // Noncompliant {{Initialize StringBuilder or StringBuffer with appropriate size}}
	}

	public void testBuilderCompliant() {
		StringBuilder stringBuilder = new StringBuilder(16);
	}

	public void testBuilderNonCompliant() {
		StringBuilder stringBuilder = new StringBuilder(); // Noncompliant {{Initialize StringBuilder or StringBuffer with appropriate size}}
	}
}
