package com.huaming.test.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.alibaba.fastjson.JSONObject;

/**
 * httpClient请求辅助类
 * 
 * @author gxl
 *
 */
public class HttpUtils {
	/**
	 * http post 请求 报文为json
	 * 
	 * @param url
	 * @param json
	 */
	public static String doPostWithJson(String url, String json) {
		HttpClient httpClient = getHttpClient();
		PostMethod post = null;
		try {
			post = new PostMethod(url);
			// 设置头消息
			post.setRequestHeader("Content-type", "application/json; charset=utf-8");
			post.setRequestHeader("Connection", "Close");
			// 剩下的自定义透消息
		//	json = new String(Base64.encodeBase64(json.getBytes("utf-8")));
			System.out.println("加密后的json" + json);
			// 构建消息实体
			RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
			// 将消息体放入Post请求里
			post.setRequestEntity(entity);
			// 开始进行请求
			int status = httpClient.executeMethod(post);

			String response = post.getResponseBodyAsString();

			if (status == HttpStatus.SC_OK) {
				// 表示请求成功
				System.out.println(response);
			} else {
				// 表示请求失败,这里需要写失败后的操作
			}
			// 释放连接
			post.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
			return response;
		} catch (Exception e) {
			if (post != null) {
				post.releaseConnection();
			}
			e.printStackTrace();
		} finally {
			if (post != null) {
				try {
					post.releaseConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	
	public static void main(String[] args) {
		Map <String,String> map = new HashMap<String,String>();
		map.put("custId", "20171225000000000000000223855985");
		map.put("traCd", "07");
		map.put("traAmt", "100");
		map.put("seqNo", "20171225000000001");
		
		String json = JSONObject.toJSONString(map);
		doPostWithInternalJson("http://10.100.143.32:10102/ws/rs/deductCBPaccountBalance",json);
	}
	//不加密内部系统调用
	public static String doPostWithInternalJson(String url, String json) {
		HttpClient httpClient = getHttpClient();
		PostMethod post = null;
		try {
			post = new PostMethod(url);
			// 设置头消息
			post.setRequestHeader("Content-type", "application/json; charset=utf-8");
			post.setRequestHeader("Connection", "Close");
			// 剩下的自定义透消息
			// 构建消息实体
			RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
			// 将消息体放入Post请求里
			post.setRequestEntity(entity);
			// 开始进行请求
			int status = httpClient.executeMethod(post);

			String response = post.getResponseBodyAsString();

			if (status == HttpStatus.SC_OK) {
				// 表示请求成功
				System.out.println(response);
				System.out.println(new String(response.getBytes("ISO-8859-1"), "utf-8"));
			} else {
				// 表示请求失败,这里需要写失败后的操作
			}
			// 释放连接
			post.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
			return response;
		} catch (Exception e) {
			if (post != null) {
				post.releaseConnection();
			}
			e.printStackTrace();
		} finally {
			if (post != null) {
				try {
					post.releaseConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	
	
	/**
	 * http post 请求 报文为xml
	 * 
	 * @param url
	 * @param xml
	 */
	public static String doPostWithXml(String url, String xml) {
		HttpClient httpClient = getHttpClient();
		PostMethod post = null;
		try {
			post = new PostMethod(url);
			// 设置头消息
			post.setRequestHeader("Content-type", "text/xml; charset=utf-8");
			post.setRequestHeader("Connection", "Close");
			// 剩下的自定义透消息
			//xml = new String(Base64.encodeBase64(xml.getBytes("utf-8")));
			// 构建消息实体
			RequestEntity entity = new StringRequestEntity(xml, "text/xml", "utf-8");
			// 将消息体放入Post请求里
			post.setRequestEntity(entity);
			// 设置请求重试处理，用的是默认的重试处理：请求三次
			post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			// 开始进行请求
			int status = httpClient.executeMethod(post);

			String response = post.getResponseBodyAsString();

			if (status == HttpStatus.SC_OK) {
				//response = new String(Base64.decodeBase64(response));
				// 表示请求成功
				System.out.println(response);
			} else {
				// 表示请求失败,这里需要写失败后的操作
			}
			// 释放连接
			post.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
			return response;
		} catch (Exception e) {
			if (post != null) {
				post.releaseConnection();
			}
			e.printStackTrace();
		} finally {
			if (post != null) {
				try {
					post.releaseConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * 设置http请求的超时等公共参数
	 * 
	 * @return
	 */
	public static HttpClient getHttpClient() {
		HttpClient httpClient = new HttpClient();
		// 设置超时时间
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(3000);
		return httpClient;
	}

	/**
	 * get 请求
	 * 参数直接拼在url后面,传过来即可
	 * @return
	 */
	public String doGet(String url) {
		HttpClient httpClient = getHttpClient();
		GetMethod getMethod = new GetMethod(url);
		String response = null;
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			/* 4 判断访问的状态码 */
			if (statusCode == HttpStatus.SC_OK) {
				response = getMethod.getResponseBodyAsString();
			}else{
				System.err.println("请求出错: " + getMethod.getStatusLine());
			}
			getMethod.releaseConnection();
			return response;
		} catch (Exception e) {
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				try {
					getMethod.releaseConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return response;
	}
}
