package com.huaming.test.thdutil;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.net.TelnetInputStream;

import com.scd.cbp.biz.common.SystemInfoBS;
import com.scd.cbp.biz.thd.bs.impl.FileOpBSImpl;
import com.scd.cbp.plm.bas.util.SpringUtil;

/**
 * Ftp工具类
 * 
 * @author hb
 *
 */
public class FtpUtils {
	
	
	private static final Log log = LogFactory.getLog(FtpUtils.class);

	/**
	 * 创建目录
	 * 
	 * @param ftpConfig
	 * @param remoteDir
	 * @throws IOException
	 */
	public static void createDir(FtpConfig ftpConfig, String remoteDir)
			throws IOException {
		FTPClient fc = createFtpClient(ftpConfig);
		try {			
			fc.createDirectory(remoteDir);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
			throw e1;
		} catch (FTPIllegalReplyException e1) {
			throw new IOException("Ftp无效应答");
		} catch (FTPException e1) {
			if (e1.getCode() == 550) {
//				e1.printStackTrace();
//				throw new RuntimeException("没有权限创建目录 或者目录已存在");
			}
			//throw new IOException(e1);
			
			//added by jiangzy
			throw new RuntimeException(e1);
			
		} finally {
			disConnect(fc);
		}

	}

	/**
	 * 
	 * 创建FtpClient
	 * 
	 * @param ftpConfig
	 * @return
	 * @throws IOException
	 */
	private static FTPClient createFtpClient()	throws IOException {
		SystemInfoBS systemInfoBS = ((SystemInfoBS) SpringUtil.getBean("bizComSystemInfoBS"));
		FtpConfig ftpConfig = new FtpConfig(systemInfoBS.getCsSysCMap()
				.get("XT.FTP.IP").getValue(), systemInfoBS.getCsSysCMap()
				.get("XT.FTP.NM").getValue(), systemInfoBS.getCsSysCMap()
				.get("XT.FTP.PD").getValue());
		
		FTPClient fc = new FTPClient();
		log.info("Ip"+ftpConfig.getServerName()+"name"+ftpConfig.getUserName()+"password"+ftpConfig.getPassword()+"====================");
		//added by jiangzy 
		fc.setAutoNoopTimeout(6*1000);
		
		
		try {
			fc.connect(ftpConfig.getServerName(), ftpConfig.getPort());
		} catch (IllegalStateException e2) {
			e2.printStackTrace();
			throw e2;
		} catch (IOException e2) {
			throw e2;
		} catch (FTPIllegalReplyException e2) {
			throw new IOException("Ftp无效应答");
		} catch (FTPException e2) {
			throw new IOException(e2);
		}
		boolean error = false;
		try {
			fc.login(ftpConfig.getUserName(), ftpConfig.getPassword());
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
			error = true;
			throw e1;
		} catch (FTPIllegalReplyException e1) {
			error = true;
			throw new IOException("Ftp无效应答");
		} catch (FTPException e1) {
			error = true;
			if (e1.getCode() == 530) {
				throw new RuntimeException("Ftp密码错误");
			}
			throw new IOException(e1);
		} finally {
			if (error) {
				disConnect(fc);
			}
		}

		return fc;

	}
	
	
	/**
	 * 
	 * 创建FtpClient
	 * 
	 * @param ftpConfig
	 * @return
	 * @throws IOException
	 */
	private static FTPClient createFtpClient(FtpConfig ftpConfig)
			throws IOException {
		FTPClient fc = new FTPClient();
		try {
			fc.connect(ftpConfig.getServerName(), ftpConfig.getPort());
		} catch (IllegalStateException e2) {
			e2.printStackTrace();
			throw e2;
		} catch (IOException e2) {
			throw e2;
		} catch (FTPIllegalReplyException e2) {
			throw new IOException("Ftp无效应答");
		} catch (FTPException e2) {
			throw new IOException(e2);
		}
		boolean error = false;
		try {
			fc.login(ftpConfig.getUserName(), ftpConfig.getPassword());
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
			error = true;
			throw e1;
		} catch (FTPIllegalReplyException e1) {
			error = true;
			throw new IOException("Ftp无效应答");
		} catch (FTPException e1) {
			error = true;
			if (e1.getCode() == 530) {
				throw new RuntimeException("Ftp密码错误");
			}
			throw new IOException(e1);
		} finally {
			if (error) {
				disConnect(fc);
			}
		}

		return fc;

	}

