package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/**
 * Persists the {@link String} Java class but with more storage in the database.
 * 
 * @author graywatson
 */
public class LongStringType extends StringType {

	private static final LongStringType singleTon = new LongStringType();

	public static LongStringType getSingleton() {
		return singleTon;
	}

	private LongStringType() {
		super(SqlType.LONG_STRING, new Class<?>[0]);
	}

	@Override
	public boolean isAppropriateId() {
		return false;
	}

	@Override
	public int getDefaultWidth() {
		return 0;
	}
}