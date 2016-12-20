package cn.edu.bjtu.weibo.immplement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import cn.edu.bjtu.weibo.dao.GetUserAccordingWeiboImpl;
import cn.edu.bjtu.weibo.dao.GetWeiboAccordingTime;
import cn.edu.bjtu.weibo.dao.GetWeiboAccordingTimeImpl;
import cn.edu.bjtu.weibo.model.Weibo;
import cn.edu.bjtu.weibo.service.*;

public class HotUserWeiboServiceImpl implements HotUserWeiboService{

	@Override
	public List<Weibo> HotUserWeiboList(String userId, int pageIndex, int numberPerPage) {
		// TODO Auto-generated method stub
		List<Weibo> weibolist = new ArrayList <Weibo> ();
		weibolist=getallhotnum();
		return weibolist;
	}
	public List<Weibo> getallhotnum()
	{
		Map<Weibo, Double> map = new TreeMap<Weibo, Double>();

		List<Weibo> weibolist = new ArrayList <Weibo> ();
		List<Weibo> resultweibolist = new ArrayList <Weibo> ();
		weibolist= readALLweibo();
		for(int i=0;i<weibolist.size();i++)
		{
			map.put(weibolist.get(i), gethotNum(weibolist.get(i)));
		}


		Map<Weibo, Double> resultMap = sortMapByValue(map);
		Iterator it = resultMap.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry entry = (Map.Entry) it.next();  
            resultweibolist.add((Weibo) entry.getKey());
        }
		return resultweibolist;  
	}

	public List<Weibo> readALLweibo()
	{
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String Starttime=dateFormat.format( now );

		String oneHoursAgoTime =  "" ;
		Calendar cal = Calendar. getInstance ();
		cal.set(Calendar. HOUR , Calendar. HOUR -1 ) ; //把时间设置为当前时间-1小时，同理，也可以设置其他时间
		cal.set(Calendar. MONTH , Calendar. MONTH -1); //当前月前一月
		oneHoursAgoTime =  new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format(cal.getTime());//获取到完整的时间


		GetWeiboAccordingTimeImpl gw = new GetWeiboAccordingTimeImpl();
		List<Weibo> list = new ArrayList <Weibo> ();
		list = gw.getWeiboList(Starttime, oneHoursAgoTime);
		return list;
	}
	
	
	public static Map<Weibo, Double> sortMapByValue(Map<Weibo, Double> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<Weibo, Double> sortedMap = new LinkedHashMap<Weibo, Double>();
		List<Map.Entry<Weibo, Double>> entryList = new ArrayList<Map.Entry<Weibo, Double>>(
				oriMap.entrySet());
		Collections.sort(entryList, new MapValueComparator());

		Iterator<Map.Entry<Weibo, Double>> iter = entryList.iterator();
		Map.Entry<Weibo, Double> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}
	public double gethotNum(Weibo weibo)
	{
		GetUserAccordingWeiboImpl gu = new GetUserAccordingWeiboImpl();
		double hotnum = weibo.getCommentNumber()+weibo.getLike()+Math.sqrt(weibo.getForwardNumber())+Math.log10(gu.getuser(weibo).getFollow()+1);
		return hotnum;
	}



}




class MapValueComparator implements Comparator<Map.Entry<Weibo, Double>> {

	@Override
	public int compare(Entry<Weibo, Double> o1, Entry<Weibo, Double> o2) {
		// TODO Auto-generated method stub
		if(o1.getValue()>o2.getValue())
			return 1;
		else if(o1.getValue()<o2.getValue())
			return -1;
		else
			return 0;
	}
}