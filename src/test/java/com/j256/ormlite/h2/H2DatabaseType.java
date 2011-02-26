package com.j256.ormlite.h2;

import com.j256.ormlite.db.BaseDatabaseType;
import com.j256.ormlite.db.DatabaseType;

/**
 * H2 database type.
 * 
 * @author graywatson
 */
public class H2DatabaseType extends BaseDatabaseType implements DatabaseType {

	public boolean isDatabaseUrlThisType(String url, String dbTypePart) {
		return dbTypePart.equals("h2");
	}

	@Override
	protected String getDriverClassName() {
		return "org.h2.Driver";
	}

	@Override
	protected String getDatabaseName() {
		return "h2";
	}

	@Override
	public boolean isOffsetLimitArgument() {
		return true;
	}

	@Override
	public void appendLimitValue(StringBuilder sb, int limit, Integer offset) {
		sb.append("LIMIT ");
		if (offset != null) {
			sb.append(offset).append(',');
		}
		sb.append(limit).append(' ');
	}

	@Override
	public void appendOffsetValue(StringBuilder sb, int offset) {
		throw new IllegalStateException("Offset is part of the LIMIT in database type " + getClass());
	}
}