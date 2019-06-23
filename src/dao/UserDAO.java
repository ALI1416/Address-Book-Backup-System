package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBHelper;

public class UserDAO {

	/**
	 * 注册账号
	 * 
	 * @param user_name
	 * @param user_pwd
	 * @param user_safe
	 * @return 1成功0失败
	 */
	public int registerAccount(String user_name, String user_pwd, String user_safe) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "insert user(user_name,user_pwd,user_safe) values(?,?,?);";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setString(1, user_name);
			stmt.setString(2, user_pwd);
			stmt.setString(3, user_safe);
			System.out.println("注册账号 user_name为" + user_name + " user_pwd为" + user_pwd + " user_safe为" + user_safe);
			int n = stmt.executeUpdate();
			if (n == 1) {
				System.out.println("账号注册成功");
				return 1;
			} else {
				System.out.println("账号注册失败");
				return 0;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("账号注册失败");
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 账号寻找id
	 * 
	 * @param user_name
	 * @return id
	 */
	public int findIdByName(String user_name) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "select user_id from user where user_name=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setString(1, user_name);
			System.out.println("查找账号" + user_name);
			re = stmt.executeQuery();// 获得数据集
			if (re.next()) {
				int id = re.getInt(1);
				if (id != 0) {
					System.out.println("找的账号" + user_name + "的id为" + id);
					return id;
				} else {
					System.out.println("未找到账号");
					return 0;
				}
			} else {
				System.out.println("未找到账号");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 检查密码 根据账号
	 * 
	 * @param user_name
	 * @param user_pwd
	 * @return id
	 */
	public int checkPwdByNameReturnId(String user_name, String user_pwd) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "select user_id from user where user_name=? and user_pwd=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setString(1, user_name);
			stmt.setString(2, user_pwd);
			System.out.println("登录账号 user_name为" + user_name + " user_pwd为" + user_pwd);
			re = stmt.executeQuery();// 获得数据集
			if (re.next()) {
				int id = re.getInt(1);
				if (id != 0) {
					System.out.println("账号登录成功");
					return id;
				} else {
					System.out.println("账号登录失败");
					return 0;
				}
			} else {
				System.out.println("账号登录成失败");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 检查密码 根据id
	 * 
	 * @param user_id
	 * @param user_pwd
	 * @return 1正确0错误
	 */
	public int checkPwdById(int user_id, String user_pwd) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "select count(*) from user where user_id=? and user_pwd=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setInt(1, user_id);
			stmt.setString(2, user_pwd);
			System.out.println("登录账号 user_id为" + user_id + " user_pwd为" + user_pwd);
			re = stmt.executeQuery();// 获得数据集
			if (re.next()) {
				int id = re.getInt(1);
				if (id == 1) {
					System.out.println("账号检查成功");
					return 1;
				} else {
					System.out.println("账号检查失败");
					return 0;
				}
			} else {
				System.out.println("账号检查成失败");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 检查密保 根据账号
	 * 
	 * @param user_name
	 * @param user_safe
	 * @return id
	 */
	public int checkSafeByNameReturnId(String user_name, String user_safe) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "select user_id from user where user_name=? and user_safe=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setString(1, user_name);
			stmt.setString(2, user_safe);
			System.out.println("登录账号 user_name为" + user_name + " user_safe为" + user_safe);
			re = stmt.executeQuery();// 获得数据集
			if (re.next()) {
				int id = re.getInt(1);
				if (id != 0) {
					System.out.println("密保检查成功 id为" + id);
					return id;
				} else {
					System.out.println("密保检查失败");
					return 0;
				}
			} else {
				System.out.println("密保检查成失败");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 检查密保 根据id
	 * 
	 * @param user_id
	 * @param user_safe
	 * @return 1正确0错误
	 */
	public int checkSafeById(int user_id, String user_safe) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "select count(*) from user where user_id=? and user_safe=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setInt(1, user_id);
			stmt.setString(2, user_safe);
			System.out.println("登录账号 user_id为" + user_id + " user_safe为" + user_safe);
			re = stmt.executeQuery();// 获得数据集
			if (re.next()) {
				int id = re.getInt(1);
				if (id == 1) {
					System.out.println("密保检查成功");
					return 1;
				} else {
					System.out.println("密保检查失败");
					return 0;
				}
			} else {
				System.out.println("密保检查成失败");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新密码
	 * 
	 * @param user_id
	 * @param user_pwd
	 * @return 1成功0失败
	 */
	public int updatePwd(int user_id, String user_pwd) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "update user set user_pwd=? where user_id=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setString(1, user_pwd);
			stmt.setInt(2, user_id);
			System.out.println("更新密码 user_id为" + user_id + " user_pwd为" + user_pwd);
			int n = stmt.executeUpdate();
			if (n == 1) {
				System.out.println("更新密码成功");
				return 1;
			} else {
				System.out.println("更新密码失败");
				return 0;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("更新密码失败");
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新密保
	 * 
	 * @param user_id
	 * @param user_safe
	 * @return 1成功0失败
	 */
	public int updateSafe(int user_id, String user_safe) {
		Connection conn = null;// sql连接
		PreparedStatement stmt = null;// sql连接对象
		ResultSet re = null;// 数据集

		try {
			conn = DBHelper.getConnection();
			String sql = "update user set user_safe=? where user_id=?;";
			stmt = conn.prepareStatement(sql);// 执行sql语句
			stmt.setString(1, user_safe);
			stmt.setInt(2, user_id);
			System.out.println("更新密码 user_id为" + user_id + " user_safe为" + user_safe);
			int n = stmt.executeUpdate();
			if (n == 1) {
				System.out.println("更新密保成功");
				return 1;
			} else {
				System.out.println("更新密保失败");
				return 0;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("更新密保失败");
			return 0;
		} finally {// 释放资源
			if (re != null) {// 关闭数据集对象
				try {
					re.close();
					re = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {// 关闭语句对象
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 修改密码 根据密码
	 * 
	 * @param user_id
	 * @param user_old_pwd
	 * @param user_pwd
	 * @return 1成功0失败
	 * @author ALI 调用checkPwdById(user_id, user_old_pwd)
	 * @author ALI 调用updatePwd(user_id, user_pwd)
	 */
	public int changePwdByPwd(int user_id, String user_old_pwd, String user_pwd) {
		// 检查密码是否正确
		int yes = checkPwdById(user_id, user_old_pwd);
		if (yes != 0) {
			int ok = updatePwd(user_id, user_pwd);
			if (ok != 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	/**
	 * 修改密码 根据密保
	 * 
	 * @param user_id
	 * @param user_safe
	 * @param user_pwd
	 * @return 1成功0失败
	 * @author ALI 调用checkSafeById(user_id, user_safe)
	 * @author ALI 调用updatePwd(user_id, user_pwd)
	 */
	public int changePwdBySafe(int user_id, String user_safe, String user_pwd) {
		// 检查密码是否正确
		int yes = checkSafeById(user_id, user_safe);
		if (yes != 0) {
			int ok = updatePwd(user_id, user_pwd);
			if (ok != 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	/**
	 * 修改密保 根据密保
	 * 
	 * @param user_id
	 * @param user_old_safe
	 * @param user_safe
	 * @return 1成功0失败
	 * @author ALI 调用checkSafeById(user_id, user_old_safe)
	 * @author ALI 调用updateSafe(user_id, user_safe)
	 */
	public int changeSafeBySafe(int user_id, String user_old_safe, String user_safe) {
		// 检查密码是否正确
		int yes = checkSafeById(user_id, user_old_safe);
		if (yes != 0) {
			int ok = updateSafe(user_id, user_safe);
			if (ok != 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	/**
	 * 修改密码 根据账号和密保
	 * 
	 * @param user_name
	 * @param user_safe
	 * @param user_pwd
	 * @return 1成功0失败
	 * @author ALI 调用checkSafeByNameReturnId(user_name, user_safe)
	 * @author ALI 调用updatePwd(id, user_pwd)
	 */
	public int changePwdByNameAndSafe(String user_name, String user_safe, String user_pwd) {
		// 检查密码是否正确
		int id = checkSafeByNameReturnId(user_name, user_safe);
		if (id != 0) {
			int ok = updatePwd(id, user_pwd);
			if (ok != 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

}
