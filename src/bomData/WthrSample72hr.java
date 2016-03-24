package bomData;

public class WthrSample72hr {
	//Data types provided by BOM
	private String localDateTime;
	private String localDateTimeFull;
	private String apparentT;
	private String cloud;
	private String gustKmh;
	private String gustKt;
	private String airTemp;
	private String relHumidity;
	private String dewPt;
	private String windDir;
	private String windSpdKmh;
	private String windSpdKt;
	
	public WthrSample72hr(String localDateTime, String localDateTimeFull, String apparentT, String cloud, String gustKmh, String gustKt, String airTemp,
			String relHumidity, String dewPt, String windDir, String windSpdKmh, String windSpdKt) {
		
		this.localDateTime = localDateTime;
		this.localDateTimeFull = localDateTimeFull;
		this.apparentT = apparentT;
		this.cloud = cloud;
		this.gustKmh = gustKmh;
		this.gustKt = gustKt;
		this.airTemp = airTemp;
		this.relHumidity = relHumidity;
		this.dewPt = dewPt;
		this.windDir = windDir;
		this.windSpdKmh = windSpdKmh;
		this.windSpdKt = windSpdKt;
	}
	
	public String toString()
	{
		String output = new String("Date: ");
		output += localDateTime;
		output += "\nApparent temperature: ";
		output += apparentT;
		output += "\nCloud: ";
		output += cloud;
		output += "\nHumidity: ";
		output += relHumidity;
		output += "\ntoString for WthrSample not fully implemented.\n";
		return output;
	}
	
	public String getLocalDateTime() {
		return localDateTime;
	}
	
	public String getLocalDateTimeFull() {
		return localDateTimeFull;
	}
	
	public String getApparentT() {
		return apparentT;
	}
	
	public String getCloud() {
		return cloud;
	}
	
	public String getGustKmh() {
		return gustKmh;
	}
	
	public String getGustKt() {
		return gustKt;
	}
	
	public String getAirTemp() {
		return airTemp;
	}
	
	public String getRelHumidity() {
		return relHumidity;
	}
	
	public String getDewPt() {
		return dewPt;
	}
	
	public String getWindDir() {
		return windDir;
	}
	
	public String getWindSpdKmh() {
		return windSpdKmh;
	}
	
	public String getWindSpdKt() {
		return windSpdKt;
	}
}