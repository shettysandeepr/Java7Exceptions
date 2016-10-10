package com.training.exceptions;

public class RethrownException {
	public static void main(String[] args) {
		try {
			rethrow("abc");
		} catch (FirstException | SecondException | ThirdException e) {
			// below assignment will throw compile time exception since e is
			// final
			// e = new Exception();
			System.out.println(e.getMessage());
		}
	}

	static void rethrow(String s) throws FirstException, SecondException,
			ThirdException {
		try {
			if (s.equals("First"))
				throw new FirstException("First");
			else if (s.equals("Second"))
				throw new SecondException("Second");
			else
				throw new ThirdException("Third");
		} catch (Exception e) {
			// below assignment disables the improved rethrow exception type
			// checking feature of Java 7
			// e=new ThirdException();
			throw e;
		}
	}

	static class FirstException extends Exception {
		private static final long serialVersionUID = 1L;

		public FirstException(String msg) {
			super(msg);
		}
	}

	static class SecondException extends Exception {
		private static final long serialVersionUID = 1L;

		public SecondException(String msg) {
			super(msg);
		}
	}

	static class ThirdException extends Exception {
		private static final long serialVersionUID = 1L;

		public ThirdException(String msg) {
			super(msg);
		}
	}
}
