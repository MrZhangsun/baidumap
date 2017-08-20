package cn.itheima.bos.bos.baidumap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 百度地图云存储
 * 
 *  @author 长孙建坤 18092853734
 *  @version  1.0 ，2017年7月21日下午6:03:31
 */
public class BaiDuMapStorageTest {

	/**
	 * 创建地理数据表
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void createDataTable() throws UnsupportedEncodingException {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://api.map.baidu.com/geodata/v3/geotable/create");
		
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
		paramsList.add(new BasicNameValuePair("name", "xi'an"));
		paramsList.add(new BasicNameValuePair("geotype", "1"));
		paramsList.add(new BasicNameValuePair("is_published", "1"));
		paramsList.add(new BasicNameValuePair("is_published", "1"));
		paramsList.add(new BasicNameValuePair("ak", "oAlv32CIW7KgAdaHlGmzIajbDtodUBY4"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(paramsList));
		try {
	                HttpResponse response = httpClient.execute(httpPost);
	                HttpEntity entity = response.getEntity();
	                System.out.println(EntityUtils.toString(entity));
                } catch (ClientProtocolException e) {
	                e.printStackTrace();
                } catch (IOException e) {
	                e.printStackTrace();
                }
	}
	
	/**
	 * 获取数据表
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void findTable() throws ClientProtocolException, IOException {
		
		HttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet("http://api.map.baidu.com/geodata/v3/geotable/list?name=xi'an&ak=oAlv32CIW7KgAdaHlGmzIajbDtodUBY4");
		
		HttpResponse execute = httpClient.execute(httpGet);
		System.out.println(execute);
		System.out.println("-------------------------------");
		System.out.println(execute.toString());
		System.out.println("-------------------------------");
		System.out.println(execute.getEntity());
		System.out.println("-------------------------------");
		System.out.println(EntityUtils.toString(execute.getEntity()));
	}
	
	
	/**
	 * 查询指定id表（detail geotable）接口
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void findTableById() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet("http://api.map.baidu.com/geodata/v3/geotable/detail?id=172530&ak=oAlv32CIW7KgAdaHlGmzIajbDtodUBY4");
		
		HttpResponse execute = httpClient.execute(httpGet);
		System.out.println(execute);
		System.out.println("-------------------------------");
		System.out.println(execute.toString());
		System.out.println("-------------------------------");
		System.out.println(execute.getEntity());
		System.out.println("-------------------------------");
		System.out.println(EntityUtils.toString(execute.getEntity()));
	}
	
	/**
	 * 创建列
	 * 
	 * http://api.map.baidu.com/geodata/v3/column/create
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void updateColumn() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost("http://api.map.baidu.com/geodata/v3/column/create");
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("geotable_id", "172528"));
		nameValuePairs.add(new BasicNameValuePair("name", "111"));
		nameValuePairs.add(new BasicNameValuePair("key", "sex"));
		nameValuePairs.add(new BasicNameValuePair("type", "3"));
		nameValuePairs.add(new BasicNameValuePair("max_length", "512"));
		nameValuePairs.add(new BasicNameValuePair("is_sortfilter_field", "0"));
		nameValuePairs.add(new BasicNameValuePair("is_search_field", "1"));
		nameValuePairs.add(new BasicNameValuePair("is_index_field", "1"));
		nameValuePairs.add(new BasicNameValuePair("is_unique_field", "1"));
		nameValuePairs.add(new BasicNameValuePair("ak", "oAlv32CIW7KgAdaHlGmzIajbDtodUBY4"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpResponse response = httpClient.execute(httpPost);
		System.out.println(EntityUtils.toString(response.getEntity()));
		//\u6210\u529f
	}
	
	@Test
	public void createPosition() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://api.map.baidu.com/geodata/v3/poi/create");
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		nameValuePairs.add(new BasicNameValuePair("ak", "oAlv32CIW7KgAdaHlGmzIajbDtodUBY4"));
		nameValuePairs.add(new BasicNameValuePair("geotable_id", "153944"));
		nameValuePairs.add(new BasicNameValuePair("title", "好嫂子"));
		nameValuePairs.add(new BasicNameValuePair("address", "海淀区建材城西路xx号"));
		nameValuePairs.add(new BasicNameValuePair("latitude", "39.899552"));
		nameValuePairs.add(new BasicNameValuePair("longitude", "116.647367"));
		nameValuePairs.add(new BasicNameValuePair("coord_type", "3"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpResponse response = httpClient.execute(httpPost);
		System.out.println(EntityUtils.toString(response.getEntity()));
		
	}
}
