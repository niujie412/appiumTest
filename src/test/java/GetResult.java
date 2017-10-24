import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetResult {
	
	public String GetResult(String value){
		String result=null;
		String parten="\\d\\d\\d\\d";
		Pattern p=Pattern.compile(parten);
		Matcher m=p.matcher(value);
		while(m.find()){
			System.out.println(m.group(0));
			result=m.group(0);
			return result;
		}
		return result;
	}
//	public static void main(String[] args){
//		getResult re=new getResult();
//		re.getResult("验证码:2839，有效时间10分钟，为保护您的账号安全，请勿转发他人或我司员工。下载爱屋吉屋手机客户端：http://t.cn/RPg8Wue");
//	}
}