	/**
	 * 关闭链接
	 * 
	 * @param fc
	 */
	private static void disConnect(FTPClient fc) {
		try {
			fc.disconnect(true);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw e;
		} catch (FTPIllegalReplyException e) {
			e.printStackTrace();
		} catch (FTPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * FTP上传	
	 * @param localFile
	 *            文件名称以localFile.fileName为准
	 * @param remoteDir
	 * @param remoteFileName
	 * @throws IOException
	 */
	public static void upload(File localFile,String remoteDir) throws IOException {
		
		FTPClient ftpClient = createFtpClient();
		try {
			ftpClient.changeDirectory(remoteDir);
			//add by cangy 20160104 start
			ftpClient.setType(FTPClient.TYPE_BINARY);
			//add by cangy 20160104 end
			ftpClient.upload(localFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw e;
		} catch (FTPIllegalReplyException e) {
			e.printStackTrace();
			throw new IOException(e);
		} catch (FTPException e) {
			e.printStackTrace();
			if (e.getCode() == 550) {
				throw new RuntimeException("没有权限创建文件");
			}
			throw new IOException(e);
		} catch (FTPDataTransferException e) {
			e.printStackTrace();
			throw new IOException("Ftp传输失败");
		} catch (FTPAbortedException e) {
			e.printStackTrace();
			throw new IOException("Ftp被放弃");
		} finally {
			disConnect(ftpClient);
			if (localFile.exists()) {
				localFile.delete();
			}
		}
	}

	/**
	 * FTP上传	 
	 * @param localFile
	 * @param remotePath
	 * @param remoteFileName
	 * @throws IOException
	 */
	public static void download(String remotePath, String remoteFileName,String localPath) throws IOException {
		FTPClient ftpClient = createFtpClient();			
		try {	
			ftpClient.changeDirectory(remotePath);
			File localFile = new File(localPath+remoteFileName);  
			ftpClient.download(remoteFileName, localFile);			
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw e;
		} catch (FTPIllegalReplyException e) {
			e.printStackTrace();
			throw new IOException(e);
		} catch (FTPException e) {
			e.printStackTrace();
			throw new IOException(e);
		} catch (FTPDataTransferException e) {
			e.printStackTrace();
			throw new IOException("Ftp传输失败");
		} catch (FTPAbortedException e) {
			e.printStackTrace();
			throw new IOException("Ftp被放弃");
		} finally {
			disConnect(ftpClient);
		}
	}
	

	/**
	 * 删除文件
	 * 
	 * @param ftpConfig
	 * @param localFile
	 * @param remoteDir
	 * @param remoteFileName
	 * @throws IOException
	 */
	public static void removeFile(String remoteDir,	String remoteFileName) throws IOException {
		FTPClient ftpClient = createFtpClient();
		try {
			ftpClient.changeDirectory(remoteDir);
			ftpClient.deleteFile(remoteFileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw e;
		} catch (FTPIllegalReplyException e) {
			e.printStackTrace();
			throw new IOException(e);
		} catch (FTPException e) {
			e.printStackTrace();
			if (e.getCode() == 550) {
				throw new RuntimeException("文件不存在");
			}
			throw new IOException(e);
		} finally {
			disConnect(ftpClient);
		}
	}
	
	public static void makeDirs(String dir)  throws IOException{	
		
		FTPClient ftpClient = null;
		
		try {
			ftpClient = createFtpClient();
			ftpClient.changeDirectory("/"); // 切换到根目录
			
			//changed by jiangzy
			//dir example: obw//20151219 ,but at coder local, File.separator is "\"
//			StringTokenizer dirs = new StringTokenizer(dir, File.separator);
			
			StringTokenizer dirs = new StringTokenizer(dir, "//");
			
			String temp = null;			
			while (dirs.hasMoreElements()) {
				temp = dirs.nextElement().toString();				
				if (!isDirExist(ftpClient,temp)) {
					ftpClient.createDirectory(temp);// 创建目录
					ftpClient.changeDirectory(temp);// 进入创建的目录					
				}
			}	
		} catch (Exception e) {
			throw new RuntimeException(e);				
		} finally {
			disConnect(ftpClient);
		}
	}
	
	/**
	 * 检查目录是否存在
	 * 
	 * @param dir
	 * @param ftpClient
	 * @return
	 */
	public static boolean isDirExist(FTPClient ftpClient,String dir) {
		try {
			ftpClient.changeDirectory(dir);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		try {
			File file = new File("e:\\test.txt");
			FtpConfig ftpConfig = new FtpConfig("192.168.1.210", "tianjs-ftp",
					"123456");
			FtpUtils.upload(file, "test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
