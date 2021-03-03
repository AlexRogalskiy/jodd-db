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

package jodd.db.debug;

import jodd.db.fixtures.DbHsqldbTestCase;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggablePreparedStatementTest extends DbHsqldbTestCase {

	@Test
	void testSetParameters() throws SQLException {
		Connection connection = cp.getConnection();

		String sql = "select * from BOY t where t.id=?";
		LoggablePreparedStatement preparedStatement = new LoggablePreparedStatement(connection.prepareStatement(sql), sql);
		preparedStatement.setInt(1, 7);
		preparedStatement.close();

		assertEquals("select * from BOY t where t.id=7", preparedStatement.getQueryString());

		sql = "select * from BOY t where t.name=?";
		preparedStatement = new LoggablePreparedStatement(connection.prepareStatement(sql), sql);
		preparedStatement.setString(1, "jodd");
		preparedStatement.close();

		assertEquals("select * from BOY t where t.name='jodd'", preparedStatement.getQueryString());

		sql = "select * from BOY t where t.name=?";
		preparedStatement = new LoggablePreparedStatement(connection.prepareStatement(sql), sql);
		preparedStatement.setNull(1, Types.VARCHAR, "String");
		preparedStatement.close();

		assertEquals("select * from BOY t where t.name=<null>", preparedStatement.getQueryString());

		sql = "select * from BOY t where t.id=?";
		preparedStatement = new LoggablePreparedStatement(connection.prepareStatement(sql), sql);
		preparedStatement.setFloat(1, 1.73f);
		preparedStatement.close();

		assertEquals("select * from BOY t where t.id=1.73", preparedStatement.getQueryString());

		sql = "select * from BOY t where t.id=? and t.name=?";
		preparedStatement = new LoggablePreparedStatement(connection.prepareStatement(sql), sql);
		preparedStatement.setString(2, "jodd");
		preparedStatement.setDouble(1, 1.73);
		preparedStatement.close();

		assertEquals("select * from BOY t where t.id=1.73 and t.name='jodd'", preparedStatement.getQueryString());

		cp.closeConnection(connection);
	}

}
