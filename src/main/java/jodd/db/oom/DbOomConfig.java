// Copyright (c) 2003-present, Jodd Team (http://jodd.org)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package jodd.db.oom;

import jodd.db.oom.naming.ColumnNamingStrategy;
import jodd.db.oom.naming.TableNamingStrategy;

/**
 * DBOOM configuration for names and SQL generation.
 */
public class DbOomConfig {

	/**
	 * Specifies separator for column aliases that divides table reference and column name.
	 * Separator should contains of characters that are not used in table names, such as:
	 * '$' or '__'.
	 */
	private String columnAliasSeparator = "$";
	/**
	 * Default column alias type.
	 */
	private ColumnAliasType defaultColumnAliasType;
	/**
	 * Optional schema name.
	 */
	private String schemaName;
	/**
	 * Table name strategy.
	 */
	private TableNamingStrategy tableNames = new TableNamingStrategy();
	/**
	 * Column name strategy.
	 */
	private ColumnNamingStrategy columnNames = new ColumnNamingStrategy();

	/**
	 * {@code true} if SQL syntax allow usage of table alias in the update query.
	 */
	private boolean updateAcceptsTableAlias = true;

	/**
	 * {@code true} if database supports update of the primary key.
	 */
	private boolean updateablePrimaryKey = true;

	/**
	 * Defines entity-aware mode, when resulting collections does not have duplicates.
	 * It make sense to enable it if {@link #cacheEntitiesInResultSet cache} is set.
	 */
	private boolean entityAwareMode = false;

	/**
	 * Defines if entities have to be cached in result set.
	 * When cached, more memory is consumed during the existence of
	 * {@link jodd.db.oom.mapper.ResultSetMapper}.
	 */
	private boolean cacheEntitiesInResultSet = false;

	/**
	 * Specifies how primary keys are generated by database.
	 */
	protected boolean keysGeneratedByDatabase = true;

	// ---------------------------------------------------------------- r/o

	public TableNamingStrategy getTableNames() {
		return tableNames;
	}

	public ColumnNamingStrategy getColumnNames() {
		return columnNames;
	}


	// ---------------------------------------------------------------- access

	public String getColumnAliasSeparator() {
		return columnAliasSeparator;
	}

	public void setColumnAliasSeparator(final String separator) {
		this.columnAliasSeparator = separator;
	}


	public ColumnAliasType getDefaultColumnAliasType() {
		return defaultColumnAliasType;
	}

	public void setDefaultColumnAliasType(final ColumnAliasType defaultColumnAliasType) {
		this.defaultColumnAliasType = defaultColumnAliasType;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(final String schemaName) {
		this.schemaName = schemaName;
	}

	public boolean isUpdateAcceptsTableAlias() {
		return updateAcceptsTableAlias;
	}

	public void setUpdateAcceptsTableAlias(final boolean updateAcceptsTableAlias) {
		this.updateAcceptsTableAlias = updateAcceptsTableAlias;
	}

	public boolean isUpdateablePrimaryKey() {
		return updateablePrimaryKey;
	}

	public void setUpdateablePrimaryKey(final boolean updateablePrimaryKey) {
		this.updateablePrimaryKey = updateablePrimaryKey;
	}

	public boolean isEntityAwareMode() {
		return entityAwareMode;
	}

	public void setEntityAwareMode(final boolean entityAwareMode) {
		this.entityAwareMode = entityAwareMode;
	}

	public boolean isCacheEntitiesInResultSet() {
		return cacheEntitiesInResultSet;
	}

	public void setCacheEntitiesInResultSet(final boolean cacheEntitiesInResultSet) {
		this.cacheEntitiesInResultSet = cacheEntitiesInResultSet;
	}

	public boolean isKeysGeneratedByDatabase() {
		return keysGeneratedByDatabase;
	}

	public void setKeysGeneratedByDatabase(final boolean keysGeneratedByDatabase) {
		this.keysGeneratedByDatabase = keysGeneratedByDatabase;
	}

}
